package slirdad.calculator;

import android.view.View;
import android.widget.TextView;


class OnPlusButtonClickListener implements View.OnClickListener {
    Calculator calculator;
    MainActivityViewHolder holder;

    OnPlusButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();

        double var;

        if (calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() == Operation.ADDITION) {
                return;
            } else {
                var = 0;
            }
        } else {
            var = ExtensionMethods.getNum(mainTextView);
        }

        CalculatorData calculatorData = calculator.operate(var, Operation.ADDITION);
        ExtensionMethods.setCalcData(mainTextView, calculatorData);
    }
}