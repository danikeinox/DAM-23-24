package dam2.dcabrera.activitat4;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreListActivity extends AppCompatActivity {

    private ListView lv_playerData;
    private BBDD_Helper mBDHelper = new BBDD_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_list);

        Bundle extras = getIntent().getExtras();

        int cercles = extras.getInt("cercles");
        int creus = extras.getInt("creus");

        lv_playerData = findViewById(R.id.lv_playerData);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    

    public void checkDBPlays(View view) {
        SQLiteDatabase db = mBDHelper.getReadableDatabase();
        String selection = Estruct_BBDD.COLUMN_ID;
        Cursor a = db.query(Estruct_BBDD.TABLE_NAME, null, selection, null, null, null, null);
        a.moveToLast();
        for (int i = 0; i < a.getColumnIndex(Estruct_BBDD.COLUMN_ID); i++) {
            Cursor c = db.query(Estruct_BBDD.TABLE_NAME, null, selection, null, null, null, null);
            c.moveToFirst();
            int simpleListItem = Integer.parseInt("android.R.layout.simple_list_item_" + 1);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simpleListItem);
        }
    }
}
