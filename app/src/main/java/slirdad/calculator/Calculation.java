package slirdad.calculator;


import android.widget.Toast;

// Класс сделал дефолтным для видимости только в пакете.
class Calculation {
    /*
    Используются:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС

      Сделал их протектед, что бы мэйн смог ими пользоваться.
     */
    protected double result;
    protected double var1;
    protected double var2;

    /*
    Инициализация переменной, которая показывает было ли нажато последним "=".
    Используется:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС

      Сделал протектед, что бы мэйн смог им пользоваться.
     */
    protected boolean isLastPressButtonEqualMark;

    /*
    lastOperation используется:
        - в лисенерах кнопок арифметических операций;
        - в лисенере кнопки равно для отображения нужного символа в secondaryField;
        - в методе ::operate;
        - в лисенере АС
        - в onSaveInstanceState и onRestoreInstanceState

       Сделал протектед, что бы мэйн смог им пользоваться.
    */
    protected LastOperation lastOperation = LastOperation.NULL;

    enum LastOperation {
        ADDITION,
        SUBTRACTION,
        DIVISION,
        MULTIPLICATION,
        NULL
    }

    /*
    ::operate используется в лисенерах кнопок "/" "*" "-" "+" "="
     */
    protected void operate() {
        switch (lastOperation) {
            case ADDITION:
                result = result + var1;
                break;
            case MULTIPLICATION:
                result = result * var1;
                break;
            case SUBTRACTION:
                result = result - var1;
                break;
            case DIVISION:
                if (var1 != 0) {
                    result = result / var1;
                } else {
                    /*Toast.makeText(getApplicationContext(),
                            R.string.division_error,
                            Toast.LENGTH_LONG).show();
                    mainField.setText(R.string.error);
                    textMainField = "";*/
                    result = 0;
                    //var1 = 0;
                    isLastPressButtonEqualMark = false;
                    //buttonAllClean.callOnClick();
                    return;
                }
                break;
        }
        var2 = var1;
    }
}
