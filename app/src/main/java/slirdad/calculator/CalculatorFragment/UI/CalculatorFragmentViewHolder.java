package slirdad.calculator.CalculatorFragment.UI;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import slirdad.calculator.R;

public class CalculatorFragmentViewHolder {

    private final ArrayList<Button> numButtons = new ArrayList<>();

    private final TextView mainTextView;

    private final Button plusButton, minusButton, allCleanButton, deleteLastCharacterButton,
            signChangeButton, divisionSignButton, multiplicationSignButton, equalMarkButton, pointButton;


    @SuppressWarnings("RedundantCast")
    CalculatorFragmentViewHolder(View view) {
        Button num1Button = (Button) view.findViewById(R.id.button1);
        Button num2Button = (Button) view.findViewById(R.id.button2);
        Button num3Button = (Button) view.findViewById(R.id.button3);
        Button num4Button = (Button) view.findViewById(R.id.button4);
        Button num5Button = (Button) view.findViewById(R.id.button5);
        Button num6Button = (Button) view.findViewById(R.id.button6);
        Button num7Button = (Button) view.findViewById(R.id.button7);
        Button num8Button = (Button) view.findViewById(R.id.button8);
        Button num9Button = (Button) view.findViewById(R.id.button9);
        Button num0Button = (Button) view.findViewById(R.id.button0);

        mainTextView = (TextView) view.findViewById(R.id.textView1);

        plusButton = (Button) view.findViewById(R.id.buttonPlus);
        minusButton = (Button) view.findViewById(R.id.buttonMinus);
        allCleanButton = (Button) view.findViewById(R.id.buttonAC);
        deleteLastCharacterButton = (Button) view.findViewById(R.id.buttonDelete);
        signChangeButton = (Button) view.findViewById(R.id.buttonPlusMinus);
        divisionSignButton = (Button) view.findViewById(R.id.buttonDivision);
        multiplicationSignButton = (Button) view.findViewById(R.id.buttonMultiplication);
        equalMarkButton = (Button) view.findViewById(R.id.buttonResult);
        pointButton = (Button) view.findViewById(R.id.buttonPoint);

        Collections.addAll(numButtons, num1Button, num2Button, num3Button, num4Button, num5Button,
                num6Button, num7Button, num8Button, num9Button, num0Button);
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

    public Button getSignChangeButton() {
        return signChangeButton;
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

    public Button getPointButton() {
        return pointButton;
    }
}
