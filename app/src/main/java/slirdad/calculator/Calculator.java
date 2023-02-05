package slirdad.calculator;


// Класс сделал дефолтным для видимости только в пакете.
class Calculator {
    /*
    Используются:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС
     */
    //private double result;
    /*public void setResult (double result){
        this.result = result;
    }
    public double getResult() {
        return result;
    }*/

    //double var1;
    //double var2;

    /*
    Инициализация переменной, которая показывает было ли нажато последним "=".
    Используется:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС
     */
    //boolean isLastPressButtonEqualMark;

    /*
    lastOperation используется:
        - в лисенерах кнопок арифметических операций;
        - в лисенере кнопки равно для отображения нужного символа в secondaryField;
        - в методе ::operate;
        - в лисенере АС
        - в onSaveInstanceState и onRestoreInstanceState
    */

    /*LastOperation lastOperation = LastOperation.NULL;

    enum LastOperation {
        ADDITION,
        SUBTRACTION,
        DIVISION,
        MULTIPLICATION,
        NULL
    }*/

    /*
    ::operate используется в лисенерах кнопок "/" "*" "-" "+" "="
     */
    double operate(LastOperation lastOperation,double result, double var) {
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
                    //result = 0;
                    //isLastPressButtonEqualMark = false;
                    break;
                    //return;
                }
                break;
        }
        //var2 = var1;
        return result;
    }
}
