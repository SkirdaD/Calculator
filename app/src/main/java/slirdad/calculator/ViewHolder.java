package slirdad.calculator;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

class ViewHolder extends AppCompatActivity {
    private final Button buttonNum1 = (Button) findViewById(R.id.button1);
    private final Button buttonNum2 = (Button) findViewById(R.id.button2);
    private final Button buttonNum3 = (Button) findViewById(R.id.button3);
    private final Button buttonNum4 = (Button) findViewById(R.id.button4);
    private final Button buttonNum5 = (Button) findViewById(R.id.button5);
    private final Button buttonNum6 = (Button) findViewById(R.id.button6);
    private final Button buttonNum7 = (Button) findViewById(R.id.button7);
    private final Button buttonNum8 = (Button) findViewById(R.id.button8);
    private final Button buttonNum9 = (Button) findViewById(R.id.button9);
    private final Button buttonNum0 = (Button) findViewById(R.id.button0);
    private final Button buttonPoint = (Button) findViewById(R.id.buttonPoint);

    private final TextView mainTextView = (TextView) findViewById(R.id.textView1);
    private final Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
    private final Button buttonMinus = (Button) findViewById(R.id.buttonMinus);

    public ArrayList<Button> getNumButtons() {
        ArrayList<Button> numButtons = new ArrayList<>(11);
        Collections.addAll(numButtons, buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5,
                buttonNum6, buttonNum7, buttonNum8, buttonNum9, buttonNum0, buttonPoint);
        return numButtons;
    }

    public TextView getMainTextView() {
        return mainTextView;
    }

    public Button getButtonPlus() {
        return buttonPlus;
    }

    public Button getButtonMinus() {
        return buttonMinus;
    }
}
