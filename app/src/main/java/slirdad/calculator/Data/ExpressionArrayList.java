package slirdad.calculator.Data;

import java.util.ArrayList;

public class ExpressionArrayList {

    private static final ArrayList<Expression> expressionArrayList = new ArrayList<>();

    public static void addExpression(String expressionResult, String expressionBody) {
        Expression expression = new Expression(expressionResult, expressionBody);
        expressionArrayList.add(expression);
    }

    public static ArrayList<Expression> getExpressionArrayList() {
        return expressionArrayList;
    }
}
