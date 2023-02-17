package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final Calculator calculator = new Calculator();
        final ViewHolder viewHolder = new ViewHolder();

        final Button buttonAllClean = (Button) findViewById(R.id.buttonAC);
        final Button buttonDeleteLastCharacter = (Button) findViewById(R.id.buttonDelete);
        final Button buttonPositiveToNegative = (Button) findViewById(R.id.buttonPlusMinus);
        final Button buttonDivisionSign = (Button) findViewById(R.id.buttonDivision);
        final Button buttonMultiplicationSign = (Button) findViewById(R.id.buttonMultiplication);
        final Button buttonEqualMark = (Button) findViewById(R.id.buttonResult);

        viewHolder.getMainTextView().setText("0"); // так сделано, пока нет шареда

        View.OnClickListener onClickListenerForNumbers = view -> {
            TextView mainTextView = viewHolder.getMainTextView();
            String text = mainTextView.getText().toString();
            /*При вводе затирался начальный ноль или
            после нажатия на кнопку операции затирается то, что сейчас в mainTextView*/
            if (text.equals("0") || calculator.isOperationFinished()) {
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
            calculator.setOperationFinished(false);
        };


        View.OnClickListener onPlusButtonClickListener = view -> {
            TextView mainTextView = viewHolder.getMainTextView();

            double var;
            /*Реализовано повторное нажатие на одну и ту же кнопку,
             *перевыбор действия сразу,
             *перевыбор в процессе вычислений  */
            if (calculator.isOperationFinished()) {
                if (calculator.getCurrentOperation() == Operation.ADDITION) {
                    return;
                } else {
                    var = 0;
                }
            } else {
                var = ExtensionMethods.getNum(mainTextView);
            }

            CalculatorData calculatorData = calculator.operate(var, Operation.ADDITION);
            ExtensionMethods.setCalcData(mainTextView, calculatorData);
        };

        View.OnClickListener onMinusButtonClickListener = v -> {
            TextView mainTextView = viewHolder.getMainTextView();

            double var;
            if (calculator.isOperationFinished()) {
                if (calculator.getCurrentOperation() == Operation.SUBTRACTION) {
                    return;
                } else {
                    var = 0;
                }
            } else {
                var = ExtensionMethods.getNum(mainTextView);
            }

            CalculatorData calculatorData = calculator.operate(var, Operation.SUBTRACTION);
            ExtensionMethods.setCalcData(mainTextView, calculatorData);
        };

        View.OnClickListener onEqualMarkButtonClickListener = v -> {
        };


        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(onClickListenerForNumbers);
        }
        viewHolder.getButtonPlus().setOnClickListener(onPlusButtonClickListener);
        viewHolder.getButtonMinus().setOnClickListener(onMinusButtonClickListener);
        buttonEqualMark.setOnClickListener(onEqualMarkButtonClickListener);
    }
}
