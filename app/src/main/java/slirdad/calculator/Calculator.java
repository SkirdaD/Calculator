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
    double result;
    double var1;
    double var2;

    /*
    Инициализация переменной, которая показывает было ли нажато последним "=".
    Используется:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС
     */
    boolean isLastPressButtonEqualMark;

    /*
    lastOperation используется:
        - в лисенерах кнопок арифметических операций;
        - в лисенере кнопки равно для отображения нужного символа в secondaryField;
        - в методе ::operate;
        - в лисенере АС
        - в onSaveInstanceState и onRestoreInstanceState
    */
    LastOperation lastOperation = LastOperation.NULL;

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
    void operate() {
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
                    result = 0;
                    isLastPressButtonEqualMark = false;
                    return;
                }
                break;
        }
        var2 = var1;
    }
}
