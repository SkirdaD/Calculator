package slirdad.calculator.OnClickListeners;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Calculator;
import slirdad.calculator.CalculatorData;
import slirdad.calculator.MainActivityExtensionMethods;
import slirdad.calculator.MainActivityViewHolder;
import slirdad.calculator.Operation;

public class OnMinusButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final MainActivityViewHolder holder;
    private final Context context;

    public OnMinusButtonClickListener(Calculator calculator, MainActivityViewHolder holder, Context context) {
        this.calculator = calculator;
        this.holder = holder;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();

        double var;

        if (calculator.isOperationFinished()) {
            if (calculator.getCurrentOperation() != Operation.SUBTRACTION) {
                calculator.setVar(0);
                calculator.setCurrentOperation(Operation.SUBTRACTION);
            }
            return;
        } else {
            var = MainActivityExtensionMethods.getNum(mainTextView);
        }

        CalculatorData calculatorData = calculator.operate(var, Operation.SUBTRACTION);
        if (!calculator.isDivisionByZero()) {
            MainActivityExtensionMethods.setCalcData(mainTextView, calculatorData);
        } else {
            MainActivityExtensionMethods.showDivisionByZeroError(context, holder, calculator);
        }
    }
}
