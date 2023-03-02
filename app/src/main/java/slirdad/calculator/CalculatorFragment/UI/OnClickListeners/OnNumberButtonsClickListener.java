package slirdad.calculator.CalculatorFragment.UI.OnClickListeners;

import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import slirdad.calculator.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragmentViewHolder;
import slirdad.calculator.R;

public class OnNumberButtonsClickListener implements View.OnClickListener {

    private final Calculator calculator;
    private final CalculatorFragmentViewHolder holder;

    final private HashMap<Integer, String> buttonValuesMap = new HashMap<Integer, String>(){{
        put(R.id.button0, "0");
        put(R.id.button1, "1");
        put(R.id.button2, "2");
        put(R.id.button3, "3");
        put(R.id.button4, "4");
        put(R.id.button5, "5");
        put(R.id.button6, "6");
        put(R.id.button7, "7");
        put(R.id.button8, "8");
        put(R.id.button9, "9");
    }};

    public OnNumberButtonsClickListener(Calculator calculator, CalculatorFragmentViewHolder holder) {
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

        text = text + buttonValuesMap.get(v.getId());

        CalculatorFragmentExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }
}
