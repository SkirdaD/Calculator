package slirdad.calculator;

import android.widget.TextView;
import android.widget.Toast;

public class ExtensionMethods {

    public static double getNum(TextView textView) {
        return Double.parseDouble(textView.getText().toString());
    }

    public static void setCalcData(TextView textView, CalculatorData calculatorData) {
        String textTextView = Double.toString(calculatorData.result);
        ExtensionMethods.changeSizeText(textTextView, textView);
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

    public static void showErrorForDivideByZero(MainActivity mainActivity, TextView textView) {
        Toast.makeText(mainActivity, R.string.division_error, Toast.LENGTH_LONG).show();
        textView.setText(R.string.error);
    }
}
