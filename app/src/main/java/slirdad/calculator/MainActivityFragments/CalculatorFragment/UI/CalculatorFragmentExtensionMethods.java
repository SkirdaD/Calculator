package slirdad.calculator.MainActivityFragments.CalculatorFragment.UI;

import android.widget.TextView;

import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.CalculatorData;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.Operation;
import slirdad.calculator.MainActivityFragments.StringValues;

public class CalculatorFragmentExtensionMethods {

    public static double getNum(TextView textView) {
        return Double.parseDouble(textView.getText().toString());
    }

    public static void setCalcData(TextView textView, CalculatorData calculatorData) {
        String textTextView = Double.toString(calculatorData.result);
        textTextView = formatWholeDoubleAsInt(textTextView);
        CalculatorFragmentExtensionMethods.changeSizeText(textTextView, textView);
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
    }

    public static String getOperationChar(Operation operation) {
        String operator;
        switch (operation) {
            case ADDITION:
                operator = " " + StringValues.PLUS_SIGN + " ";
                break;
            case SUBTRACTION:
                operator = " " + StringValues.MINUS_SIGN + " ";
                break;
            case DIVISION:
                operator = " " + StringValues.DIVISION_SIGN + " ";
                break;
            case MULTIPLICATION:
                operator = " " + StringValues.MULTIPLICATION_SIGN + " ";
                break;
            default:
                operator = " " + StringValues.EQUAL_SIGN + " ";
        }
        return operator;
    }
}
