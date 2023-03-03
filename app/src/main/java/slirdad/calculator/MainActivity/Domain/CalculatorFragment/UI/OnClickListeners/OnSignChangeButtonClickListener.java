package slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentViewHolder;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Operation;

public class OnSignChangeButtonClickListener implements View.OnClickListener {
    private final CalculatorFragmentViewHolder holder;
    private final Calculator calculator;

    public OnSignChangeButtonClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
        this.holder = holder;
        this.calculator = calculator;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.equals("0")) {
            return;
        } else if (text.charAt(0) != '-') {
            text = "-" + text;
        } else {
            text = text.substring(1);
        }

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);

        if (calculator.isOperationFinished()) {
            calculator.setCurrentOperation(Operation.NONE);
            calculator.setOperationFinished(false);
        }
    }
}
