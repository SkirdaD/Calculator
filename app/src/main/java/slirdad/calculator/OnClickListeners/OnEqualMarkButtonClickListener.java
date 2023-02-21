package slirdad.calculator.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Calculator;
import slirdad.calculator.CalculatorData;
import slirdad.calculator.MainActivityExtensionMethods;
import slirdad.calculator.MainActivityViewHolder;
import slirdad.calculator.Operation;

public class OnEqualMarkButtonClickListener implements View.OnClickListener, Calculator.Callback {
    private final Calculator calculator;
    private final MainActivityViewHolder holder;

    public OnEqualMarkButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
        calculator.registerCallBack(this);

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

    @Override
    public void showDivisionByZeroError() {
        calculator.setVar(999999);
        holder.getMainTextView().setText("Залупа");
    }
}
