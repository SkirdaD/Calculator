package slirdad.calculator;


class Calculator {
    private double result;

    CalculatorData operate(double var, Operation currentOperation, Operation nextOperation) {
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
                    //что-то с CallBack
                }
                break;
            case NONE:
                result = var;
                break;
        }

        return new CalculatorData(nextOperation, result, var);
    }
}