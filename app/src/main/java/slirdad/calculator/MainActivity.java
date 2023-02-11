package slirdad.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private final Calculator calculator = new Calculator();

    private SharedPreferences SP;

    private TextView mainField;//, secondaryField;

    private String textMainField;//, textSecondaryField = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        //SP = this.getSharedPreferences(StringKeys.SAVE_TEXT, MODE_PRIVATE);

        final Button buttonNum1 = (Button) findViewById(R.id.button1);
        final Button buttonNum2 = (Button) findViewById(R.id.button2);
        final Button buttonNum3 = (Button) findViewById(R.id.button3);
        final Button buttonNum4 = (Button) findViewById(R.id.button4);
        final Button buttonNum5 = (Button) findViewById(R.id.button5);
        final Button buttonNum6 = (Button) findViewById(R.id.button6);
        final Button buttonNum7 = (Button) findViewById(R.id.button7);
        final Button buttonNum8 = (Button) findViewById(R.id.button8);
        final Button buttonNum9 = (Button) findViewById(R.id.button9);
        final Button buttonNum0 = (Button) findViewById(R.id.button0);
        final Button buttonAllClean = (Button) findViewById(R.id.buttonAC);
        final Button buttonDeleteLastCharacter = (Button) findViewById(R.id.buttonDelete);
        final Button buttonPositiveToNegative = (Button) findViewById(R.id.buttonPlusMinus);
        final Button buttonDivisionSign = (Button) findViewById(R.id.buttonDivision);
        final Button buttonMultiplicationSign = (Button) findViewById(R.id.buttonMultiplication);
        final Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        final Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        final Button buttonEqualMark = (Button) findViewById(R.id.buttonResult);
        final Button buttonPoint = (Button) findViewById(R.id.buttonPoint);

        final ArrayList<Button> numButtons = new ArrayList<>(11);
        Collections.addAll(numButtons, buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5,
                buttonNum6, buttonNum7, buttonNum8, buttonNum9, buttonNum0, buttonPoint);


        mainField = (TextView) findViewById(R.id.textView1);
        //secondaryField = (TextView) findViewById(R.id.textView2);

        textMainField = "0";// так сделано, пока нет шареда
        mainField.setText(textMainField);

        View.OnClickListener onClickListenerForNumbers = view -> {
            if (textMainField.equals("0")) {  // что бы при вводе затирался начальный ноль
                textMainField = "";
            }

            int id = view.getId();

            if (id == R.id.button1) {
                textMainField = textMainField + "1";
            } else if (id == R.id.button2) {
                textMainField = textMainField + "2";
            } else if (id == R.id.button3) {
                textMainField = textMainField + "3";
            } else if (id == R.id.button4) {
                textMainField = textMainField + "4";
            } else if (id == R.id.button5) {
                textMainField = textMainField + "5";
            } else if (id == R.id.button6) {
                textMainField = textMainField + "6";
            } else if (id == R.id.button7) {
                textMainField = textMainField + "7";
            } else if (id == R.id.button8) {
                textMainField = textMainField + "8";
            } else if (id == R.id.button9) {
                textMainField = textMainField + "9";
            } else if (id == R.id.button0) {
                textMainField = textMainField + "0";
            } else if (id == R.id.buttonPoint) {
                if (!textMainField.contains(".")) {    //если в строке нет точки
                    textMainField = (textMainField.equals("")) ? ("0.") : (textMainField + ".");
                } else return;
            }

            //changeSizeText();
            mainField.setText(textMainField);
        };


        View.OnClickListener onClickListenerButtonPlus = view -> {
            settingField
                    (calculator.operate(
                            readingField(mainField), Operation.ADDITION));
        };

        View.OnClickListener onClickListenerButtonMinus = v -> {
            settingField
                    (calculator.operate(
                            readingField(mainField), Operation.SUBTRACTION));
        };


        for (Button button : numButtons) {
            button.setOnClickListener(onClickListenerForNumbers);
        }


        buttonPlus.setOnClickListener(onClickListenerButtonPlus);
        buttonMinus.setOnClickListener(onClickListenerButtonMinus);
        //buttonMultiplicationSign.setOnClickListener(onClickListenerButtonMultiplicationSign);
        //buttonDivisionSign.setOnClickListener(onClickListenerButtonDivisionSign);
        //buttonEqualMark.setOnClickListener(onClickListenerButtonEqualMark);
        //buttonAllClean.setOnClickListener(onClickListenerButtonAllClean);
        //buttonDeleteLastCharacter.setOnClickListener(onClickListenerButtonDeleteLastCharacter);
        //buttonPositiveToNegative.setOnClickListener(onClickListenerButtonPositiveToNegative);
    }

    private double readingField(TextView mainField) {
        return Double.parseDouble(mainField.getText().toString());
    }

    private void settingField(CalculatorData calculatorData) {
        textMainField = Double.toString(calculatorData.result);
        mainField.setText(textMainField);
        textMainField = "";

    }
}