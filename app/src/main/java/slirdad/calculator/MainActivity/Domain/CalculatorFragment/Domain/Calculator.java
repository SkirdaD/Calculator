package slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain;


public class Calculator {
    private double result;
    private double var;
    private Operation currentOperation = Operation.NONE;
    private boolean isOperationFinished;

    public interface Callback {
        void showDivisionByZeroError();
    }

    public CalculatorData operate(double var, Operation nextOperation, Callback onDivisionError) {
        this.var = var;
        switch (currentOperation) {
            case ADDITION:
                result = result + var;
                break;
            case MULTIPLICATION:
                result = result * var;
                break;
            case SUBTRACTION:
                result = result - var;
                break;
            case DIVISION:
                if (var != 0) {
                    result = result / var;
                } else {
                    onDivisionError.showDivisionByZeroError();
                    return null;
                }
                break;
            case NONE:
                result = var;
                break;
        }

        isOperationFinished = true;
        currentOperation = nextOperation;

        return new CalculatorData(result, var);
    }

    public Operation getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(Operation currentOperation) {
        this.currentOperation = currentOperation;
    }

    public boolean isOperationFinished() {
        return isOperationFinished;
    }

    public void setOperationFinished(boolean operationFinished) {
        isOperationFinished = operationFinished;
    }

    public double getVar() {
        return var;
    }

    public void setVar(double var) {
        this.var = var;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
