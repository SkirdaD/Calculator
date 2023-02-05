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

    private LastOperation lastOperation;
    private double result, var1, var2;
    private boolean isLastPressButtonEqualMark;


    /*  Создаю объект класса Calculation для доступа к переменным экземпляра класса.
            Не уверен, что это должно быть тут. Пока тут.
        Сначала создал в онКрейте. Всё работало, кроме onRestoreInstanceState и onSaveInstanceState.
        Я понимаю, что это связано с ЖЦ. Пока точно объяснить не могу.
        Но когда создаю объект в онКрейт, то при дестрое он уничтожается.
        Думаю, связано с этим.
        Сделал приватным, т.к. кроме активити его никто не должен использовать.
        И студия пишет, что может быть файнл. Не стал делать, т.к не понимаю пока этого.
         */
    private final Calculator calculator = new Calculator();

    /*
   инициализация SP, которая используется в ::onStart и в ::onStop, для сохранения и извлечения
    при закрытии приложения.
    Используется в итоге только в мэйне, поэтому приват.
    */
    private SharedPreferences SP;

    /*
     Тексвью используются:
      - в поиске вьюшек
      - во всех лисенерах
      - в онСтарт и онСтоп для шаредпреференс
      - в методах onRestoreInstanceState и onSaveInstanceState
      - в ::changeSizeText
      Но только в мэйне, поэтому можно сделать приватными, и тогда никто не сможет в них вмешаться.
      */
    private TextView mainField, secondaryField;

    /*
    Переменные инициализируюся дефолтными значениями.
    Используются:
      - во всех лисенерах кнопок;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в преференс
      Но только в мэйне, поэтому можно сделать приватными, и тогда никто не сможет в них вмешаться.
     */
    private String textMainField, textSecondaryField = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        lastOperation = LastOperation.NULL;

        SP = this.getSharedPreferences(StringKeys.SAVE_TEXT, MODE_PRIVATE);

         /*
    Баттоны используютя:
     - в поиске вьюшек
     - в назначении лисенера для соответствующей кнопки
     Поэтому можно сделать их локальными
     и файнл, потому что они один раз сетятся и больше не изменяются.
     */

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

            changeSizeText();
            mainField.setText(textMainField);
        };


        View.OnClickListener onClickListenerButtonPlus = view -> {
            if (checkForDivideByZeroError()) {
                return;
            }

            /*Продолжение действий после "РАВНО"*/
            if (isLastPressButtonEqualMark) {
                lastOperation = LastOperation.NULL;
                result = Double.parseDouble(mainField.getText().toString());
                var1 = 0;
            }

            /*повторное нажатие на то же действие = ничего не происходит*/
            if (textMainField.equals("") &&
                    lastOperation == LastOperation.ADDITION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "+" + " ";
            secondaryField.setText(textSecondaryField);

            /*если это не первое действие, то запускаем действие по предыдущему флагу,
            а если первое , то просто считываем с экрана число*/
            if (lastOperation != LastOperation.NULL) {
                /*если после одного действия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг */
                if (!textMainField.equals("")) {
                    var1 = Double.parseDouble(textMainField);
                } else if (!isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                }

                result = calculator.operate(lastOperation, result, var1);
                var2 = var1;

                textMainField = formattingWholeDoubleAsInt(String.valueOf(result));
                //textMainField = formattingWholeDoubleAsInt(new DecimalFormat(",###").format(calculator.result));


                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";

            } else if (!isLastPressButtonEqualMark) {
                result = Double.parseDouble(textMainField);
            }
            lastOperation = LastOperation.ADDITION;
            isLastPressButtonEqualMark = false;
            textMainField = "";
        };


        View.OnClickListener onClickListenerButtonMultiplicationSign = view -> {
            if (checkForDivideByZeroError()) {
                return;
            }

            if (calculator.isLastPressButtonEqualMark) {
                calculator.lastOperation = Calculator.LastOperation.NULL;
                calculator.result = Double.parseDouble(mainField.getText().toString());
                calculator.var1 = 1;
            }
            if (textMainField.equals("") &&
                    calculator.lastOperation == Calculator.LastOperation.MULTIPLICATION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "*" + " ";
            secondaryField.setText(textSecondaryField);

            if (calculator.lastOperation != Calculator.LastOperation.NULL) {
                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculator.var1 = Double.parseDouble(textMainField);
                } else if (!calculator.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculator.operate();

                textMainField = formattingWholeDoubleAsInt(String.valueOf(calculator.result));

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
            } else if (!calculator.isLastPressButtonEqualMark) {
                calculator.result = Double.parseDouble(textMainField);
            }
            calculator.lastOperation = Calculator.LastOperation.MULTIPLICATION;
            calculator.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonMinus = view -> {
            if (checkForDivideByZeroError()) {
                return;
            }

            if (calculator.isLastPressButtonEqualMark) {
                calculator.lastOperation = Calculator.LastOperation.NULL;
                calculator.result = Double.parseDouble(mainField.getText().toString());
                calculator.var1 = 0;
            }
            if (textMainField.equals("") &&
                    calculator.lastOperation == Calculator.LastOperation.SUBTRACTION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "-" + " ";
            secondaryField.setText(textSecondaryField);

            if (calculator.lastOperation != Calculator.LastOperation.NULL) {
                                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculator.var1 = Double.parseDouble(textMainField);
                } else if (!calculator.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculator.operate();

                textMainField = formattingWholeDoubleAsInt(String.valueOf(calculator.result));

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
            } else if (!calculator.isLastPressButtonEqualMark) {
                calculator.result = Double.parseDouble(textMainField);
            }

            calculator.lastOperation = Calculator.LastOperation.SUBTRACTION;
            calculator.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonDivisionSign = view -> {
            if (checkForDivideByZeroError()) {
                return;
            }

            if (calculator.isLastPressButtonEqualMark) {
                calculator.lastOperation = Calculator.LastOperation.NULL;
                calculator.result = Double.parseDouble(mainField.getText().toString());
                calculator.var1 = 1;
            }
            if (textMainField.equals("") &&
                    calculator.lastOperation == Calculator.LastOperation.DIVISION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "/" + " ";
            secondaryField.setText(textSecondaryField);

            if (calculator.lastOperation != Calculator.LastOperation.NULL) {
                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculator.var1 = Double.parseDouble(textMainField);
                } else if (!calculator.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculator.operate();

                textMainField = formattingWholeDoubleAsInt(String.valueOf(calculator.result));

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
            } else if (!calculator.isLastPressButtonEqualMark) {
                calculator.result = Double.parseDouble(textMainField);
            }

            calculator.lastOperation = Calculator.LastOperation.DIVISION;
            calculator.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonEqualMark = view -> {
            if (checkForDivideByZeroError()) {
                return;
            }

            if (calculator.lastOperation == Calculator.LastOperation.NULL) {
                return;
            }

            String var = "";
            if (calculator.isLastPressButtonEqualMark) {
                switch (calculator.lastOperation) {
                    case ADDITION:
                        textSecondaryField = textSecondaryField + " + " + var;
                        break;
                    case SUBTRACTION:
                        textSecondaryField = textSecondaryField + " - " + var;
                        break;
                    case DIVISION:
                        textSecondaryField = textSecondaryField + " / " + var;
                        break;
                    case MULTIPLICATION:
                        textSecondaryField = textSecondaryField + " * " + var;
                        break;
                }
            }

            /*если подряд нажимать = , то var1 не затирается в следующем operate,
             а так же при повороте экрана*/
            calculator.var1 = calculator.var2;
                            /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
            if (!textMainField.equals("")) {
                calculator.var1 = Double.parseDouble(textMainField);
            } else if (!calculator.isLastPressButtonEqualMark) {
                textSecondaryField = new StringBuffer(textSecondaryField).
                        delete(textSecondaryField.length() - 6,
                                textSecondaryField.length() - 3).toString();
                secondaryField.setText(textSecondaryField);
                //return;
            }

            calculator.operate();

            textMainField = formattingWholeDoubleAsInt(String.valueOf(calculator.result));

            changeSizeText();
            mainField.setText(textMainField);
            textMainField = "";
            calculator.isLastPressButtonEqualMark = true;

            var = formattingWholeDoubleAsInt(String.valueOf(calculator.var1));

            textSecondaryField = textSecondaryField + var + " " + "=";
            secondaryField.setText(textSecondaryField);
            textSecondaryField = mainField.getText().toString();
        };

        View.OnClickListener onClickListenerButtonAllClean = view -> {
            textMainField = "0";
            calculator.var1 = 0;
            calculator.result = 0;
            calculator.lastOperation = Calculator.LastOperation.NULL;
            calculator.isLastPressButtonEqualMark = false;
            changeSizeText();
            mainField.setText(textMainField);
            textSecondaryField = "";
            secondaryField.setText(textSecondaryField);
        };

        View.OnClickListener onClickListenerButtonDeleteLastCharacter = view -> {
            if (textMainField.length() > 1) {
                textMainField = textMainField.substring(0, textMainField.length() - 1);
            } else textMainField = "0";

            changeSizeText();
            mainField.setText(textMainField);
        };

        View.OnClickListener onClickListenerButtonPositiveToNegative = view -> {
            //что бы можно было менять знак в процессе вычислений, а не только в начале
            textMainField = mainField.getText().toString();

            if ((textMainField.equals("0")) || (textMainField.equals(""))) {
                return;
            }
            if (Double.parseDouble(textMainField) > 0) {
                textMainField = "-" + textMainField;
                changeSizeText();
                mainField.setText(textMainField);
                return;
            }
            if (Double.parseDouble(textMainField) < 0) {
                textMainField = textMainField.substring(1);
                changeSizeText();
                mainField.setText(textMainField);
            }
        };


        for (Button button : numButtons) {
            button.setOnClickListener(onClickListenerForNumbers);
        }
        buttonPlus.setOnClickListener(onClickListenerButtonPlus);
        buttonMultiplicationSign.setOnClickListener(onClickListenerButtonMultiplicationSign);
        buttonMinus.setOnClickListener(onClickListenerButtonMinus);
        buttonDivisionSign.setOnClickListener(onClickListenerButtonDivisionSign);
        buttonEqualMark.setOnClickListener(onClickListenerButtonEqualMark);
        buttonAllClean.setOnClickListener(onClickListenerButtonAllClean);
        buttonDeleteLastCharacter.setOnClickListener(onClickListenerButtonDeleteLastCharacter);
        buttonPositiveToNegative.setOnClickListener(onClickListenerButtonPositiveToNegative);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textMainField = SP.getString(StringKeys.SAVE_TEXT, "0");
        changeSizeText();
        mainField.setText(textMainField);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SP.edit().putString(StringKeys.SAVE_TEXT, mainField.getText().toString()).apply();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(StringKeys.LAST_OPERATION, lastOperation.ordinal());
        outState.putDouble(StringKeys.RESULT, result);
        outState.putDouble(StringKeys.VAR1, var1);
        outState.putDouble(StringKeys.VAR2, var2);
        outState.putBoolean(StringKeys.IS_LAST_PRESS_EQUAL_MARK, isLastPressButtonEqualMark);
        outState.putString(StringKeys.TEXT_MAIN_FIELD, textMainField);
        outState.putString(StringKeys.MAIN_FIELD, mainField.getText().toString());
        outState.putString(StringKeys.SECONDARY_FIELD, secondaryField.getText().toString());
        outState.putString(StringKeys.TEXT_SECONDARY_FIELD, textSecondaryField);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = LastOperation.
                values()[savedInstanceState.getInt(StringKeys.LAST_OPERATION)];
        result = savedInstanceState.getDouble(StringKeys.RESULT);
        var1 = savedInstanceState.getDouble(StringKeys.VAR1);
        var2 = savedInstanceState.getDouble(StringKeys.VAR2);
        isLastPressButtonEqualMark =
                savedInstanceState.getBoolean(StringKeys.IS_LAST_PRESS_EQUAL_MARK);
        textMainField = savedInstanceState.getString(StringKeys.TEXT_MAIN_FIELD);
        mainField.setText(savedInstanceState.getString(StringKeys.MAIN_FIELD));
        secondaryField.setText(savedInstanceState.getString(StringKeys.SECONDARY_FIELD));
        textSecondaryField = savedInstanceState.getString(StringKeys.TEXT_SECONDARY_FIELD);
    }

    private void changeSizeText() {
        final int NUMBER_OF_LARGE_CHARACTERS = 8;
        final int NUMBER_OF_MEDIUM_CHARACTERS = 11;
        final int SIZE_LARGE_TEXT = 100;
        final int SIZE_MEDIUM_TEXT = 70;
        final int SIZE_SMALL_TEXT = 40;

        if (textMainField.length() < NUMBER_OF_LARGE_CHARACTERS) {
            mainField.setTextSize(SIZE_LARGE_TEXT);
        } else if (textMainField.length() < NUMBER_OF_MEDIUM_CHARACTERS) {
            mainField.setTextSize(SIZE_MEDIUM_TEXT);
        } else {
            mainField.setTextSize(SIZE_SMALL_TEXT);
        }
    }

    private boolean checkForDivideByZeroError() {
        if (var1 == 0 && lastOperation == LastOperation.DIVISION) {
            Toast.makeText(getApplicationContext(),
                    R.string.division_error,
                    Toast.LENGTH_LONG).show();
            mainField.setText(R.string.error);
            textMainField = "";
            textSecondaryField = "";
            secondaryField.setText(textSecondaryField);
            return true;
        }
        return false;
    }

    private String formattingWholeDoubleAsInt(String text) {
        if ((text.indexOf(".") + 2) == text.length() &&
                Character.toString(text.charAt(text.indexOf(".") + 1)).compareTo("0") == 0) {
            return text.substring(0, text.indexOf("."));
        } else return text;
    }
}