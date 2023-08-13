package slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HistoryDataBaseHelper extends SQLiteOpenHelper {

    public HistoryDataBaseHelper(@Nullable Context context) {
        super(context, DataBaseStringValues.DATABASE_NAME, null, DataBaseStringValues.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseStringValues.TABLE_STRUCTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DataBaseStringValues.DROP_TABLE);
        onCreate(db);
    }
}
