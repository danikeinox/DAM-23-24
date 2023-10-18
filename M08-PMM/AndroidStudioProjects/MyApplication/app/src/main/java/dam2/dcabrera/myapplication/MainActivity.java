package dam2.dcabrera.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView txDisplay;
private Button btMesUn;
private Button btMenysUn;
private Button btZero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txDisplay = findViewById(R.id.display);
        btMenysUn = findViewById(R.id.menysUn);
        btMesUn = findViewById(R.id.mesUn);
        btZero = findViewById(R.id.zero);
    }

    public void suma(View view) {
        int display = Integer.parseInt((String) txDisplay.getText());
        display++;
        txDisplay.setText(Integer.toString(display));
    }
    public void resta(View view) {
        int display = Integer.parseInt((String) txDisplay.getText());
        display--;
        txDisplay.setText(Integer.toString(display));
    }
    public void zero(View view) {
        int display = Integer.parseInt((String) txDisplay.getText());
        display=0;
        txDisplay.setText(Integer.toString(display));
    }
}

