package slirdad.calculator;


class Calculator {
    CalculatorData calculatorData;

    CalculatorData operate(double var, Operation currentOperation) {
        double result = calculatorData.result;
        boolean isDivisionByZero = calculatorData.isDivisionByZero;

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
                    isDivisionByZero = true;
                }
                break;
            case NULL:
                result = var;
                break;
        }
        calculatorData = new CalculatorData(currentOperation, result, var, isDivisionByZero);

        return calculatorData;
    }
}
