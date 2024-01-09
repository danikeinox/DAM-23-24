package dam2.dcabrera.actividad3pantalles;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.TextView;

public class Tarjeta extends AppCompatActivity {

    private TextView txNombre;
    private TextView txApellido;
    private TextView txCorreo;
    private TextView txTelefono;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarjeta);

        txNombre = findViewById(R.id.tx_nombre_tarjeta);
        txApellido = findViewById(R.id.tx_apellido_tarjeta);
        txCorreo = findViewById(R.id.tx_correo_tarjeta);
        txTelefono = findViewById(R.id.tx_telefono_tarjeta);

        // Recuperar los datos del Bundle
        Bundle tarjeta = getIntent().getExtras();
        if (tarjeta != null) {
            String nombre = tarjeta.getString("tx_nombre");
            String apellido = tarjeta.getString("tx_apellido");
            String correo = tarjeta.getString("tx_correo");
            String telefono = tarjeta.getString("tx_telefono");

            // Mostrar los datos en la vista
            txNombre.setText(nombre);
            txApellido.setText(apellido);
            txCorreo.setText(correo);
            txTelefono.setText(telefono);
        }
    }
}
