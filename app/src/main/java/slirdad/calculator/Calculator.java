package slirdad.calculator;


class Calculator {
    private double result;
    private Operation currentOperation = Operation.NONE;
    private boolean isOperationFinished;

    CalculatorData operate(double var, Operation nextOperation) {
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
                    return null;
                }
                break;
            case NONE:
                result = var;
                break;
        }
        return new CalculatorData(nextOperation, result, var);
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
}
