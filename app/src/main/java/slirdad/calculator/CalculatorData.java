package slirdad.calculator;

class CalculatorData {
    double result;
    double var;
    Operation currentOperation;
    boolean isDivisionByZero;


    CalculatorData(Operation currentOperation, double result, double var,
                   boolean isDivisionByZero) {
        this.currentOperation = currentOperation;
        this.result = result;
        this.var = var;
        this.isDivisionByZero = isDivisionByZero;
    }
}
