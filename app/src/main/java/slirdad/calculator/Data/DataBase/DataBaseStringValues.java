package slirdad.calculator.Data.DataBase;

public class DataBaseStringValues {
    public static final String TABLE_NAME = "calculationsTable";
    public static final String _ID = "_id";
    public static final String RESULT_COLUMN = "result";
    public static final String EXPRESSION_COLUMN = "expression";
    public static final String DATABASE_NAME = "CalculationsHistory.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + RESULT_COLUMN + " TEXT," +
            EXPRESSION_COLUMN + " TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
