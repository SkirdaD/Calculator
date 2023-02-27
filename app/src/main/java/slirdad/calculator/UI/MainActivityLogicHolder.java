package slirdad.calculator.UI;

import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.Domain.CalculatorData;
import slirdad.calculator.Domain.Operation;
import slirdad.calculator.R;

class MainActivityLogicHolder {
    private final MainActivityViewHolder viewHolder;
    private final Calculator calculator = new Calculator();
    private final HashMap<Integer, String> buttonValuesMap = new HashMap<Integer, String>() {{
        put(R.id.button0, "0");
        put(R.id.button1, "1");
        put(R.id.button2, "2");
        put(R.id.button3, "3");
        put(R.id.button4, "4");
        put(R.id.button5, "5");
        put(R.id.button6, "6");
        put(R.id.button7, "7");
        put(R.id.button8, "8");
        put(R.id.button9, "9");
    }};


    MainActivityLogicHolder(MainActivityViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    void putNum(View v) {
        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.equals("0") || calculator.isOperationFinished()) {
            text = "";
        }

        text = text + buttonValuesMap.get(v.getId());

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }

    void putDecimalPoint() {
        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (calculator.isOperationFinished()) {
            text = "0.";
        } else if (!text.contains(".")) {
            text = text + ".";
        } else return;

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }

    void changeSign() {
        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.equals("0")) {
            return;
        } else if (text.charAt(0) != '-') {
            text = "-" + text;
        } else {
            text = text.substring(1);
        }

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);

        if (calculator.isOperationFinished()) {
            calculator.setCurrentOperation(Operation.NONE);
            calculator.setOperationFinished(false);
        }
    }

    void deleteLastChar() {
        if (calculator.isOperationFinished()) {
            return;
        }

        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.length() > 1) {
            text = text.substring(0, text.length() - 1);
        } else text = "0";

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
    }

    void cleanAll() {
        TextView mainTextView = viewHolder.getMainTextView();
        MainActivityExtensionMethods.resetData(calculator);

        String text = "0";
        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
    }

    void summarize() {
        double var = getVar(Operation.ADDITION);
        setCalculatorData(var, Operation.ADDITION);
    }

    void subtract() {
        double var = getVar(Operation.SUBTRACTION);
        setCalculatorData(var, Operation.SUBTRACTION);
    }

    void divide() {
        double var = getVar(Operation.DIVISION);
        setCalculatorData(var, Operation.DIVISION);
    }

    void multiply() {
        double var = getVar(Operation.MULTIPLICATION);
        setCalculatorData(var, Operation.MULTIPLICATION);
    }

    void equal() {
        TextView mainTextView = viewHolder.getMainTextView();
        double var;
        if (calculator.isOperationFinished()) {
            var = calculator.getVar();
        } else {
            var = MainActivityExtensionMethods.getNum(mainTextView);
        }

        setCalculatorData(var, calculator.getCurrentOperation());
    }


    private double getVar(Operation nextOperation) {
        TextView mainTextView = viewHolder.getMainTextView();

        double var = 0;

        if (calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() != nextOperation) {
                if (nextOperation == Operation.MULTIPLICATION || nextOperation == Operation.DIVISION) {
                    var = 1;
                }
                calculator.setCurrentOperation(nextOperation);
            }
        } else {
            var = MainActivityExtensionMethods.getNum(mainTextView);
        }
        return var;
    }

    private void setCalculatorData(double var, Operation nextOperation) {
        TextView mainTextView = viewHolder.getMainTextView();
        CalculatorData calculatorData = calculator.operate(var, nextOperation, () -> {
            String error = "Ошибка деления на ноль";
            MainActivityExtensionMethods.changeSizeText(error, viewHolder.getMainTextView());
            viewHolder.getMainTextView().setText(error);
            MainActivityExtensionMethods.resetData(calculator);
            calculator.setOperationFinished(true);
        });
        if (calculatorData != null) {
            MainActivityExtensionMethods.setCalcData(mainTextView, calculatorData);
        }
    }
}
