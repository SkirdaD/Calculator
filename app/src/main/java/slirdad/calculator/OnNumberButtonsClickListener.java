package slirdad.calculator;

import android.view.View;
import android.widget.TextView;

public class OnNumberButtonsClickListener implements View.OnClickListener {

    Calculator calculator;
    MainActivityViewHolder holder;

    OnNumberButtonsClickListener(Calculator calculator, MainActivityViewHolder holder) {
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

        int id = v.getId();

        if (id == R.id.button1) {
            text = text + "1";
        } else if (id == R.id.button2) {
            text = text + "2";
        } else if (id == R.id.button3) {
            text = text + "3";
        } else if (id == R.id.button4) {
            text = text + "4";
        } else if (id == R.id.button5) {
            text = text + "5";
        } else if (id == R.id.button6) {
            text = text + "6";
        } else if (id == R.id.button7) {
            text = text + "7";
        } else if (id == R.id.button8) {
            text = text + "8";
        } else if (id == R.id.button9) {
            text = text + "9";
        } else if (id == R.id.button0) {
            text = text + "0";
        } else if (id == R.id.buttonPoint) {
            if (!text.contains(".")) {
                text = (text.equals("")) ? ("0.") : (text + ".");
            } else return;
        }
        ExtensionMethods.changeSizeText(text, mainTextView);
        mainTextView.setText(text);
        calculator.setOperationFinished(false);
    }
}
