package slirdad.calculator.CalculatorFragment.UI;

import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import slirdad.calculator.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.CalculatorFragment.Domain.CalculatorData;
import slirdad.calculator.CalculatorFragment.Domain.Operation;

class CalculatorFragmentLogicHolder {
    private final CalculatorFragmentViewHolder viewHolder;
    private final Calculator calculator = new Calculator();
    private final HashMap<Integer, String> buttonValuesMap = NumButtonsMap.getButtonValuesMap();

    CalculatorFragmentLogicHolder(CalculatorFragmentViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    void putNum(View v) {
        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.equals("0") || calculator.isOperationFinished()) {
            text = "";
        }

        text = text + buttonValuesMap.get(v.getId());

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }

    void putDecimalPoint(@SuppressWarnings("unused") View v) {
        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (calculator.isOperationFinished()) {
            text = "0.";
        } else if (!text.contains(".")) {
            text = text + ".";
        } else return;

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }

    void changeSign(@SuppressWarnings("unused") View v) {
        TextView mainTextView = viewHolder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.equals("0")) {
            return;
        } else if (text.charAt(0) != '-') {
            text = "-" + text;
        } else {
            text = text.substring(1);
        }

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);

        if (calculator.isOperationFinished()) {
            calculator.setCurrentOperation(Operation.NONE);
            calculator.setOperationFinished(false);
        }
    }

    void deleteLastChar(@SuppressWarnings("unused") View v) {
        if (!calculator.isOperationFinished()) {
            TextView mainTextView = viewHolder.getMainTextView();
            String text = mainTextView.getText().toString();
            if (text.length() > 1) {
                text = text.substring(0, text.length() - 1);
            } else text = "0";
            CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
            mainTextView.setText(text);
        }
    }

    void cleanAll(@SuppressWarnings("unused") View v) {
        TextView mainTextView = viewHolder.getMainTextView();
        CalculatorFragmentExtensionMethods.resetData(calculator);

        String text = "0";
        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        viewHolder.getHistoryTextView().setText("");
    }

    void summarize(@SuppressWarnings("unused") View v) {
        double var = getVar(Operation.ADDITION);
        setHistoryTextView(Operation.ADDITION);
        setCalculatorData(var, Operation.ADDITION);
    }

    void subtract(@SuppressWarnings("unused") View v) {
        double var = getVar(Operation.SUBTRACTION);
        setHistoryTextView(Operation.SUBTRACTION);
        setCalculatorData(var, Operation.SUBTRACTION);
    }

    void divide(@SuppressWarnings("unused") View v) {
        double var = getVar(Operation.DIVISION);
        setHistoryTextView(Operation.DIVISION);
        setCalculatorData(var, Operation.DIVISION);
    }

    void multiply(@SuppressWarnings("unused") View v) {
        double var = getVar(Operation.MULTIPLICATION);
        setHistoryTextView(Operation.MULTIPLICATION);
        setCalculatorData(var, Operation.MULTIPLICATION);
    }

    void equal(@SuppressWarnings("unused") View v) {
        double var = getVar(calculator.getCurrentOperation());
        calculator.setOperationFinished(false);

        setHistoryTextView(Operation.NONE);
        setCalculatorData(var, calculator.getCurrentOperation());
    }


    private double getVar(Operation nextOperation) {
        double var;
        if (viewHolder.getHistoryTextView().getText().toString().contains("=")) {
            viewHolder.getHistoryTextView().setText("");
        }
        TextView mainTextView = viewHolder.getMainTextView();

        if (calculator.isOperationFinished()) {
            calculator.setCurrentOperation(nextOperation);
            var = calculator.getVar();
        } else {
            var = CalculatorFragmentExtensionMethods.getNum(mainTextView);
        }
        return var;
    }

    private void setCalculatorData(double var, Operation nextOperation) {
        if (calculator.isOperationFinished()) {
            return;
        }
        TextView mainTextView = viewHolder.getMainTextView();
        CalculatorData calculatorData = calculator.operate(var, nextOperation, () -> {
            String error = "Ошибка деления на ноль";
            CalculatorFragmentExtensionMethods.changeSizeText(error, viewHolder.getMainTextView());
            viewHolder.getMainTextView().setText(error);
            CalculatorFragmentExtensionMethods.resetData(calculator);
            calculator.setOperationFinished(true);
        });
        if (calculatorData != null) {
            CalculatorFragmentExtensionMethods.setCalcData(mainTextView, calculatorData);
        }
    }

    private void setHistoryTextView(Operation nextOperation) {
        String textHistory = viewHolder.getHistoryTextView().getText().toString();
        String operator;

        if (!textHistory.contains("=")) {
            operator = CalculatorFragmentExtensionMethods.getOperationChar(nextOperation);
            textHistory = textHistory + viewHolder.getMainTextView().getText().toString() + operator;
        } else {
            operator = CalculatorFragmentExtensionMethods.
                    getOperationChar(calculator.getCurrentOperation());
            String var = CalculatorFragmentExtensionMethods.
                    formatWholeDoubleAsInt(String.valueOf(calculator.getVar()));
            textHistory = viewHolder.getMainTextView().getText().toString() + operator + var + " = ";
        }
        viewHolder.getHistoryTextView().setText(textHistory);
    }
}
