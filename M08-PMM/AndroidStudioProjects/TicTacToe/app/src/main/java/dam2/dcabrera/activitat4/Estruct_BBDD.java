package dam2.dcabrera.activitat4;

public class Estruct_BBDD {
    private Estruct_BBDD() {
    }

    public static final String TABLE_NAME = "JUGADES";
    public static final String COLUMN_ID = "Partida";
    public static final String COLUMN_JUG1 = "Jugador1";
    public static final String COLUMN_JUG2 = "Jugador2";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = " ,";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Estruct_BBDD.TABLE_NAME + " (" +
                    Estruct_BBDD.COLUMN_ID + " INTEGER " + Estruct_BBDD.COMMA_SEP +
                    Estruct_BBDD.COLUMN_JUG1 + Estruct_BBDD.TEXT_TYPE + Estruct_BBDD.COMMA_SEP +
                    Estruct_BBDD.COLUMN_JUG2 + Estruct_BBDD.TEXT_TYPE + ")";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Estruct_BBDD.TABLE_NAME;

    public static final String SQL_DELETE_FROM_ID =
            "DELETE FROM " + Estruct_BBDD.TABLE_NAME +
                    " WHERE " + Estruct_BBDD.COLUMN_ID + " = ?";
}