package dam2.dcabrera.actividad3pantalles;

import android.telephony.PhoneNumberUtils;

public class Estruct_BBDD {
    private Estruct_BBDD() {
    }

    public static final String TABLE_NAME = "CONTACTS";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME1 = "Nom";
    public static final String COLUMN_NAME2 = "Cognom";
    public static final String COLUMN_EMAIL = "Email";
    public static final String TEXT_TYPE = " TEXT";
    public static String COLUMN_PHONE = "Phone";
    public static final String COMMA_SEP = " ,";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Estruct_BBDD.TABLE_NAME + " (" +
                    Estruct_BBDD.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    Estruct_BBDD.COLUMN_NAME1 + Estruct_BBDD.TEXT_TYPE + Estruct_BBDD.COMMA_SEP +
                    Estruct_BBDD.COLUMN_NAME2 + Estruct_BBDD.TEXT_TYPE + Estruct_BBDD.COMMA_SEP +
                    Estruct_BBDD.COLUMN_EMAIL + Estruct_BBDD.TEXT_TYPE + Estruct_BBDD.COMMA_SEP +
                    Estruct_BBDD.COLUMN_PHONE + Estruct_BBDD.TEXT_TYPE + ")";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Estruct_BBDD.TABLE_NAME;

    public static final String SQL_DELETE_FROM_ID =
            "DELETE FROM " + Estruct_BBDD.TABLE_NAME +
                    " WHERE " + Estruct_BBDD.COLUMN_ID + " = ?";
}