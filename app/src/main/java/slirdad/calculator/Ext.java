package slirdad.calculator;

import android.widget.TextView;

public class Ext {

    public static double getNumFromTextView(TextView textView) {
        return Double.parseDouble(textView.getText().toString());
    }

    public static Operation setTextView(CalculatorData calculatorData, TextView textView) {
        Operation currentOperation = calculatorData.nextOperation;
        String textTextView = Double.toString(calculatorData.result);
        Ext.changeSizeText(textTextView, textView);
        textView.setText(textTextView);
        return currentOperation;
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
}
