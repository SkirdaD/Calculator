package slirdad.calculator;

import android.widget.Toast;

public class Calculation extends MainActivity {
    static double result = 0;
    static double var1 = 0;
    static double var2 = 0;

    static boolean isLastPressButtonEqualMark;

    static LastOperation lastOperation = LastOperation.NULL;

    enum LastOperation {
        ADDITION,
        SUBTRACTION,
        DIVISION,
        MULTIPLICATION,
        NULL
    }

    protected static void operate() {
        /*если после одного дейсвия нажали сразу другое,
        то ничего не произойдет (только если это не кнопка равно).
        Просто сменится флаг.*/

        if (!textMainField.equals("")) {
            var1 = Double.parseDouble(textMainField);
        } else if (!isLastPressButtonEqualMark) {
            textSecondaryField = new StringBuffer(textSecondaryField).
                    delete(textSecondaryField.length() - 6,
                            textSecondaryField.length() - 3).toString();
            MainActivity.secondaryField.setText(textSecondaryField);
            return;
        }

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
                            Toast.LENGTH_LONG).show();*/
                    mainField.setText(R.string.error);
                    textMainField = "";
                    result = 0;
                    var1 = 0;
                    isLastPressButtonEqualMark = false;
                    //buttonAllClean.callOnClick();
                    return;
                }
                break;
        }
        var2 = var1;
        textMainField = String.valueOf(result);

        /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
        if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                        compareTo("0") == 0) {
            textMainField = textMainField.substring(0, textMainField.indexOf("."));
        }

        changeSizeText();
        mainField.setText(textMainField);
        textMainField = "";
    }
}
