package dam2.dcabrera.activitat4;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ScoreListActivity extends AppCompatActivity {

    private ListView lv_playerData;
    private ListView lv_playsList;
    private BBDD_Helper mBDHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_list);

        lv_playerData = findViewById(R.id.lv_playerData);
        lv_playsList = findViewById(R.id.lv_playsList);
        mBDHelper = new BBDD_Helper(this);

        // Llamamos al método para cargar los datos en el ListView
        loadListViewData();

        // Agregamos un listener al ListView para manejar los clics en los elementos
        lv_playerData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtenemos el ID seleccionado
                String selectedIdString = (String) parent.getItemAtPosition(position);
                int selectedId = Integer.parseInt(selectedIdString.split(":")[1].trim());

                // Mostramos las jugadas asociadas a ese ID
                showPlaysForId(selectedId);

                // Ocultamos el ListView de IDs al hacer clic en un ID específico
                lv_playerData.setVisibility(View.GONE);
            }
        });
    }

    // Método para cargar los datos de la base de datos en el ListView
    private void loadListViewData() {
        SQLiteDatabase db = mBDHelper.getReadableDatabase();
        String[] projection = {Estruct_BBDD.COLUMN_ID};

        Cursor cursor = db.query(Estruct_BBDD.TABLE_NAME, projection, null, null, null, null, null);

        Set<Integer> uniqueIds = new HashSet<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(Estruct_BBDD.COLUMN_ID));
            uniqueIds.add(id);
        }

        cursor.close();

        // Convertimos el Set a un ArrayList para usarlo con el ArrayAdapter
        ArrayList<String> idList = new ArrayList<>();
        for (int id : uniqueIds) {
            idList.add("ID de Partida: " + id);
        }

        // Ordenamos la lista de IDs de forma ascendente
        Collections.sort(idList, (id1, id2) -> {
            // Extraemos los valores numéricos y los comparamos
            try {
                int val1 = Integer.parseInt(id1.split(":")[1].trim());
                int val2 = Integer.parseInt(id2.split(":")[1].trim());
                return Integer.compare(val1, val2);
            } catch (NumberFormatException e) {
                // Manejar la excepción (puede ser útil imprimir un mensaje de error)
                e.printStackTrace();
                return 0; // O algún valor predeterminado
            }
        });

        // Creamos un ArrayAdapter para mostrar los datos en el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, idList);

        // Asignamos el adaptador al ListView
        lv_playerData.setAdapter(adapter);

        // Muestra solo el primer ID después de ordenar
        if (!idList.isEmpty()) {
            lv_playerData.setSelection(0);
        }
    }


    // Método para mostrar las jugadas asociadas a un ID
    private void showPlaysForId(int selectedId) {
        SQLiteDatabase db = mBDHelper.getReadableDatabase();
        String[] projection = {Estruct_BBDD.COLUMN_JUG1, Estruct_BBDD.COLUMN_JUG2};
        String selection = Estruct_BBDD.COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(selectedId)};

        Cursor cursor = db.query(Estruct_BBDD.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        ArrayList<String> playsList = new ArrayList<>();

        while (cursor.moveToNext()) {
            String jug1 = cursor.getString(cursor.getColumnIndexOrThrow(Estruct_BBDD.COLUMN_JUG1));
            String jug2 = cursor.getString(cursor.getColumnIndexOrThrow(Estruct_BBDD.COLUMN_JUG2));

            // Agregamos las jugadas al ArrayList
            playsList.add("Jugador 1: " + jug1);
            playsList.add("Jugador 2: " + jug2);
        }

        cursor.close();

        // Creamos un ArrayAdapter para mostrar las jugadas en el nuevo ListView
        ArrayAdapter<String> playsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playsList);

        // Asignamos el adaptador al nuevo ListView
        lv_playsList.setAdapter(playsAdapter);
    }

    // Método para volver a mostrar el ListView de IDs
    private void showIdListView() {
        lv_playerData.setVisibility(View.VISIBLE);
    }

    public void onClickBack(View view) {
        // Volvemos a mostrar el ListView de IDs al hacer clic en el botón de retroceso
        showIdListView();
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickResume(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        Toast to = new Toast(this);
        to.setGravity(Gravity.CENTER, 0, 0);
        to.setMargin(0, 0);
        to.setDuration(Toast.LENGTH_SHORT);
        to.setText("ALERT: Funcionalidad no disponible.");
        to.show();
    }
}
