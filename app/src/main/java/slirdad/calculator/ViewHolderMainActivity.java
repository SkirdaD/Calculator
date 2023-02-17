package slirdad.calculator;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

class ViewHolderMainActivity {

    private AppCompatActivity activity;

    ViewHolderMainActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    private final Button num1Button = (Button) activity.findViewById(R.id.button1);
    private final Button num2Button = (Button) activity.findViewById(R.id.button2);
    private final Button num3Button = (Button) activity.findViewById(R.id.button3);
    private final Button num4Button = (Button) activity.findViewById(R.id.button4);
    private final Button num5Button = (Button) activity.findViewById(R.id.button5);
    private final Button num6Button = (Button) activity.findViewById(R.id.button6);
    private final Button num7Button = (Button) activity.findViewById(R.id.button7);
    private final Button num8Button = (Button) activity.findViewById(R.id.button8);
    private final Button num9Button = (Button) activity.findViewById(R.id.button9);
    private final Button num0Button = (Button) activity.findViewById(R.id.button0);
    private final Button pointButton = (Button) activity.findViewById(R.id.buttonPoint);

    private final TextView mainTextView = (TextView) activity.findViewById(R.id.textView1);
    private final Button plusButton = (Button) activity.findViewById(R.id.buttonPlus);
    private final Button minusButton = (Button) activity.findViewById(R.id.buttonMinus);
    private final Button allCleanButton = (Button) activity.findViewById(R.id.buttonAC);
    private final Button deleteLastCharacterButton =
            (Button) activity.findViewById(R.id.buttonDelete);
    private final Button positiveToNegativeButton =
            (Button) activity.findViewById(R.id.buttonPlusMinus);
    private final Button divisionSignButton = (Button) activity.findViewById(R.id.buttonDivision);
    private final Button multiplicationSignButton =
            (Button) activity.findViewById(R.id.buttonMultiplication);
    private final Button equalMarkButton = (Button) activity.findViewById(R.id.buttonResult);

    public ArrayList<Button> getNumButtons() {
        ArrayList<Button> numButtons = new ArrayList<>(11);
        Collections.addAll(numButtons, num1Button, num2Button, num3Button, num4Button, num5Button,
                num6Button, num7Button, num8Button, num9Button, num0Button, pointButton);
        return numButtons;
    }

    public TextView getMainTextView() {
        return mainTextView;
    }

    public Button getPlusButton() {
        return plusButton;
    }

    public Button getMinusButton() {
        return minusButton;
    }

    public Button getAllCleanButton() {
        return allCleanButton;
    }

    public Button getDeleteLastCharacterButton() {
        return deleteLastCharacterButton;
    }

    public Button getPositiveToNegativeButton() {
        return positiveToNegativeButton;
    }

    public Button getDivisionSignButton() {
        return divisionSignButton;
    }

    public Button getMultiplicationSignButton() {
        return multiplicationSignButton;
    }

    public Button getEqualMarkButton() {
        return equalMarkButton;
    }
}
