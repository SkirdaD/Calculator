package slirdad.calculator;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivityViewHolder {

    private final ArrayList<Button> numButtons = new ArrayList<>();

    private final TextView mainTextView;

    private final Button plusButton, minusButton, allCleanButton, deleteLastCharacterButton,
            positiveToNegativeButton, divisionSignButton, multiplicationSignButton, equalMarkButton;


    MainActivityViewHolder(AppCompatActivity activity) {
        Button num1Button = (Button) activity.findViewById(R.id.button1);
        Button num2Button = (Button) activity.findViewById(R.id.button2);
        Button num3Button = (Button) activity.findViewById(R.id.button3);
        Button num4Button = (Button) activity.findViewById(R.id.button4);
        Button num5Button = (Button) activity.findViewById(R.id.button5);
        Button num6Button = (Button) activity.findViewById(R.id.button6);
        Button num7Button = (Button) activity.findViewById(R.id.button7);
        Button num8Button = (Button) activity.findViewById(R.id.button8);
        Button num9Button = (Button) activity.findViewById(R.id.button9);
        Button num0Button = (Button) activity.findViewById(R.id.button0);
        Button pointButton = (Button) activity.findViewById(R.id.buttonPoint);

        mainTextView = (TextView) activity.findViewById(R.id.textView1);

        plusButton = (Button) activity.findViewById(R.id.buttonPlus);
        minusButton = (Button) activity.findViewById(R.id.buttonMinus);
        allCleanButton = (Button) activity.findViewById(R.id.buttonAC);
        deleteLastCharacterButton = (Button) activity.findViewById(R.id.buttonDelete);
        positiveToNegativeButton = (Button) activity.findViewById(R.id.buttonPlusMinus);
        divisionSignButton = (Button) activity.findViewById(R.id.buttonDivision);
        multiplicationSignButton = (Button) activity.findViewById(R.id.buttonMultiplication);
        equalMarkButton = (Button) activity.findViewById(R.id.buttonResult);

        Collections.addAll(numButtons, num1Button, num2Button, num3Button, num4Button, num5Button,
                num6Button, num7Button, num8Button, num9Button, num0Button, pointButton);
    }


    public ArrayList<Button> getNumButtons() {
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
