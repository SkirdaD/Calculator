package slirdad.calculator;


class Calculator {

    CalculatorData operate(CalculatorData calculatorData) {

        Operation lastOperation = calculatorData.lastOperation;
        Operation currentOperation = calculatorData.currentOperation;
        double result = calculatorData.result;
        double var = calculatorData.var;
        boolean isDivisionByZero = calculatorData.isDivisionByZero;


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

        return new CalculatorData(lastOperation, currentOperation,
                result, var, isDivisionByZero);
    }
}
