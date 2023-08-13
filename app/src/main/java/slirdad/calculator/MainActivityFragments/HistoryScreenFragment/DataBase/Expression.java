package slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase;

public class Expression {
    private final String expressionBody;
    private final String expressionResult;

    public Expression(String expressionResult, String expressionBody) {
        this.expressionBody = expressionBody;
        this.expressionResult = expressionResult;
    }

    public String getExpressionBody() {
        return expressionBody;
    }

    public String getExpressionResult() {
        return expressionResult;
    }

}
