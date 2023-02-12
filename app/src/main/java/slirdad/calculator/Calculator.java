package slirdad.calculator;


class Calculator {
    CalculatorData calculatorData = new CalculatorData();

    CalculatorData operate (double var, Operation currentOperation) {
        double result = calculatorData.result;
        boolean isDivisionByZero = calculatorData.isDivisionByZero;
        Operation lastOperation = calculatorData.lastOperation;

        switch (lastOperation) {
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
                    isDivisionByZero = true;
                }
                break;
            case NULL:
                result = var;
                break;
        }
        lastOperation = currentOperation;

        return calculatorData = new CalculatorData(lastOperation, currentOperation,
                result, var, isDivisionByZero);
    }
}
