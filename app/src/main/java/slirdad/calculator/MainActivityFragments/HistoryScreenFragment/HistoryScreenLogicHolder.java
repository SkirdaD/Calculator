package slirdad.calculator.MainActivityFragments.HistoryScreenFragment;

import android.content.Context;

import java.util.List;

import slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase.HistoryDataBaseManager;
import slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase.Expression;

class HistoryScreenLogicHolder {
    private final ExpressionAdapter adapter;

    HistoryScreenLogicHolder(Context context, HistoryDataBaseManager dataBaseManager) {
        List<Expression> expressions = dataBaseManager.getFromDataBase();
        adapter = new ExpressionAdapter(context, expressions);
    }

    public ExpressionAdapter getAdapter() {
        return adapter;
    }
}
