package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Operation currentOperation = Operation.NONE;
    private boolean isFinishOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final Calculator calculator = new Calculator();

        final TextView mainTextView = (TextView) findViewById(R.id.textView1);
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

        mainTextView.setText("0"); // так сделано, пока нет шареда

        View.OnClickListener onClickListenerForNumbers = view -> {
            String text = mainTextView.getText().toString();
            /*При вводе затирался начальный ноль или
            после нажатия на кнопку операции затирается то, что сейчас в mainTextView*/
            if (text.equals("0") || isFinishOperation) {
                text = "";
            }

            int id = view.getId();

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
            isFinishOperation = false;
        };


        View.OnClickListener onClickListenerButtonPlus = view -> {
            double var;
            /*Реализовано повторное нажатие на одну и ту же кнопку,
             *перевыбор действия сразу,
             *перевыбор в процессе вычислений  */
            if (isFinishOperation) {
                if (currentOperation == Operation.ADDITION) {
                    return;
                } else {
                    var = 0;
                }
            } else {
                var = ExtensionMethods.getNum(mainTextView);
            }

            CalculatorData calculatorData = calculator.operate(var, currentOperation,
                    Operation.ADDITION);
            ExtensionMethods.setCalcData(mainTextView, calculatorData);
            currentOperation = calculatorData.nextOperation;
            isFinishOperation = true;
        };

        View.OnClickListener onClickListenerButtonMinus = v -> {
            double var;
            if (isFinishOperation) {
                if (currentOperation == Operation.SUBTRACTION) {
                    return;
                } else {
                    var = 0;
                }
            } else {
                var = ExtensionMethods.getNum(mainTextView);
            }

            CalculatorData calculatorData = calculator.operate(var, currentOperation,
                    Operation.SUBTRACTION);
            ExtensionMethods.setCalcData(mainTextView, calculatorData);
            currentOperation = calculatorData.nextOperation;
            isFinishOperation = true;
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
}
