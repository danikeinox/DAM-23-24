package dam2.dcabrera.actividad3pantalles;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.TextView;

public class Auth extends AppCompatActivity {

    private TextView txNombre;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);

        txNombre = findViewById(R.id.tx_nombreAuth);

        // Recuperar los datos del Bundle
        Bundle auth = getIntent().getExtras();
        if (auth != null) {
            String nombre = auth.getString("tx_nombre");

            // Mostrar los datos en la vista
            txNombre.setText(nombre);
        }
    }
}
