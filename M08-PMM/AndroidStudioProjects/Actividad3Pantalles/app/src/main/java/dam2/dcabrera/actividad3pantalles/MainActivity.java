package dam2.dcabrera.actividad3pantalles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    private EditText tx_nombre;
    private EditText tx_apellido;
    private EditText tx_correo;
    private EditText tx_telefono;
    private Button bt_borrar;
    private Button bt_email;
    private Button bt_registrar;
    private Button bt_tarjeta;
    private Button bt_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_email = findViewById(R.id.bt_email);
        bt_tarjeta = findViewById(R.id.bt_tarjeta);
        bt_registrar = findViewById(R.id.bt_registrar);
        bt_menu = findViewById(R.id.bt_menu);
        bt_borrar = findViewById(R.id.bt_borrar);
        tx_nombre = findViewById(R.id.tx_nombre);
        tx_apellido = findViewById(R.id.tx_apellido);
        tx_correo = findViewById(R.id.tx_correo);
        tx_telefono = findViewById(R.id.tx_telefono);

        bt_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view);
            }
        });
    }

    public void openTarjeta(View view) {
        Intent intent = new Intent(this, Tarjeta.class);
        intent.putExtra("tx_nombre", tx_nombre.getText().toString());
        intent.putExtra("tx_apellido", tx_apellido.getText().toString());
        intent.putExtra("tx_correo", tx_correo.getText().toString());
        intent.putExtra("tx_telefono", tx_telefono.getText().toString());
        startActivity(intent);
    }

    public void openEmail(View view) {
        Intent intent = new Intent(this, Email.class);
        intent.putExtra("tx_correo", tx_correo.getText().toString());
        startActivity(intent);
    }

    public void Registrar(View view) {
        Intent intent = new Intent(this, Auth.class);
        intent.putExtra("tx_nombre", tx_nombre.getText().toString());
        startActivity(intent);
    }

    public void showMenu(View view) {
        // Initializing the popup menu and giving the reference as current context
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, bt_menu);

        // Inflating popup menu from popup_menu.xml file
        popupMenu.getMenuInflater().inflate(R.menu.menuexit, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_exit) {
                    finish(); // Cierra la actividad y la aplicación
                    return true;
                }
                return false;
            }
        });
        // Showing the popup menu
        popupMenu.show();
    }



    public void Exit(View view) {
        finish(); // Cierra la actividad y la aplicación
    }

    public void Borrar(View view) {
        tx_nombre.setText("");
        tx_apellido.setText("");
        tx_correo.setText("");
        tx_telefono.setText("");
    }

    public void Volver(View view) {
        onBackPressed();
    }
}
