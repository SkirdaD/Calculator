package slirdad.calculator.OnClickListeners;

import android.view.View;
import android.widget.TextView;


import slirdad.calculator.Calculator;
import slirdad.calculator.MainActivityExtensionMethods;
import slirdad.calculator.MainActivityViewHolder;

public class OnPointButtonClickListener implements View.OnClickListener {

    private final Calculator calculator;
    private final MainActivityViewHolder holder;


    public OnPointButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
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

        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }
}
