package daniel.cabrera.spotifray;

import static daniel.cabrera.spotifray.ServeiMusica.BROADCAST_MUSIC_PROGRESS;
import static daniel.cabrera.spotifray.ServeiMusica.BROADCAST_MUSIC_STATE;
import static daniel.cabrera.spotifray.ServeiMusica.CURRENT_PROGRESS_KEY;
import static daniel.cabrera.spotifray.ServeiMusica.TOTAL_DURATION_KEY;
import static daniel.cabrera.spotifray.ServeiMusica.UPDATE_VOLUME;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MusicPlayer extends Fragment {

    private boolean musOn;
    private boolean cambiarCancion = false;

    private ImageButton bPlay;
    private ImageButton bNext;
    private SeekBar sTimeStamp;

    private int currentProgress;
    private int totalDuration;

    private TextView tvTimeActual;
    private int timeActual = R.id.tvTimeActual;
    private TextView tvTimeTotal;
    private int timeTotal = R.id.tvTimeTotal;

    private ServeiMusica serveiMusica;
    private boolean mBound = false;

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String MUS_ON_KEY = "musOnKey";
    private static final String BPLAY_STATE_KEY = "bPlayStateKey";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public MusicPlayer() {
        // Required empty public constructor
    }

    public static MusicPlayer newInstance(String param1, String param2) {
        MusicPlayer fragment = new MusicPlayer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, 0);
        musOn = prefs.getBoolean(MUS_ON_KEY, false);

        Log.d("MusOn", "MusOn value: " + musOn);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragPlay = inflater.inflate(R.layout.fragment_music_player, container, false);

        bPlay = fragPlay.findViewById(R.id.bt_play);
        bNext = fragPlay.findViewById(R.id.bt_next);
        sTimeStamp = fragPlay.findViewById(R.id.seekBar);
        tvTimeActual = fragPlay.findViewById(R.id.tvTimeActual); // Asegúrate de tener esta línea
        tvTimeTotal = fragPlay.findViewById(R.id.tvTimeTotal);

        bPlay.setImageResource(musOn ? R.drawable.pause_button : R.drawable.play_button);

        bPlay.setOnClickListener(v -> {
            musOn = !musOn;
            actualizarInterfaz(musOn);
        });

        bNext.setOnClickListener(v -> {
            cambiarCancion = true;
            if (!musOn) musOn = true;
            actualizarInterfaz(true);
        });

        sTimeStamp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Solo realiza acciones si el cambio proviene del usuario
                serveiMusica.seekTo(progress);
                tvTimeActual.setText(formatTime(progress));
                if (fromUser && serveiMusica != null) {
                    // Actualiza la posición de reproducción en el servicio
                    serveiMusica.seekTo(progress);

                    // Actualiza tvTimeActual con la posición de reproducción actual
                    String formattedTime = formatTime(progress);
                    tvTimeActual.setText(formattedTime);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Puedes realizar acciones adicionales si es necesario al comenzar a rastrear el tacto
                // Aquí, por ejemplo, pausamos la música
                if (serveiMusica != null) {
                    serveiMusica.controlMusica();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Puedes realizar acciones adicionales si es necesario al detener el rastreo del tacto
                // Aquí, por ejemplo, reanudamos la música después de detener el rastreo
                if (serveiMusica != null) {
                    serveiMusica.controlMusica();
                }
            }
        });

        return fragPlay;
    }

    private void actualizarInterfaz(boolean musOn) {
        int playButtonResource = musOn ? R.drawable.pause_button : R.drawable.play_button;
        MySharedPreferences.setMusOn(requireContext(), musOn);

        Fragment musicaFragment = Musica.newInstance(musOn);
        replaceMusicaFragment(musicaFragment);

        Intent mRep = new Intent(getActivity(), ServeiMusica.class);
        mRep.putExtra("cambiarCancion", cambiarCancion);

        getActivity().startService(mRep);
        bPlay.setImageResource(playButtonResource);

        Log.d("log", "musOn: " + musOn);
        Log.d("log", "cambiarCancion: " + cambiarCancion);

        // Restablecer cambiarCancion a false después de usarlo
        cambiarCancion = false;
    }

    private void replaceMusicaFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.music, fragment).addToBackStack(null).commit();
    }

    public static class MySharedPreferences {

        private static final String PREFS_NAME = "MyPrefsFile";
        private static final String MUS_ON_KEY = "musOnKey";

        public static boolean getMusOn(Context context) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
            return prefs.getBoolean(MUS_ON_KEY, false);
        }

        public static void setMusOn(Context context, boolean musOn) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(MUS_ON_KEY, musOn).apply();
        }
    }

    private BroadcastReceiver musicProgressReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                currentProgress = intent.getIntExtra(CURRENT_PROGRESS_KEY, 0);
                totalDuration = intent.getIntExtra(TOTAL_DURATION_KEY, 0);

                // Actualiza sTimeStamp en tiempo real
                if (totalDuration > 0) {
                    sTimeStamp.setMax(totalDuration);
                    sTimeStamp.setProgress(currentProgress);
                    // Actualiza tvTimeActual en tiempo real
                    tvTimeActual.setText(formatTime(currentProgress));
                    // Actualiza tvTimeTotal en tiempo real
                    tvTimeTotal.setText(formatTime(totalDuration));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private static String formatTime(int milliseconds) {
        int minutes = milliseconds / 1000 / 60;
        int seconds = milliseconds / 1000 % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Registra el receptor para la actualización del progreso de la música
        Log.d("MusicPlayer", "Registering musicProgressReceiver");
        IntentFilter intentFilter = new IntentFilter(BROADCAST_MUSIC_PROGRESS);
        requireActivity().registerReceiver(musicProgressReceiver, intentFilter);

        Intent intent = new Intent(getActivity(), ServeiMusica.class);
        getActivity().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onStop() {
        super.onStop();

        try {
            requireActivity().unregisterReceiver(musicProgressReceiver);
        } catch (IllegalArgumentException ignored) {
            // Manejar la excepción si el receptor no está registrado
            Log.e("MusicPlayer", "musicProgressReceiver Receiver is not registered");
        }

        if (mBound) {
            getActivity().unbindService(connection);
            mBound = false;
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            ServeiMusica.LocalBinder binder = (ServeiMusica.LocalBinder) service;
            serveiMusica = binder.getService();
            mBound = true;
            if (musOn) {
                serveiMusica.controlMusica();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    private boolean isBPlayPlaying() {
        return (bPlay.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.play_button).getConstantState());
    }

    private boolean TotalMusicDuration() {
        return (tvTimeTotal.getText() == formatTime(totalDuration));
    }

    @Override
    public void onResume() {
        super.onResume();

        // Restaura el estado del botón de reproducción
        boolean bPlayState = getActivity().getSharedPreferences(PREFS_NAME, 0)
                .getBoolean(BPLAY_STATE_KEY, false);

        musOn = MySharedPreferences.getMusOn(requireContext());

        Log.d("MusOn", "MusOn value on onResume: " + musOn);

        // Si musOn es verdadero y la música no estaba en reproducción antes de pausar la aplicación,
        // inicia la música automáticamente
        if (musOn && bPlayState) {
            // Verifica que el servicio esté vinculado antes de acceder a sus métodos
            if (serveiMusica != null) {
                // Actualiza el estado de la interfaz basado en la música actual
                serveiMusica.controlMusica();
                bPlay.setImageResource(musOn ? R.drawable.play_button : R.drawable.pause_button);
                actualizarInterfaz(musOn);
            }
        }
        // Si musOn es falso y la música estaba en reproducción antes de pausar la aplicación,
        // pausa la música automáticamente
        else if (!musOn && !bPlayState) {
            // Verifica que el servicio esté vinculado antes de acceder a sus métodos
            if (serveiMusica != null) {
                serveiMusica.controlMusica();
                bPlay.setImageResource(musOn ? R.drawable.play_button : R.drawable.pause_button);
                actualizarInterfaz(musOn);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Desregistra el receptor de progreso de la música si es necesario
        try {
            requireActivity().unregisterReceiver(musicProgressReceiver);
        } catch (IllegalArgumentException ignored) {
            // Manejar la excepción si el receptor no está registrado
            Log.e("MusicPlayer", "musicProgressReceiver Receiver is not registered");
        }

        // Desvincula el servicio y anula el registro del receptor si es necesario
        if (mBound) {
            getActivity().unbindService(connection);
            mBound = false;
        }
        try {
            requireActivity().unregisterReceiver(musicStateReceiver);
        } catch (IllegalArgumentException ignored) {
            // Manejar la excepción si el receptor no está registrado
            Log.e("MusicPlayer", "musicStateReceiver Receiver is not registered");
        }
    }

    private BroadcastReceiver musicStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            currentProgress = intent.getIntExtra(CURRENT_PROGRESS_KEY, 0);
            totalDuration = intent.getIntExtra(TOTAL_DURATION_KEY, 0);

            Log.d("MusicPlayer", "Broadcast received: Current Progress - " + currentProgress + ", Total Duration - " + totalDuration);

            // Actualiza sTimeStamp y tvTimeActual
            if (totalDuration > 0) {
                sTimeStamp.setMax(totalDuration);
                sTimeStamp.setProgress(currentProgress);

                // Puedes formatear el tiempo como desees (por ejemplo, en formato mm:ss)
                tvTimeActual.setText(formatTime(currentProgress));
                tvTimeTotal.setText(formatTime(totalDuration));

                Log.d("MusicPlayer", "Updating UI with progress: " + currentProgress);
            }
            musOn = intent.getBooleanExtra("estado", false);
            actualizarInterfaz(musOn);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(MUS_ON_KEY, musOn);
        editor.putBoolean(BPLAY_STATE_KEY, isBPlayPlaying());
        editor.apply();
        if (musOn) {
            serveiMusica.controlMusica();
        }
        bPlay.setImageResource(isBPlayPlaying() ? R.drawable.play_button : R.drawable.pause_button);
        tvTimeTotal.setText(formatTime(totalDuration));
    }
}
