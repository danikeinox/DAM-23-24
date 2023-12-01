package dam2.dcabrera.actividad3pantalles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText tx_nombre;
    private EditText tx_id;
    private EditText tx_apellido;
    private EditText tx_correo;
    private EditText tx_telefono;
    private Button bt_borrar;
    private Button bt_email;
    private Button bt_registrar;
    private Button bt_delete;
    private Button bt_update;
    private Button bt_search;
    private Button bt_left;
    private Button bt_right;
    private Button bt_tarjeta;
    private Button bt_menu;
    private BBDD_Helper mBDHelper = new BBDD_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_email = findViewById(R.id.bt_email);
        bt_tarjeta = findViewById(R.id.bt_tarjeta);
        bt_registrar = findViewById(R.id.bt_registrar);
        bt_delete = findViewById(R.id.bt_delete);
        bt_update = findViewById(R.id.bt_update);
        bt_search = findViewById(R.id.bt_search);
        bt_left = findViewById(R.id.bt_left);
        bt_right = findViewById(R.id.bt_right);
        bt_menu = findViewById(R.id.bt_menu);
        bt_borrar = findViewById(R.id.bt_borrar);
        tx_id = findViewById(R.id.tx_id);
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
        buttons();
    }

    public void buttons() {
        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = mBDHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(Estruct_BBDD.COLUMN_ID, tx_id.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_NAME1, tx_nombre.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_NAME2, tx_apellido.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_EMAIL, tx_correo.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_PHONE, tx_telefono.getText().toString());
                    long nouRegId = db.insert(Estruct_BBDD.TABLE_NAME, null, values);
                    Toast to = Toast.makeText(MainActivity.this, "Registre guardat amb ID: " + nouRegId, Toast.LENGTH_LONG);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                    tx_id.setText("");
                    tx_nombre.setText("");
                    tx_apellido.setText("");
                    tx_correo.setText("");
                    tx_telefono.setText("");
                } catch (Exception e) {
                    Toast to = Toast.makeText(MainActivity.this, "Ha ocurrit un error en l'insertar el registre amb ID: " + tx_id.getText().toString() + ".", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                }
            }
        });

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = mBDHelper.getWritableDatabase();
                    String seleccio = Estruct_BBDD.COLUMN_ID + "=?";
                    String[] selectionArgs = {tx_id.getText().toString()};
                    db.delete(Estruct_BBDD.TABLE_NAME, seleccio, selectionArgs);
                    Toast to = Toast.makeText(MainActivity.this, "S'ha eliminat el registre amb ID: " + tx_id.getText().toString() + ".", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                    tx_id.setText("");
                    tx_nombre.setText("");
                    tx_apellido.setText("");
                    tx_correo.setText("");
                    tx_telefono.setText("");
                } catch (Exception e) {
                    Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre amb ID: " + tx_id.getText().toString() + ".", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                }
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = mBDHelper.getWritableDatabase();
                    String seleccio = Estruct_BBDD.COLUMN_ID + "=?";
                    String[] selectionArgs = {tx_id.getText().toString()};
                    ContentValues values = new ContentValues();
                    values.put(Estruct_BBDD.COLUMN_ID, tx_id.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_NAME1, tx_nombre.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_NAME2, tx_apellido.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_EMAIL, tx_correo.getText().toString());
                    values.put(Estruct_BBDD.COLUMN_PHONE, tx_telefono.getText().toString());
                    db.update(Estruct_BBDD.TABLE_NAME, values, seleccio, selectionArgs);
                    Toast to = Toast.makeText(MainActivity.this, "S'ha actualitzat el registre amb ID: " + tx_id.getText().toString() + ".", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                    tx_id.setText("");
                    tx_nombre.setText("");
                    tx_apellido.setText("");
                    tx_correo.setText("");
                    tx_telefono.setText("");
                } catch (Exception e) {
                    Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre amb ID: " + tx_id.getText().toString() + ".", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                }
            }
        });

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = mBDHelper.getReadableDatabase();
                    String seleccio = null;
                    String[] selectionArgs = null;

                    if (!tx_id.getText().toString().isEmpty()) {
                        seleccio += Estruct_BBDD.COLUMN_ID + "=?";
                        selectionArgs = new String[]{tx_id.getText().toString()};
                    }

                    if (!tx_nombre.getText().toString().isEmpty()) {
                        if (!seleccio.isEmpty()) {
                            seleccio += " AND ";
                        }
                        seleccio += Estruct_BBDD.COLUMN_NAME1 + "=?";
                        selectionArgs = new String[]{tx_nombre.getText().toString()};
                    }

                    if (!tx_apellido.getText().toString().isEmpty()) {
                        if (!seleccio.isEmpty()) {
                            seleccio += " AND ";
                        }
                        seleccio += Estruct_BBDD.COLUMN_NAME2 + "=?";
                        selectionArgs = new String[]{tx_apellido.getText().toString()};
                    }

                    if (!tx_correo.getText().toString().isEmpty()) {
                        if (!seleccio.isEmpty()) {
                            seleccio += " AND ";
                        }
                        seleccio += Estruct_BBDD.COLUMN_EMAIL + "=?";
                        selectionArgs = new String[]{tx_correo.getText().toString()};
                    }

                    if (!tx_telefono.getText().toString().isEmpty()) {
                        if (!seleccio.isEmpty()) {
                            seleccio += " AND ";
                        }
                        seleccio += Estruct_BBDD.COLUMN_PHONE + "=?";
                        selectionArgs = new String[]{tx_telefono.getText().toString()};
                    }

                    String sOrder = Estruct_BBDD.COLUMN_ID + " ASC";
                    Cursor c = db.query(Estruct_BBDD.TABLE_NAME, null, seleccio, selectionArgs, null, null, sOrder);
                    c.moveToFirst();
                    tx_id.setText(c.getString(0));
                    tx_nombre.setText(c.getString(1));
                    tx_apellido.setText(c.getString(2));
                    tx_correo.setText(c.getString(3));
                    tx_telefono.setText(c.getString(4));
                } catch (Exception e) {
                    Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre amb ID: " + tx_id.getText().toString() + ".", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                }
            }
        });

        bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = mBDHelper.getReadableDatabase();
                    String[] nomColumnes = {
                            Estruct_BBDD.COLUMN_ID,
                            Estruct_BBDD.COLUMN_NAME1,
                            Estruct_BBDD.COLUMN_NAME2,
                            Estruct_BBDD.COLUMN_EMAIL,
                            Estruct_BBDD.COLUMN_PHONE
                    };
                    String selection = Estruct_BBDD.COLUMN_NAME1 + "=?";
                    String[] selectionArgs = {tx_nombre.getText().toString()};
                    String sOrder = Estruct_BBDD.COLUMN_ID + " ASC";
                    Cursor c = db.query(Estruct_BBDD.TABLE_NAME, nomColumnes, selection, selectionArgs, null, null, sOrder);
                    if (c.moveToFirst()) {
                        tx_id.setText(c.getString(0));
                        tx_nombre.setText(c.getString(1));
                        tx_apellido.setText(c.getString(2));
                        tx_correo.setText(c.getString(3));
                        tx_telefono.setText(c.getString(4));
                    } else {
                        Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre posterior.", Toast.LENGTH_SHORT);
                        to.setGravity(Gravity.CENTER, 0, 0);
                        to.show();
                    }
                } catch (Exception e) {
                    Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre posterior.", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                }
            }
        });

        // mostrar el registre posterior al actual pero que no sea por ID, si no por cualquier columna que tenga el mismo valor.
        bt_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = mBDHelper.getReadableDatabase();
                    String[] nomColumnes = {
                            Estruct_BBDD.COLUMN_ID,
                            Estruct_BBDD.COLUMN_NAME1,
                            Estruct_BBDD.COLUMN_NAME2,
                            Estruct_BBDD.COLUMN_EMAIL,
                            Estruct_BBDD.COLUMN_PHONE
                    };
                    String selection = Estruct_BBDD.COLUMN_NAME1 + "=?";
                    String[] selectionArgs = {tx_nombre.getText().toString()};
                    String sOrder = Estruct_BBDD.COLUMN_ID + " DESC";
                    Cursor c = db.query(Estruct_BBDD.TABLE_NAME, nomColumnes, selection, selectionArgs, null, null, sOrder);
                    if (c.moveToFirst()) {
                        tx_id.setText(c.getString(0));
                        tx_nombre.setText(c.getString(1));
                        tx_apellido.setText(c.getString(2));
                        tx_correo.setText(c.getString(3));
                        tx_telefono.setText(c.getString(4));
                    } else {
                        Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre anterior.", Toast.LENGTH_SHORT);
                        to.setGravity(Gravity.CENTER, 0, 0);
                        to.show();
                    }
                } catch (Exception e) {
                    Toast to = Toast.makeText(MainActivity.this, "No s'ha trobat el registre anterior.", Toast.LENGTH_SHORT);
                    to.setGravity(Gravity.CENTER, 0, 0);
                    to.show();
                }
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



    /*public void Registrar(View view) {
        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = mBDHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Estruct_BBDD.COLUMN_ID, tx_id.getText().toString());
                values.put(Estruct_BBDD.COLUMN_NAME1, tx_nombre.getText().toString());
                values.put(Estruct_BBDD.COLUMN_NAME2, tx_apellido.getText().toString());
                values.put(Estruct_BBDD.COLUMN_EMAIL, tx_correo.getText().toString());
                values.put(Estruct_BBDD.COLUMN_PHONE, tx_telefono.getText().toString());
                long nouRegId = db.insert(Estruct_BBDD.TABLE_NAME, null, values);
                Toast to = Toast.makeText(MainActivity.this, "Registre guardat amb ID: " + nouRegId, Toast.LENGTH_LONG);
                to.setGravity(Gravity.CENTER, 0, 0);
                to.show();
            }
        });
        //Intent intent = new Intent(this, Auth.class);
        //intent.putExtra("tx_nombre", tx_nombre.getText().toString());
        //startActivity(intent);
    }*/

    /*public void Search(View view) {
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = mBDHelper.getReadableDatabase();
                String [] nomColumnes = {
                        Estruct_BBDD.COLUMN_NAME1,
                        Estruct_BBDD.COLUMN_NAME2,
                        Estruct_BBDD.COLUMN_EMAIL,
                        Estruct_BBDD.COLUMN_PHONE
                };
                String seleccio = Estruct_BBDD.COLUMN_NAME1 + "=?";
                String [] selectionArgs = {tx_id.getText().toString()};
                String sOrder = Estruct_BBDD.COLUMN_NAME2 + " ASC";
                Cursor c = db.query(Estruct_BBDD.TABLE_NAME, nomColumnes , seleccio, selectionArgs, null , null, sOrder);
                c.moveToFirst();
                tx_nombre.setText(c.getString (0));
                tx_apellido.setText(c.getString (1));
                tx_correo.setText(c.getString (2));
                tx_telefono.setText(c.getString (3));
            }
        });
    }*/

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
        tx_id.setText("");
        tx_nombre.setText("");
        tx_apellido.setText("");
        tx_correo.setText("");
        tx_telefono.setText("");
    }

    public void Volver(View view) {
        onBackPressed();
    }
}
