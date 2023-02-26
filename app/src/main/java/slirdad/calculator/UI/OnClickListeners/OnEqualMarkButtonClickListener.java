package slirdad.calculator.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.Domain.CalculatorData;
import slirdad.calculator.UI.MainActivityExtensionMethods;
import slirdad.calculator.UI.MainActivityViewHolder;
import slirdad.calculator.Domain.Operation;

public class OnEqualMarkButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final MainActivityViewHolder holder;

    public OnEqualMarkButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
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
                var = MainActivityExtensionMethods.getNum(mainTextView);
            }
        } else {
            var = calculator.getVar();
        }

        CalculatorData calculatorData = calculator.operate(var, calculator.getCurrentOperation());
        MainActivityExtensionMethods.setCalcData(mainTextView, calculatorData);
    }
}
