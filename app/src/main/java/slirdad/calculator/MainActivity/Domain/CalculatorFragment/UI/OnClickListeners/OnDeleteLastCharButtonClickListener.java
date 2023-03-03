package slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentViewHolder;

public class OnDeleteLastCharButtonClickListener implements View.OnClickListener {
    private final CalculatorFragmentViewHolder holder;
    private final Calculator calculator;

    public OnDeleteLastCharButtonClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
        this.holder = holder;
        this.calculator = calculator;
    }

    @Override
    public void onClick(View v) {
        if (calculator.isOperationFinished()) {
            return;
        }

        TextView mainTextView = holder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.length() > 1) {
            text = text.substring(0, text.length() - 1);
        } else text = "0";

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
    }
}
