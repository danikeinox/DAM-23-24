package cat.eugeni.pilotafils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class Gestio extends AppCompatActivity {
    private List<Partida> listaPelotas;
    private int dificultat;
    private int tempsPilota = 5000;
    private int FPS = 30;
    private Handler temporitzador = new Handler();
    private Handler temporizadorNuevaPelota = new Handler();
    private FrameLayout contenedorPelotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extres = getIntent().getExtras();
        dificultat = extres.getInt("DIFICULTAT");

        // Crear un contenedor para las pelotas
        contenedorPelotas = new FrameLayout(this);
        setContentView(contenedorPelotas);

        // Inicializa la lista de pelotas antes de utilizarla
        listaPelotas = new ArrayList<>();

        // Crea una primera pelota y agrégala a la lista
        agregarPelota();

        temporitzador.postDelayed(elMeuFil, 1000 / FPS);
        temporizadorNuevaPelota.postDelayed(nuevaPelota, tempsPilota);
    }

    private Runnable nuevaPelota = new Runnable() {
        @Override
        public void run() {
            agregarPelota();
            temporizadorNuevaPelota.postDelayed(this, tempsPilota);
        }
    };

    private void agregarPelota() {
        Partida nuevaPelota = new Partida(getApplicationContext(), dificultat, listaPelotas);
        listaPelotas.add(nuevaPelota);
        contenedorPelotas.addView(nuevaPelota);
    }

    private Runnable elMeuFil = new Runnable() {
        @Override
        public void run() {
            List<Partida> pelotasEnPantalla = new ArrayList<>();

            for (Partida pelota : listaPelotas) {
                if (pelota.movimentBola()) {
                    // Pelota fuera de pantalla, no la añadas a la nueva lista
                    continue;
                } else {
                    pelotasEnPantalla.add(pelota);
                    pelota.invalidate();
                }
            }

            // Reemplaza la lista original con las pelotas que siguen en pantalla
            listaPelotas.clear();
            listaPelotas.addAll(pelotasEnPantalla);

            if (listaPelotas.isEmpty()) {
                // Si no hay pelotas en pantalla, el juego ha terminado
//                Log.d("Fin del juego", "El juego ha terminado.");
                fin();
            }

            temporitzador.postDelayed(elMeuFil, 1000 / FPS);
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        // Asegúrate de que haya pelotas en la lista antes de llamar a la función toc
        for (Partida pelota : listaPelotas) {
            pelota.toc(x, y);
        }

        return false;
    }

    public void fin(){
        temporitzador.removeCallbacks(elMeuFil);
        temporizadorNuevaPelota.removeCallbacks(nuevaPelota);

        finish();
    }
}
