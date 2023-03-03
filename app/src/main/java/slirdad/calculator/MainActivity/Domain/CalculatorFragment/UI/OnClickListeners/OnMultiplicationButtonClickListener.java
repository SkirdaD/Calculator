package slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.CalculatorData;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentViewHolder;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Operation;

public class OnMultiplicationButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final CalculatorFragmentViewHolder holder;

    public OnMultiplicationButtonClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();

        double var;

        if (calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() != Operation.MULTIPLICATION) {
                calculator.setVar(1);
                calculator.setCurrentOperation(Operation.MULTIPLICATION);
            }
            return;
        } else {
            var = CalculatorFragmentExtensionMethods.getNum(mainTextView);
        }

        CalculatorData calculatorData = calculator.operate(var, Operation.MULTIPLICATION, () -> {
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
