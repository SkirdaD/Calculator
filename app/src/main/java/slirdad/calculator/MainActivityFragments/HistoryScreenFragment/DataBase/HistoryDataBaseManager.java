package slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class HistoryDataBaseManager {
    private final HistoryDataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public HistoryDataBaseManager(Context context) {
        dataBaseHelper = new HistoryDataBaseHelper(context);
    }

    public void insertToDataBase(String result, String expression) {
        new Thread(() -> {
            database = dataBaseHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataBaseStringValues.RESULT_COLUMN, result);
            contentValues.put(DataBaseStringValues.EXPRESSION_COLUMN, expression);

            database.insert(DataBaseStringValues.TABLE_NAME, null, contentValues);

            dataBaseHelper.close();
        }).start();

    }

    public List<Expression> getFromDataBase() {
        ArrayList<Expression> calculationsList = new ArrayList<>();

        new Thread(() -> {
            database = dataBaseHelper.getReadableDatabase();

            Cursor cursor = database.query(DataBaseStringValues.TABLE_NAME, null, null,
                    null, null, null, null);

            while (cursor.moveToNext()){
                String result = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseStringValues.RESULT_COLUMN));
                String expressionBody = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseStringValues.EXPRESSION_COLUMN));
                Expression expression = new Expression(result, expressionBody);
                calculationsList.add(expression);
            }
            cursor.close();
            dataBaseHelper.close();
        }).start();
        return calculationsList;
    }
}
