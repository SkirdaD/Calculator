package slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentViewHolder;

public class OnAllCleanButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final CalculatorFragmentViewHolder holder;

    public OnAllCleanButtonClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();
        CalculatorFragmentExtensionMethods.resetData(calculator);

        String text = "0";
        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
    }
}
