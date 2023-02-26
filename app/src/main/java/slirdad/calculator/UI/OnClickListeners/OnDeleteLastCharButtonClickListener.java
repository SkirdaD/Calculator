package slirdad.calculator.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.UI.MainActivityExtensionMethods;
import slirdad.calculator.UI.MainActivityViewHolder;

public class OnDeleteLastCharButtonClickListener implements View.OnClickListener {
    private final MainActivityViewHolder holder;
    private final Calculator calculator;

    public OnDeleteLastCharButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
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

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
    }
}