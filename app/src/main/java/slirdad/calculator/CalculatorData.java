package slirdad.calculator;

class CalculatorData {
    final double result;
    final double var;
    final Operation operation;


    CalculatorData(Operation operation, double result, double var) {
        this.operation = operation;
        this.result = result;
        this.var = var;
    }
}
