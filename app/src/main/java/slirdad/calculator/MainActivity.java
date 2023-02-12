package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private final Calculator calculator = new Calculator();

    private TextView mainField, secondaryField;

    private String textMainField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

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
        secondaryField = (TextView) findViewById(R.id.textView2);

        textMainField = "0";// так сделано, пока нет шареда
        mainField.setText(textMainField);

        View.OnClickListener onClickListenerForNumbers = view -> {
            if (textMainField.equals("0")) { // что бы при вводе затирался начальный ноль
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
            changeSizeText(textMainField, mainField);
            mainField.setText(textMainField);
        };


        View.OnClickListener onClickListenerButtonPlus = view -> {
            double var = readFields(mainField);
            CalculatorData calculatorData = calculator.operate(var, Operation.ADDITION);
            setFields(calculatorData);
        };

        View.OnClickListener onClickListenerButtonMinus = v -> {
        };

        View.OnClickListener onClickListenerButtonEqualMark = v -> {
        };


        for (Button button : numButtons) {
            button.setOnClickListener(onClickListenerForNumbers);
        }


        buttonPlus.setOnClickListener(onClickListenerButtonPlus);
        buttonMinus.setOnClickListener(onClickListenerButtonMinus);
        buttonEqualMark.setOnClickListener(onClickListenerButtonEqualMark);
    }

    private double readFields(TextView mainField) {
        double var = Double.parseDouble(mainField.getText().toString());
        return var;
    }

    private void setFields(CalculatorData calculatorData) {
        textMainField = Double.toString(calculatorData.result);
        changeSizeText(textMainField, mainField);
        mainField.setText(textMainField);
        textMainField = "";
        showAllInSecondary(calculatorData);
    }

    private void changeSizeText(String text, TextView textView) {
        final int NUMBER_OF_LARGE_CHARACTERS = 8;
        final int NUMBER_OF_MEDIUM_CHARACTERS = 11;
        final int SIZE_LARGE_TEXT = 100;
        final int SIZE_MEDIUM_TEXT = 70;
        final int SIZE_SMALL_TEXT = 40;

        if (text.length() < NUMBER_OF_LARGE_CHARACTERS) {
            textView.setTextSize(SIZE_LARGE_TEXT);
        } else if (text.length() < NUMBER_OF_MEDIUM_CHARACTERS) {
            textView.setTextSize(SIZE_MEDIUM_TEXT);
        } else {
            textView.setTextSize(SIZE_SMALL_TEXT);
        }
    }

    private void showErrorForDivideByZero() {
        Toast.makeText(getApplicationContext(),
                R.string.division_error, Toast.LENGTH_LONG).show();
        mainField.setText(R.string.error);
        textMainField = "";
    }

    private void showAllInSecondary(CalculatorData calculatorData) {
        secondaryField.setText(
                "cur=" + calculatorData.operation + "  var=" + calculatorData.var +
                        "   result=" + calculatorData.result
        );
    }
}
