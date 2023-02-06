package slirdad.calculator;


class Calculator {

    private double result;
    public void setResult (double result){
        this.result = result;
    }
    public double getResult() {
        return result;
    }

    double operate(Operation lastOperation, double var) {
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
                    //MainActivity mainActivity = new MainActivity();
                    //mainActivity.setDivisionByZero(true);
                    new MainActivity().setDivisionByZero(true);
                    //result = 0;
                    //isLastPressButtonEqualMark = false;
                    //break;
                    return 0;
                }
                break;
        }
        //var2 = var1;
        return result;
    }
}
