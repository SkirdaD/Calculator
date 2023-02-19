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

    public OnNumberButtonsClickListener(Calculator calculator, MainActivityViewHolder holder) {
        this.calculator = calculator;
        this.holder = holder;
    }

    @Override
    public void onClick(View v) {
        TextView mainTextView = holder.getMainTextView();
        String text = mainTextView.getText().toString();
            /*При вводе затирался начальный ноль или
            после нажатия на кнопку операции затирается то, что сейчас в mainTextView*/
        if (text.equals("0") || calculator.isOperationFinished()) {
            text = "";
        }

        final HashMap<Integer, String> buttonValues = new HashMap<>();
        buttonValues.put(R.id.button0, "0");
        buttonValues.put(R.id.button1, "1");
        buttonValues.put(R.id.button2, "2");
        buttonValues.put(R.id.button3, "3");
        buttonValues.put(R.id.button4, "4");
        buttonValues.put(R.id.button5, "5");
        buttonValues.put(R.id.button6, "6");
        buttonValues.put(R.id.button7, "7");
        buttonValues.put(R.id.button8, "8");
        buttonValues.put(R.id.button9, "9");

        if (buttonValues.get(v.getId())!= null){
            text = text + buttonValues.get(v.getId());
        } else if (!text.contains(".")){
            text = (text.equals("")) ? ("0.") : (text + ".");
        } else return;

        text = MainActivityExtensionMethods.formatWholeDoubleAsInt(text);
        MainActivityExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }
}
