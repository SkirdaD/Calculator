package slirdad.calculator;

class CalculatorData {
    final double result;
    final double var;
    final Operation nextOperation;


    CalculatorData(Operation nextOperation, double result, double var) {
        this.nextOperation = nextOperation;
        this.result = result;
        this.var = var;
    }
}
