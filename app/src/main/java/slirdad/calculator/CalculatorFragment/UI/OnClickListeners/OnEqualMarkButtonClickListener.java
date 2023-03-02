package slirdad.calculator.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.CalculatorFragment.Domain.CalculatorData;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragmentViewHolder;
import slirdad.calculator.CalculatorFragment.Domain.Operation;

public class OnEqualMarkButtonClickListener implements View.OnClickListener{
    private final Calculator calculator;
    private final CalculatorFragmentViewHolder holder;

    public OnEqualMarkButtonClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();

        double var;

        if (!calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() == Operation.NONE) {
                return;
            } else {
                var = CalculatorFragmentExtensionMethods.getNum(mainTextView);
            }
        } else {
            var = calculator.getVar();
        }

        CalculatorData calculatorData = calculator.operate(var, calculator.getCurrentOperation(), () -> {
            String error = "Ошибка деления на ноль";
            CalculatorFragmentExtensionMethods.changeSizeText(error, holder.getMainTextView());
            holder.getMainTextView().setText(error);
            CalculatorFragmentExtensionMethods.resetData(calculator);
            calculator.setOperationFinished(true);
        });
        if (calculatorData != null) {
            CalculatorFragmentExtensionMethods.setCalcData(mainTextView, calculatorData);
        }
    }
}
