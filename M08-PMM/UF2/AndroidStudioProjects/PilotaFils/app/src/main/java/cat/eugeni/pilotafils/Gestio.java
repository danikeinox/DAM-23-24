package cat.eugeni.pilotafils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;



public class Gestio extends AppCompatActivity {
    private Partida partida;
    private int dificultat;
    private int FPS= 30;
    private Handler temporitzador= new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extres=getIntent().getExtras();
        dificultat=extres.getInt("DIFICULTAT");
        partida = new Partida(getApplicationContext(), dificultat);
        temporitzador.postDelayed(elMeuFil,1000/FPS);
        setContentView(partida);
    }

    private Runnable elMeuFil=new Runnable(){
        @Override
        public void run(){
            if(partida.movimentBola()){
                fin();
            }
            else{
                partida.invalidate(); //Eliminar tot del imageView i repitar-ho onDraw()
                temporitzador.postDelayed(elMeuFil,1000/FPS);
            }
        }
    };

    public boolean onTouchEvent(MotionEvent event){
        int x=(int) event.getX();
        int y=(int) event.getY();
        partida.toc(x,y);
        return false;
    }
    public void fin(){
        temporitzador.removeCallbacks(elMeuFil);
        finish();
    }
}