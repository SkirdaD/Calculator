package slirdad.calculator.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import slirdad.calculator.Calculator;
import slirdad.calculator.MainActivityExtensionMethods;
import slirdad.calculator.MainActivityViewHolder;
import slirdad.calculator.R;

public class OnNumberButtonsClickListener implements View.OnClickListener {

    private final Calculator calculator;
    private final MainActivityViewHolder holder;

    final private HashMap<Integer, String> buttonValuesMap = new HashMap<>();

    {
        buttonValuesMap.put(R.id.button0, "0");
        buttonValuesMap.put(R.id.button1, "1");
        buttonValuesMap.put(R.id.button2, "2");
        buttonValuesMap.put(R.id.button3, "3");
        buttonValuesMap.put(R.id.button4, "4");
        buttonValuesMap.put(R.id.button5, "5");
        buttonValuesMap.put(R.id.button6, "6");
        buttonValuesMap.put(R.id.button7, "7");
        buttonValuesMap.put(R.id.button8, "8");
        buttonValuesMap.put(R.id.button9, "9");
    }

    public OnNumberButtonsClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();
        String text = mainTextView.getText().toString();

        if (text.equals("0") || calculator.isOperationFinished()) {
            text = "";
        }

        if (buttonValuesMap.get(v.getId()) != null) {
            text = text + buttonValuesMap.get(v.getId());
        } else if (!text.contains(".")) {
            text = (text.equals("")) ? ("0.") : (text + ".");
        } else return;

        text = MainActivityExtensionMethods.formatWholeDoubleAsInt(text);
        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }
}
