package slirdad.calculator.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.Domain.Calculator;
import slirdad.calculator.UI.MainActivityExtensionMethods;
import slirdad.calculator.UI.MainActivityViewHolder;

public class OnAllCleanButtonClickListener implements View.OnClickListener {
    private final Calculator calculator;
    private final MainActivityViewHolder holder;

    public OnAllCleanButtonClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();
        MainActivityExtensionMethods.resetData(calculator);

        String text = "0";
        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
    }
}
