package slirdad.calculator;

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

    private TextView mainField, secondaryField;

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
        secondaryField = (TextView) findViewById(R.id.textView2);

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
            changeSizeText(textMainField, mainField);
            mainField.setText(textMainField);
        };


        View.OnClickListener onClickListenerButtonPlus = view -> {
//            if (calculator.calculatorData.lastOperation == Operation.ADDITION &&
//                    textMainField.equals("")) {
//                return;
//            }
            settingFields
                    (calculator.operate(
                            readingFields(mainField), Operation.ADDITION));
        };

        View.OnClickListener onClickListenerButtonMinus = v -> {
//            if (calculator.calculatorData.lastOperation == Operation.SUBTRACTION &&
//                    textMainField.equals("")) {
//                return;
//            }
            settingFields
                    (calculator.operate(
                            readingFields(mainField), Operation.SUBTRACTION));
        };

        View.OnClickListener onClickListenerButtonEqualMark = v -> {
            double var = calculator.calculatorData.var;
            //Operation curOper = calculator.calculatorData.lastOperation;
            //settingFields(calculator.operate(var, curOper));
            //это повторное нажатаие на =, надо еще сделать первое нажатие
            //calculator.calculatorData = new CalculatorData(result)
        };


        for (Button button : numButtons) {
            button.setOnClickListener(onClickListenerForNumbers);
        }


        buttonPlus.setOnClickListener(onClickListenerButtonPlus);
        buttonMinus.setOnClickListener(onClickListenerButtonMinus);
        buttonEqualMark.setOnClickListener(onClickListenerButtonEqualMark);
        //buttonMultiplicationSign.setOnClickListener(onClickListenerButtonMultiplicationSign);
        //buttonDivisionSign.setOnClickListener(onClickListenerButtonDivisionSign);
        //buttonAllClean.setOnClickListener(onClickListenerButtonAllClean);
        //buttonDeleteLastCharacter.setOnClickListener(onClickListenerButtonDeleteLastCharacter);
        //buttonPositiveToNegative.setOnClickListener(onClickListenerButtonPositiveToNegative);
    }

    private double readingFields(TextView mainField) {
        return Double.parseDouble(mainField.getText().toString());
    }

    private void settingFields(CalculatorData calculatorData) {
        if (calculatorData.isDivisionByZero) {
            showErrorForDivideByZero();
        } else {
            textMainField = Double.toString(calculatorData.result);
            changeSizeText(textMainField, mainField);
            mainField.setText(textMainField);
            textMainField = "";
            showAllInSecondary(calculatorData);
        }
    }

    private void changeSizeText(String text, TextView field) {
        final int NUMBER_OF_LARGE_CHARACTERS = 8;
        final int NUMBER_OF_MEDIUM_CHARACTERS = 11;
        final int SIZE_LARGE_TEXT = 100;
        final int SIZE_MEDIUM_TEXT = 70;
        final int SIZE_SMALL_TEXT = 40;

        if (text.length() < NUMBER_OF_LARGE_CHARACTERS) {
            field.setTextSize(SIZE_LARGE_TEXT);
        } else if (text.length() < NUMBER_OF_MEDIUM_CHARACTERS) {
            field.setTextSize(SIZE_MEDIUM_TEXT);
        } else {
            field.setTextSize(SIZE_SMALL_TEXT);
        }
    }

    private void showErrorForDivideByZero() {
        Toast.makeText(getApplicationContext(),
                R.string.division_error, Toast.LENGTH_LONG).show();
        mainField.setText(R.string.error);
        textMainField = "";
        //textSecondaryField = "";
        //secondaryField.setText(textSecondaryField);
    }

    private void showAllInSecondary(CalculatorData c) {
        secondaryField.setText(
                "cur=" + c.currentOperation + "  var=" + c.var + "   result=" + c.result
        );
    }
}
