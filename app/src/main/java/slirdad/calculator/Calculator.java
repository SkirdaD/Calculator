package slirdad.calculator;


import java.util.HashMap;

public class Calculator {
    private double result;
    private double var;
    private Operation currentOperation = Operation.NONE;
    private boolean isOperationFinished;
    private boolean isDivisionByZero;
    final private HashMap<Operation, Double> operationMap = new HashMap<>();


    public CalculatorData operate(double var, Operation nextOperation) {
        this.var = var;

        operationMap.put(Operation.ADDITION, result + var);
        operationMap.put(Operation.SUBTRACTION, result - var);
        operationMap.put(Operation.MULTIPLICATION, result * var);
        operationMap.put(Operation.DIVISION, result / var);
        operationMap.put(Operation.NONE, var);

        if (var == 0 && currentOperation == Operation.DIVISION) {
            isDivisionByZero = true;
            return null;
        } else {
            result = operationMap.get(currentOperation);
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

    public boolean isDivisionByZero() {
        return isDivisionByZero;
    }

    public void setDivisionByZero(boolean divisionByZero) {
        isDivisionByZero = divisionByZero;
    }
}
