package dam2.dcabrera.actividad3pantalles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BBDD_Helper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Contats.db";

    public BBDD_Helper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(Estruct_BBDD.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(Estruct_BBDD.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDeleteI(SQLiteDatabase db){
        db.execSQL(Estruct_BBDD.SQL_DELETE_FROM_ID);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion, newVersion);
    }
}