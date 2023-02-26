package slirdad.calculator.UI;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.Domain.CalculatorData;
import slirdad.calculator.Domain.Operation;
import slirdad.calculator.UI.OnClickListeners.OnAllCleanButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnDeleteLastCharButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnDivisionButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnEqualMarkButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnMinusButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnMultiplicationButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnNumberButtonsClickListener;
import slirdad.calculator.UI.OnClickListeners.OnPlusButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnPointButtonClickListener;
import slirdad.calculator.UI.OnClickListeners.OnSignChangeButtonClickListener;

class OnCLFactory {
    private final OnNumberButtonsClickListener onNumberButtonsClickListener;
    private final OnPlusButtonClickListener onPlusButtonClickListener;
    private final OnMinusButtonClickListener onMinusButtonClickListener;
    private final OnMultiplicationButtonClickListener onMultiplicationButtonClickListener;
    private final OnDivisionButtonClickListener onDivisionButtonClickListener;
    private final OnDeleteLastCharButtonClickListener onDeleteLastCharButtonClickListener;
    private final OnSignChangeButtonClickListener onSignChangeButtonClickListener;
    private final OnEqualMarkButtonClickListener onEqualMarkButtonClickListener;
    private final OnAllCleanButtonClickListener onAllCleanButtonClickListener;
    private final OnPointButtonClickListener onPointButtonClickListener;
    private final Calculator calculator = new Calculator();


    OnCLFactory(MainActivityViewHolder holder) {
        Calculator calculator = new Calculator();
        onNumberButtonsClickListener = new OnNumberButtonsClickListener(calculator, holder);
        onPlusButtonClickListener = new OnPlusButtonClickListener(calculator, holder);
        onMinusButtonClickListener = new OnMinusButtonClickListener(calculator, holder);
        onMultiplicationButtonClickListener = new OnMultiplicationButtonClickListener(calculator, holder);
        onDivisionButtonClickListener = new OnDivisionButtonClickListener(calculator, holder);
        onDeleteLastCharButtonClickListener = new OnDeleteLastCharButtonClickListener(calculator, holder);
        onSignChangeButtonClickListener = new OnSignChangeButtonClickListener(calculator, holder);
        onEqualMarkButtonClickListener = new OnEqualMarkButtonClickListener(calculator, holder);
        onAllCleanButtonClickListener = new OnAllCleanButtonClickListener(calculator, holder);
        onPointButtonClickListener = new OnPointButtonClickListener(calculator, holder);

    }

        public View.OnClickListener pressPlus(MainActivityViewHolder holder) {

            TextView mainTextView = holder.getMainTextView();

            double var;

            if (calculator.isOperationFinished()) {
                if (calculator.getCurrentOperation() != Operation.ADDITION) {
                    calculator.setVar(1);
                    calculator.setCurrentOperation(Operation.ADDITION);
                }
                return null;
            } else {
                var = MainActivityExtensionMethods.getNum(mainTextView);
            }

            CalculatorData calculatorData = calculator.operate(var, Operation.ADDITION, () -> {
                String error = "Ошибка деления на ноль";
                MainActivityExtensionMethods.changeSizeText(error, holder.getMainTextView());
                holder.getMainTextView().setText(error);
                MainActivityExtensionMethods.resetData(calculator);
                calculator.setOperationFinished(true);
            });
            if (calculatorData != null) {
                MainActivityExtensionMethods.setCalcData(mainTextView, calculatorData);
            }
            return null;
        }

    public Calculator getCalculator() {
        return calculator;
    }

    public OnNumberButtonsClickListener getOnNumberButtonsClickListener() {
        return onNumberButtonsClickListener;
    }

    public OnPlusButtonClickListener getOnPlusButtonClickListener() {
        return onPlusButtonClickListener;
    }

    public OnMinusButtonClickListener getOnMinusButtonClickListener() {
        return onMinusButtonClickListener;
    }

    public OnMultiplicationButtonClickListener getOnMultiplicationButtonClickListener() {
        return onMultiplicationButtonClickListener;
    }

    public OnDivisionButtonClickListener getOnDivisionButtonClickListener() {
        return onDivisionButtonClickListener;
    }

    public OnDeleteLastCharButtonClickListener getOnDeleteLastCharButtonClickListener() {
        return onDeleteLastCharButtonClickListener;
    }

    public OnSignChangeButtonClickListener getOnSignChangeButtonClickListener() {
        return onSignChangeButtonClickListener;
    }

    public OnEqualMarkButtonClickListener getOnEqualMarkButtonClickListener() {
        return onEqualMarkButtonClickListener;
    }

    public OnAllCleanButtonClickListener getOnAllCleanButtonClickListener() {
        return onAllCleanButtonClickListener;
    }

    public OnPointButtonClickListener getOnPointButtonClickListener() {
        return onPointButtonClickListener;
    }
}
