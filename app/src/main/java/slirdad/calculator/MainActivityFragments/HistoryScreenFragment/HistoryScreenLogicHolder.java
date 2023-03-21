package slirdad.calculator.MainActivityFragments.HistoryScreenFragment;

import android.content.Context;

import java.util.ArrayList;

import slirdad.calculator.Data.Expression;
import slirdad.calculator.Data.ExpressionArrayList;

class HistoryScreenLogicHolder {
    private final ExpressionAdapter adapter;

    HistoryScreenLogicHolder(Context context) {
        ArrayList<Expression> expressions = ExpressionArrayList.getExpressionArrayList();
        adapter = new ExpressionAdapter(context, expressions);
    }

    public ExpressionAdapter getAdapter() {
        return adapter;
    }
}
