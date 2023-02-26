package slirdad.calculator.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.Domain.CalculatorData;
import slirdad.calculator.UI.MainActivityExtensionMethods;
import slirdad.calculator.UI.MainActivityViewHolder;
import slirdad.calculator.Domain.Operation;


public class OnPlusButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final MainActivityViewHolder holder;

    public OnPlusButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();

        double var;

        if (calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() != Operation.ADDITION) {
                calculator.setVar(1);
                calculator.setCurrentOperation(Operation.ADDITION);
            }
            return;
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
    }
}
