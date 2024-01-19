package cat.eugeni.pilotafils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dificultad(View boto){
        String dific=(String)((Button) boto).getText();
        int dif=1;
        if (dific.equals("Standard")) dif=2;
        if (dific.equals("Dificult")) dif=3;
        Intent in = new Intent(this, Gestio.class);
        in.putExtra("DIFICULTAT",dif);
        startActivity(in);
    }

}