package slirdad.calculator.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Calculator;
import slirdad.calculator.CalculatorData;
import slirdad.calculator.MainActivityExtensionMethods;
import slirdad.calculator.MainActivityViewHolder;
import slirdad.calculator.Operation;

public class OnDivisionButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final MainActivityViewHolder holder;

    public OnDivisionButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
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
            var = MainActivityExtensionMethods.getNum(mainTextView);
        }

        CalculatorData calculatorData = calculator.operate(var, Operation.DIVISION);
        MainActivityExtensionMethods.setCalcData(mainTextView, calculatorData);
    }
}
