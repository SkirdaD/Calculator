package slirdad.calculator.CalculatorFragment.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HistoryDataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "calculationHistory.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "calculationTable"; // название таблицы в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EXPRESSION = "expression";
    public static final String COLUMN_RESULT = "result";

    public HistoryDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE calculationTable (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_EXPRESSION
                + " TEXT, " + COLUMN_RESULT + " TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
