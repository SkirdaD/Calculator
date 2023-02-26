package slirdad.calculator.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.UI.MainActivityExtensionMethods;
import slirdad.calculator.UI.MainActivityViewHolder;
import slirdad.calculator.Domain.Operation;

public class OnSignChangeButtonClickListener implements View.OnClickListener {
    private final MainActivityViewHolder holder;
    private final Calculator calculator;

    public OnSignChangeButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
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

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);

        if (calculator.isOperationFinished()) {
            calculator.setCurrentOperation(Operation.NONE);
            calculator.setOperationFinished(false);
        }
    }
}
