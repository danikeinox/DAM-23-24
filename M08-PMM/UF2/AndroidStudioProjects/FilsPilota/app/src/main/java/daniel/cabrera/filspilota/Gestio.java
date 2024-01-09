package daniel.cabrera.filspilota;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class Gestio extends AppCompatActivity {
    private Partida partida;
    private int dificultad;
    private int FPS = 30;
    private Handler temporitzador = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extres = getIntent().getExtras();
        dificultad = extres.getInt("DIFICULTAD");
        partida = new Partida(getApplicationContext(), dificultad);
        temporitzador.postDelayed(elMeuFill, 1000/FPS);
        setContentView(partida);
    }

    private Runnable elMeuFill = new Runnable() {
        @Override
        public void run(){
            if(partida.movimentBola()){
                fin();
            } else{
                partida.invalidate();
                temporitzador.postDelayed(this, 1000/FPS);
            }
        }
    };

    public boolean onTouchEvent(MotionEvent event){
        int x = (int) event.getX();
        int y = (int) event.getY();
        partida.toc(x, y);
        return false;
    }


    private void fin(){
        temporitzador.removeCallbacks(elMeuFill);
        finish();
    }
}
