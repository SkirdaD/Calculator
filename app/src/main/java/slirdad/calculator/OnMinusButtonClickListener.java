package slirdad.calculator;

import android.view.View;
import android.widget.TextView;

public class OnMinusButtonClickListener implements View.OnClickListener {
    Calculator calculator;
    MainActivityViewHolder holder;

    OnMinusButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();

        double var;

        if (calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() == Operation.SUBTRACTION) {
                return;
            } else {
                var = 0;
            }
        } else {
            var = ExtensionMethods.getNum(mainTextView);
        }

        CalculatorData calculatorData = calculator.operate(var, Operation.SUBTRACTION);
        ExtensionMethods.setCalcData(mainTextView, calculatorData);
    }
}
