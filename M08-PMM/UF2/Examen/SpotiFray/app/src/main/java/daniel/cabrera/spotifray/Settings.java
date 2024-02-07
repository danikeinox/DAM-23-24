package daniel.cabrera.spotifray;

import static daniel.cabrera.spotifray.ServeiMusica.BROADCAST_MUSIC_PROGRESS;
import static daniel.cabrera.spotifray.ServeiMusica.CURRENT_PROGRESS_KEY;
import static daniel.cabrera.spotifray.ServeiMusica.TOTAL_DURATION_KEY;
import static daniel.cabrera.spotifray.ServeiMusica.UPDATE_AUTOPLAY;
import static daniel.cabrera.spotifray.ServeiMusica.UPDATE_VOLUME;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity implements CommMenu {

    private SeekBar sVolumeMusic;
    private CheckBox cbAutoPlay;
    private float updateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Inicializa tu SeekBar
        sVolumeMusic = findViewById(R.id.slVolume);
        cbAutoPlay = findViewById(R.id.cbAutoPlay);


        // Registra un BroadcastReceiver para recibir el broadcast del volumen actualizado
        IntentFilter intentFilter = new IntentFilter(UPDATE_VOLUME);
        registerReceiver(volumeUpdateReceiver, intentFilter);

        IntentFilter intentAutoPlay = new IntentFilter(UPDATE_AUTOPLAY);
        registerReceiver(autoPlayUpdateReceiver, intentAutoPlay);

        // Establecer un listener para el checkbox de autoplay

        cbAutoPlay.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Intent intent = new Intent(Settings.this, ServeiMusica.class);
            intent.putExtra(UPDATE_AUTOPLAY, isChecked);
            startService(intent);
        });

        // Establece un Listener para tu SeekBar
        sVolumeMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // No es necesario hacer nada aquí para el momento
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No es necesario hacer nada aquí para el momento
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Actualiza el volumen en el servicio cuando el usuario ajusta la SeekBar
                Intent intent = new Intent(Settings.this, ServeiMusica.class);
                intent.putExtra(UPDATE_VOLUME, sVolumeMusic.getProgress());
                startService(intent);
            }
        });
    }

    // BroadcastReceiver para recibir el broadcast del volumen actualizado
    private BroadcastReceiver volumeUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(UPDATE_VOLUME)) {
                // Actualiza la SeekBar con el volumen recibido del broadcast
                updateVolume = intent.getFloatExtra(UPDATE_VOLUME, 0);
                sVolumeMusic.setProgress((int) updateVolume);
            }
        }
    };

    // BroadcastReceiver para recibir el broadcast del AutoPlay actualizado
    private BroadcastReceiver autoPlayUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(UPDATE_VOLUME)) {
                // Actualiza la SeekBar con el volumen recibido del broadcast
                updateVolume = intent.getFloatExtra(UPDATE_VOLUME, 0);
                sVolumeMusic.setProgress((int) updateVolume);
            }
        }
    };

    // Método para manejar el menú
    public void menu(int qBoto){
        Intent in=new Intent(this,Eines.class);
        in.putExtra("BotoPres",qBoto);
        startActivity(in);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Debes desregistrar el BroadcastReceiver cuando la actividad se destruya
        unregisterReceiver(volumeUpdateReceiver);
    }
}