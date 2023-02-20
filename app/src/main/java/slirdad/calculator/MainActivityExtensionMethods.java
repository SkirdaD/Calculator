package slirdad.calculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityExtensionMethods {

    public static double getNum(TextView textView) {
        return Double.parseDouble(textView.getText().toString());
    }

    public static void setCalcData(TextView textView, CalculatorData calculatorData) {
        String textTextView = Double.toString(calculatorData.result);
        textTextView = formatWholeDoubleAsInt(textTextView);
        MainActivityExtensionMethods.changeSizeText(textTextView, textView);
        textView.setText(textTextView);
    }

    public static void changeSizeText(String text, TextView textView) {
        final int NUMBER_OF_LARGE_CHARACTERS = 8;
        final int NUMBER_OF_MEDIUM_CHARACTERS = 11;
        final int SIZE_LARGE_TEXT = 100;
        final int SIZE_MEDIUM_TEXT = 70;
        final int SIZE_SMALL_TEXT = 40;

        if (text.length() < NUMBER_OF_LARGE_CHARACTERS) {
            textView.setTextSize(SIZE_LARGE_TEXT);
        } else if (text.length() < NUMBER_OF_MEDIUM_CHARACTERS) {
            textView.setTextSize(SIZE_MEDIUM_TEXT);
        } else {
            textView.setTextSize(SIZE_SMALL_TEXT);
        }
    }

    public static void changeSizeText(TextView textView) {
        changeSizeText("", textView);
    }


    /*сделано только в кнопке минус
     * не реализовано стирание слова ошибка с экрана,
     * в других калькуляторах просто становятся не кликабельны все кнопки кроме АС*/
    public static void showDivisionByZeroError(Context context, MainActivityViewHolder holder,
                                               Calculator calculator) {

        TextView mainTextView = holder.getMainTextView();

        Toast.makeText(context, R.string.division_error, Toast.LENGTH_LONG).show();

        changeSizeText(mainTextView);
        mainTextView.setText(R.string.error);

        resetData(calculator);
    }

    public static String formatWholeDoubleAsInt(String text) {
        if ((text.indexOf(".") + 2) == text.length() &&
                Character.toString(text.charAt(text.indexOf(".") + 1)).compareTo("0") == 0) {
            return text.substring(0, text.indexOf("."));
        } else return text;
    }

    public static void resetData(Calculator calculator) {
        calculator.setOperationFinished(false);
        calculator.setCurrentOperation(Operation.NONE);
        calculator.setVar(0);
        calculator.setResult(0);
        calculator.setDivisionByZero(false);
    }
}
