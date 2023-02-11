package slirdad.calculator;

class CalculatorData {
    double result;
    double var;
    Operation lastOperation = Operation.NULL;
    Operation currentOperation;
    boolean isDivisionByZero;


    CalculatorData(Operation lastOperation, Operation currentOperation,
                   double result, double var, boolean isDivisionByZero) {
        this.lastOperation = lastOperation;
        this.currentOperation = currentOperation;
        this.result = result;
        this.var = var;
        this.isDivisionByZero = isDivisionByZero;
    }

    CalculatorData(Operation currentOperation, double var) {
        this.currentOperation = currentOperation;
        this.var = var;
    }

    CalculatorData() {
    }
}
