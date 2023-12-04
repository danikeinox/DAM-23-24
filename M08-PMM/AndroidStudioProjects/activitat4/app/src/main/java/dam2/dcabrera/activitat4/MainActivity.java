package dam2.dcabrera.activitat4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int difJoc;
    private int[] caselles = new int[9];
    private Joc3R joc;
    private int nJugadors;
    private TextView tx_winner;
    private TextView tx_winsCercles;
    private TextView tx_winsCreus;
    private Button bt_score;
    private int cerclesCount = 0;
    private int creusCount = 0;
    private BBDD_Helper mBDHelper = new BBDD_Helper(this);
    private int id;
    private int BDid;

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
        tx_winner = (TextView) findViewById(R.id.tx_winner);
        tx_winsCercles = (TextView) findViewById(R.id.tx_winsCercles);
        tx_winsCreus = (TextView) findViewById(R.id.tx_winsCreus);
        tx_winsCercles.setText(String.valueOf(cerclesCount));
        tx_winsCreus.setText(String.valueOf(creusCount));
        bt_score = (Button) findViewById(R.id.bt_score);
        tx_winsCercles.setText(String.valueOf(cerclesCount));
        tx_winsCreus.setText(String.valueOf(creusCount));
    }

    public void onClickScore(View view) {
        Intent intent = new Intent(this, ScoreListActivity.class);
        intent.putExtra("cercles", cerclesCount);
        intent.putExtra("creus", creusCount);
        intent.putExtra("nJugadors", nJugadors);
        startActivity(intent);
    }

    public void juguemHi(View view) {
        tx_winner.setText("");
        ImageView img;
        onClickStartBD();

        for (int casella : caselles) {
            img = (ImageView) findViewById(casella);
            img.setImageResource(R.drawable.casella);
        }

        nJugadors = 1;
        if (view.getId() == R.id.dosjug) {
            nJugadors = 2;
            onClickStartBD();
        }

        RadioGroup confDir = (RadioGroup) findViewById(R.id.cnfRad);
        difJoc = 0;
        int id = confDir.getCheckedRadioButtonId();
        if (id == R.id.normal) {
            difJoc = 1;
        } else if (id == R.id.impo) {
            difJoc = 2;
        }

        joc = new Joc3R(difJoc);
        ((Button) findViewById(R.id.unjug)).setEnabled(false);
        ((Button) findViewById(R.id.dosjug)).setEnabled(false);
        ((RadioGroup) findViewById(R.id.cnfRad)).setAlpha(0);

        RadioGroup rg = (RadioGroup) findViewById(R.id.cnfRad);
        int selectedId = rg.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return;
        } else {
            difJoc = rg.getCheckedRadioButtonId();
        }
    }

    public int onClickStartBD() {
        // get COLUMN_ID from SQLite and get the last value and add it to BDid
        SQLiteDatabase db = mBDHelper.getReadableDatabase();
        String[] projection = {Estruct_BBDD.COLUMN_ID};
        String sortOrder = Estruct_BBDD.COLUMN_ID + " DESC";
        Cursor cursor = db.query(Estruct_BBDD.TABLE_NAME, projection, null, null, null, null, sortOrder);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndexOrThrow(Estruct_BBDD.COLUMN_ID);
            int lastValue = cursor.getInt(columnIndex);
            BDid = lastValue + 1;
        }
        cursor.close();
        return BDid;
    }

    public void tocCasella(View vistaCasella) {
        if (nJugadors != 0) {
            int resTirada;
            int casella = 0;
            if (joc == null) {
                return;
            }
            for (int i = 0; i < 9; i++) {
                if (caselles[i] == vistaCasella.getId()) {
                    casella = i;
                }
            }
            if (joc.checkCasella(casella) == false) {
                return;
            }
            marcaCasella(casella);
            resTirada = joc.torn();
            if (resTirada > 0) {
                finalPartida(resTirada);
                return;
            }
            if (nJugadors == 1) {
                casella = joc.jugaMaquina();
                while (joc.checkCasella(casella) != true) {
                    casella = joc.jugaMaquina();
                }
                marcaCasella(casella);
                resTirada = joc.torn();
                if (resTirada > 0) {
                    finalPartida(resTirada);
                    return;
                }
            }
        }
    }

    public void marcaCasella(int casella) {
        ImageView img;
        img = (ImageView) findViewById(caselles[casella]);
        String casellaDB = getResources().getResourceEntryName(caselles[casella]);
        if (joc.jugador == 1) {
            img.setImageResource(R.drawable.cercle);
            checkDBPlays(casellaDB);
        } else {
            img.setImageResource(R.drawable.creu);
            checkDBPlays(casellaDB);
        }
    }

    public void checkDBPlays(String casella) {
        try {
            SQLiteDatabase db = mBDHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Estruct_BBDD.COLUMN_ID, BDid);
            if (joc.jugador == 1) {
                values.put(Estruct_BBDD.COLUMN_JUG1, casella);
            } else {
                values.put(Estruct_BBDD.COLUMN_JUG2, casella);
            }
            db.insert(Estruct_BBDD.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalPartida(int resT) {
        String missatge;
        if (resT == 1) {
            missatge = "Guanya Cercles";
            cerclesCount++;
        } else if (resT == 2) {
            missatge = "Guanya Creus";
            creusCount++;
        } else missatge = "Empate";
        nJugadors = 0;
        tx_winner.setText(missatge);
        tx_winsCercles.setText(String.valueOf(cerclesCount));
        tx_winsCreus.setText(String.valueOf(creusCount));
        ((Button) findViewById(R.id.unjug)).setEnabled(true);
        ((Button) findViewById(R.id.dosjug)).setEnabled(true);
        ((RadioGroup) findViewById(R.id.cnfRad)).setAlpha(1);
    }

    public void onPause() {
        super.onPause();
        SharedPreferences dades = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = dades.edit(); // fem editable l’objecte
        mEditor.putInt("cerclesCount", cerclesCount);
        mEditor.putInt("creusCount", creusCount);
        mEditor.commit();
    }

    public void onResume() {
        super.onResume();
        SharedPreferences dades = PreferenceManager.getDefaultSharedPreferences(this);
        cerclesCount = dades.getInt("cerclesCount", 0);
        creusCount = dades.getInt("creusCount", 0);
    }
}
