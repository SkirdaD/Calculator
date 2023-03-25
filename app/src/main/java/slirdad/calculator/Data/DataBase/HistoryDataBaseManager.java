package slirdad.calculator.Data.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import slirdad.calculator.Data.Expression;

public class HistoryDataBaseManager {
    private final HistoryDataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public HistoryDataBaseManager(Context context) {
        dataBaseHelper = new HistoryDataBaseHelper(context);
    }

    // вот тут у тебя самая большая ошибка - почему кто-то другой (активити и два фрагмента)
    // должны открывать БД?
    public void openDataBase() {
        database = dataBaseHelper.getWritableDatabase();
    }

    // какой у тебя хелпер если перед инсёртом надо открывать бд тому кто им пользуется?
    // ты в микроволновке когда включаешь на разогрев отдельно кнопкой перед этим
    // нажимаешь "зарядить магнетрон", а потом только нажимаешь "разогреть"?
    public void insertToDataBase(String result, String expression) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseStringValues.RESULT_COLUMN, result);
        contentValues.put(DataBaseStringValues.EXPRESSION_COLUMN, expression);

        database.insert(DataBaseStringValues.TABLE_NAME, null, contentValues);
    }

    // здесь тоже самое
    public List<Expression> getFromDataBase() {

        ArrayList<Expression> calculationsList = new ArrayList<>();
        Cursor cursor = database.query(DataBaseStringValues.TABLE_NAME, null, null,
                null, null, null, null);

        while (cursor.moveToNext()){
            String result = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseStringValues.RESULT_COLUMN));
            String expressionBody = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseStringValues.EXPRESSION_COLUMN));
            Expression expression = new Expression(result, expressionBody);
            calculationsList.add(expression);
        }
        cursor.close();
        return calculationsList;
    }

    // это тоже зачем должен делать клиент?
    public void closeDatabase(){
        dataBaseHelper.close();
    }
}
