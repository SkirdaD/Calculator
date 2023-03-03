package slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;


import slirdad.calculator.MainActivity.Domain.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragmentViewHolder;

public class OnPointButtonClickListener implements View.OnClickListener {

    private final Calculator calculator;
    private final CalculatorFragmentViewHolder holder;


    public OnPointButtonClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (!text.contains(".")) {
            text = (calculator.isOperationFinished() ? ("0.") : (text + "."));
        } else return;

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }
}
