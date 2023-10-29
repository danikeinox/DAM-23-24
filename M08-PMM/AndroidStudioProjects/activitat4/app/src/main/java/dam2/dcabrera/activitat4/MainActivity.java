package dam2.dcabrera.activitat4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private int difJoc;
    private int[] caselles = new int[9];
    private Joc3R joc;
    private int nJugadors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caselles[0] = R.id.A1;
        caselles[1] = R.id.A2;
        caselles[2] = R.id.A3;
        caselles[3] = R.id.B1;
        caselles[4] = R.id.B2;
        caselles[5] = R.id.B3;
        caselles[6] = R.id.C1;
        caselles[7] = R.id.C2;
        caselles[8] = R.id.C3;
    }

    public void juguemHi(View view){
        ImageView img;

        for(int casella: caselles){
            img = (ImageView) findViewById(casella);
            img.setImageResource(R.drawable.casella);
        }

        nJugadors = 1;
        if(view.getId()==R.id.dosjug){
            nJugadors = 2;
        }

        RadioGroup confDir = (RadioGroup) findViewById(R.id.cnfRad);
        difJoc = 0;
        int id = confDir.getCheckedRadioButtonId();
        if (id == R.id.normal) {
            difJoc = 1;
        } else if (id == R.id.impo) {
            difJoc = 2;
        }

        joc=new Joc3R(difJoc);
        ((Button) findViewById(R.id.unjug)).setEnabled(false);
        ((Button) findViewById(R.id.dosjug)).setEnabled(false);
        ((RadioGroup) findViewById(R.id.cnfRad)).setAlpha(0);

        RadioGroup rg = (RadioGroup) findViewById(R.id.cnfRad);
        int selectedId = rg.getCheckedRadioButtonId();

        if(selectedId==-1){
            return;
        } else {
            difJoc = rg.getCheckedRadioButtonId();
        }
    }

    public void tocCasella(View vistaCasella) {
        int casella=0;
        if (joc==null){
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (caselles[i] == vistaCasella.getId()) {
                casella = i;
            }
        }
        if (joc.checkCasella(casella) == true) {
            marcaCasella(casella);
        }
        else return;


        if(nJugadors == 1) {
            joc.torn();
            casella = joc.jugaMaquina();
            while(joc.checkCasella(casella) != true){
                casella = joc.jugaMaquina();
            }
        }

        marcaCasella(casella);
        joc.torn();
    }

    public void marcaCasella(int casella){
        ImageView img;
        img = (ImageView) findViewById(caselles[casella]);
        if(joc.jugador == 1) {
            img.setImageResource(R.drawable.cercle);
        } else {
            img.setImageResource(R.drawable.creu);
        }

    }
}