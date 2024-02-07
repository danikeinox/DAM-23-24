package daniel.cabrera.spotifray;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaTimestamp;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

public class ServeiMusica extends Service {

    private MediaPlayer mRep;
    private int[] canciones = {R.raw.cancion1, R.raw.cancion2, R.raw.cancion3};
    private int currentIndex = 0;
    private float updateVolume;
    private boolean autoplay = false;

    private MediaTimestamp currentProgress = null;
    private boolean cambiarCancion = false;

    private Handler mainHandler;


    public static final String BROADCAST_MUSIC_PROGRESS = "daniel.cabrera.spotifray.BROADCAST_MUSIC_PROGRESS";
    public static final String CURRENT_PROGRESS_KEY = "currentProgress";
    public static final String TOTAL_DURATION_KEY = "totalDuration";
    public static String UPDATE_VOLUME = "updateVolume";
    public static String UPDATE_AUTOPLAY = "updateAutoplay";


    // Binder local para el servicio
    private final IBinder binder = new LocalBinder();

    // Acción de transmisión para el estado de la música
    public static final String BROADCAST_MUSIC_STATE = "daniel.cabrera.spotifray.BROADCAST_MUSIC_STATE";

    public class LocalBinder extends Binder {
        ServeiMusica getService() {
            return ServeiMusica.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Obtén el Handler principal
        mainHandler = new Handler(Looper.getMainLooper());

        // Registra un BroadcastReceiver para recibir el broadcast del volumen actualizado
        IntentFilter intentFilter = new IntentFilter(UPDATE_VOLUME);
        registerReceiver(volumeUpdateReceiver, intentFilter);

        IntentFilter intentAutoPlay = new IntentFilter(UPDATE_AUTOPLAY);
        registerReceiver(autoPlayUpdateReceiver, intentAutoPlay);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        cambiarCancion = intent.getBooleanExtra("cambiarCancion", false);

        if (cambiarCancion) {
            cambiarCancion();
        } else {
            if (mRep == null) {
                createMusicPlayer();
            } else {
                controlMusica();
            }
            sendMusicStateBroadcast(mRep.isPlaying());
        }
        return START_STICKY;
    }

    public void createMusicPlayer() {
        mRep = MediaPlayer.create(this, canciones[currentIndex]);
        mRep.setLooping(autoplay);
        if (updateVolume != 0){
        mRep.setVolume(updateVolume / 100, updateVolume / 100); // Ajusta el volumen de 0.0 a 1.0
        } else {
        mRep.setVolume(0.5f, 0.5f);
        }
        currentProgress = mRep.getTimestamp();
        mRep.start();
        sendMusicProgressBroadcast(currentProgress, mRep.getDuration());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRep != null) {
            if (mRep.isPlaying()) mRep.stop();
            mRep.release();
            mRep = null;
        }
        unregisterReceiver(volumeUpdateReceiver);
        unregisterReceiver(autoPlayUpdateReceiver);
    }

    private void cambiarCancion() {
        currentIndex = (currentIndex + 1) % canciones.length;
        if (mRep != null) {
            if (mRep.isPlaying()) mRep.stop();
            mRep.release();
            mRep = null;
        }
        createMusicPlayer();

        // Envía un broadcast con el nuevo estado de la música
        sendMusicStateBroadcast(true);
    }

    public void controlMusica() {
        if (mRep != null) {
            if (!mRep.isPlaying()) {
                mRep.start();
            } else {
                mRep.pause();
            }
        }
    }

    private BroadcastReceiver volumeUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(UPDATE_VOLUME)) {
                // Actualiza el volumen del MediaPlayer con el volumen recibido del broadcast
                float volume = intent.getFloatExtra(UPDATE_VOLUME, 0);
                updateVolume(volume);
            }
        }
    };

    // Método para actualizar el volumen en el MediaPlayer
    private void updateVolume(float volume) {
        if (mRep != null) {
            mRep.setVolume(volume / 100, volume / 100); // Ajusta el volumen de 0.0 a 1.0
            sendVolumeUpdateBroadcast(volume); // Solo envía el broadcast si es necesario
        }
    }

    private BroadcastReceiver autoPlayUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(UPDATE_AUTOPLAY)) {
                // Actualiza el volumen del MediaPlayer con el volumen recibido del broadcast
                boolean autoplay = intent.getBooleanExtra(UPDATE_AUTOPLAY, false);
                updateAutoPlay(autoplay);
            }
        }
    };

    // Método para actualizar el autoPlay en el MediaPlayer
    private void updateAutoPlay(boolean autoplay) {
        if (mRep != null) {
            mRep.setLooping(autoplay); // Ajusta el autoPlay en false o true
            sendAutoPlayUpdateBroadcast(autoplay); // Solo envía el broadcast si es necesario
        }
    }

    private void sendVolumeUpdateBroadcast(float volume) {
        Intent intent = new Intent(UPDATE_VOLUME);
        intent.putExtra(UPDATE_VOLUME, volume);

        // Utiliza el Handler principal para enviar la transmisión en el hilo principal
        mainHandler.post(() -> sendBroadcast(intent));
    }

    private void sendAutoPlayUpdateBroadcast(boolean autoPlay) {
        Intent intent = new Intent(UPDATE_AUTOPLAY);
        intent.putExtra(UPDATE_AUTOPLAY, autoPlay);

        // Utiliza el Handler principal para enviar la transmisión en el hilo principal
        mainHandler.post(() -> sendBroadcast(intent));
    }


    // Método para enviar un broadcast con el progreso de la musica con el Slider
    private void sendMusicProgressBroadcast(MediaTimestamp currentProgress, int totalDuration) {
        Intent intent = new Intent(BROADCAST_MUSIC_PROGRESS);
        intent.putExtra(CURRENT_PROGRESS_KEY, String.valueOf(currentProgress));
        intent.putExtra(TOTAL_DURATION_KEY, totalDuration);

        // Utiliza el Handler principal para enviar la transmisión en el hilo principal
        mainHandler.post(() -> sendBroadcast(intent));
    }

    // Método para buscar la duración indicada por el servicio

    public void seekTo(int position) {
        if (mRep != null) {
            mRep.seekTo(position);
        }
    }

    // Método para enviar un broadcast con el estado de la música
    private void sendMusicStateBroadcast(boolean isPlaying) {
        Intent broadcastIntent = new Intent(BROADCAST_MUSIC_STATE);
        broadcastIntent.putExtra("estado", isPlaying);
        sendBroadcast(broadcastIntent);

        // Agrega un log para verificar si se envían las transmisiones correctamente
        Log.d("ServeiMusica", "Sent broadcast: Music State - " + isPlaying);
    }
}
