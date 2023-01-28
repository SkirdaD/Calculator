package slirdad.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    /*
    этот блок переменных определяет значение переменной lastOperation ,
    то есть какое действие было выбрано. И она тут же и инициализируется.
    Они используются:
        - в лисенерах кнопок арифметических операций;
        - в лисенере кнопки равно для отображения нужного символа в secondaryField;
        - в методе ::operate;
        - в лисенере АС

    int lastOperation = NULL;
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int DIVISION = 3;
    static final int MULTIPLICATION = 4;
    static final int NULL = 0;



    этот блок переменных необходим только для подгонки размера шрифта для "красивого" отображения.
    Используется в ::changeSizeText.

    final int NUMBER_OF_LARGE_CHARACTERS = 8;
    final int NUMBER_OF_MEDIUM_CHARACTERS = 11;
    final int SIZE_LARGE_TEXT = 100;
    final int SIZE_MEDIUM_TEXT = 70;
    final int SIZE_SMALL_TEXT = 40;


    инициализация SP, которая используется в ::onStart и в ::onStop, для сохранения и извлечения
    при закрытии приложения.
    и тут же переменная для ключа
    */
    SharedPreferences SP;
    final String SAVE_TEXT = "saveText";


    /*
    Переменные (ключи) для методов onRestoreInstanceState и onSaveInstanceState.
    Используются только в них.
    Для поворота экрана.
     */
    final private String LAST_OPERATION = "lastOperation";
    final private String RESULT = "result";
    final private String VAR1 = "var1";
    final private String VAR2 = "var2";
    final private String IS_LAST_PRESS_EQUAL_MARK = "isLastPressButtonEqualMark";
    final private String TEXT_MAIN_FIELD = "textMainField";
    final private String MAIN_FIELD = "mainField";
    final private String SECONDARY_FIELD = "secondaryField";
    final private String TEXT_SECONDARY_FIELD = "textSecondaryField";

    /*
    Инициализация переменной, которая показывает было ли нажато последним "=".
    Используется:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС

     */


    Button buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5, buttonNum6, buttonNum7,
            buttonNum8, buttonNum9, buttonNum0, buttonAllClean, buttonDeleteLastCharacter,
            buttonPositiveToNegative, buttonDivisionSign, buttonMultiplicationSign,
            buttonMinus, buttonPlus, buttonEqualMark, buttonPoint;

    protected static TextView mainField, secondaryField;

    /*
    Переменные инициализируюся дефолтными значениями.
    Используются:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС

    double result = 0;
    double var1 = 0;
    double var2 = 0;


    /*
    Переменные инициализируюся дефолтными значениями.
    Используются:
      - во всех лисенерах кнопок;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
     */
    protected static String textMainField, textSecondaryField = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        SP = this.getSharedPreferences(SAVE_TEXT, MODE_PRIVATE);

        buttonNum1 = (Button) findViewById(R.id.button1);
        buttonNum2 = (Button) findViewById(R.id.button2);
        buttonNum3 = (Button) findViewById(R.id.button3);
        buttonNum4 = (Button) findViewById(R.id.button4);
        buttonNum5 = (Button) findViewById(R.id.button5);
        buttonNum6 = (Button) findViewById(R.id.button6);
        buttonNum7 = (Button) findViewById(R.id.button7);
        buttonNum8 = (Button) findViewById(R.id.button8);
        buttonNum9 = (Button) findViewById(R.id.button9);
        buttonNum0 = (Button) findViewById(R.id.button0);
        buttonAllClean = (Button) findViewById(R.id.buttonAC);
        buttonDeleteLastCharacter = (Button) findViewById(R.id.buttonDelete);
        buttonPositiveToNegative = (Button) findViewById(R.id.buttonPlusMinus);
        buttonDivisionSign = (Button) findViewById(R.id.buttonDivision);
        buttonMultiplicationSign = (Button) findViewById(R.id.buttonMultiplication);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonEqualMark = (Button) findViewById(R.id.buttonResult);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);

        ArrayList<Button> numButtons = new ArrayList<>(11);
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
            if (Calculation.isLastPressButtonEqualMark) {//продолжение дествий после равно
                Calculation.lastOperation = Calculation.LastOperation.NULL;
                Calculation.result = Double.parseDouble(mainField.getText().toString());
                Calculation.var1 = 0;
            }

            //двойное подряд нажатие на действие = ничего не происходит
            if (textMainField.equals("") &&
                    Calculation.lastOperation == Calculation.LastOperation.ADDITION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "+" + " ";
            secondaryField.setText(textSecondaryField);

            /*если это не первое действие, то запускаем действие по предыдущему флагу,
            а если первое , то просто считываем с экрана число*/
            if (Calculation.lastOperation != Calculation.LastOperation.NULL) {
                Calculation.operate();
            } else if (!Calculation.isLastPressButtonEqualMark) {
                Calculation.result = Double.parseDouble(textMainField);
            }

            Calculation.lastOperation = Calculation.LastOperation.ADDITION;
            Calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonMultiplicationSign = view -> {
            if (Calculation.isLastPressButtonEqualMark) {
                Calculation.lastOperation = Calculation.LastOperation.NULL;
                Calculation.result = Double.parseDouble(mainField.getText().toString());
                Calculation.var1 = 1;
            }
            if (textMainField.equals("") &&
                    Calculation.lastOperation == Calculation.LastOperation.MULTIPLICATION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "*" + " ";
            secondaryField.setText(textSecondaryField);

            if (Calculation.lastOperation != Calculation.LastOperation.NULL) {
                Calculation.operate();
            } else if (!Calculation.isLastPressButtonEqualMark) {
                Calculation.result = Double.parseDouble(textMainField);
            }

            Calculation.lastOperation = Calculation.LastOperation.MULTIPLICATION;
            Calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonMinus = view -> {
            if (Calculation.isLastPressButtonEqualMark) {
                Calculation.lastOperation = Calculation.LastOperation.NULL;
                Calculation.result = Double.parseDouble(mainField.getText().toString());
                Calculation.var1 = 0;
            }
            if (textMainField.equals("") &&
                    Calculation.lastOperation == Calculation.LastOperation.SUBTRACTION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "-" + " ";
            secondaryField.setText(textSecondaryField);

            if (Calculation.lastOperation != Calculation.LastOperation.NULL) {
                Calculation.operate();
            } else if (!Calculation.isLastPressButtonEqualMark) {
                Calculation.result = Double.parseDouble(textMainField);
            }

            Calculation.lastOperation = Calculation.LastOperation.SUBTRACTION;
            Calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonDivisionSign = view -> {
            if (Calculation.isLastPressButtonEqualMark) {
                Calculation.lastOperation = Calculation.LastOperation.NULL;
                Calculation.result = Double.parseDouble(mainField.getText().toString());
                Calculation.var1 = 1;
            }
            if (textMainField.equals("") &&
                    Calculation.lastOperation == Calculation.LastOperation.DIVISION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "/" + " ";
            secondaryField.setText(textSecondaryField);

            if (Calculation.lastOperation != Calculation.LastOperation.NULL) {
                Calculation.operate();
            } else if (!Calculation.isLastPressButtonEqualMark) {
                Calculation.result = Double.parseDouble(textMainField);
            }

            Calculation.lastOperation = Calculation.LastOperation.DIVISION;
            Calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonEqualMark = view -> {
            if (Calculation.lastOperation == Calculation.LastOperation.NULL) {
                return;
            }

            String var = "";
            if (Calculation.isLastPressButtonEqualMark) {
                switch (Calculation.lastOperation) {
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
            Calculation.var1 = Calculation.var2;
            Calculation.operate();
            Calculation.isLastPressButtonEqualMark = true;

            /*если в строке после запятой только один символ и он равен 0,
            то удаляем и точку и ноль*/
            /*
            Я бы, наверное, эту операцию поместил бы в отдельный метод.
            Хотя эта операция используется всего (пока) в двух местах и с разными входными данными
            (в одном месте со стрингами, а в другом в дабл.
            Так что его придётся, наверное, перегружать. Надо ли?
             */
            if ((String.valueOf(Calculation.var1).indexOf(".") + 2) == String.valueOf(Calculation.var1).length() &&
                    Character.toString(String.valueOf(Calculation.var1).charAt(String.valueOf(Calculation.var1).
                            indexOf(".") + 1)).compareTo("0") == 0) {
                var = String.valueOf(Calculation.var1).substring(0, String.valueOf(Calculation.var1).indexOf("."));
            } else var = String.valueOf(Calculation.var1);

            textSecondaryField = textSecondaryField + var + " " + "=";
            secondaryField.setText(textSecondaryField);
            textSecondaryField = mainField.getText().toString();
        };

        View.OnClickListener onClickListenerButtonAllClean = view -> {
            textMainField = "0";
            Calculation.var1 = 0;
            Calculation.result = 0;
            Calculation.lastOperation = Calculation.LastOperation.NULL;
            Calculation.isLastPressButtonEqualMark = false;
            changeSizeText();
            mainField.setText(textMainField);
            textSecondaryField = "";
            secondaryField.setText(textSecondaryField);
        };

        View.OnClickListener onClickListenerButtonDeleteLastCharacter = view -> {
            if (textMainField.length() > 1) {
                textMainField = textMainField.substring(0, textMainField.length() - 1);
            } else textMainField = "0";

            mainField.setText(textMainField);
            changeSizeText();
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
        textMainField = SP.getString(SAVE_TEXT, "0");
        changeSizeText();
        mainField.setText(textMainField);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SP.edit().putString(SAVE_TEXT, mainField.getText().toString()).apply();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(LAST_OPERATION, Calculation.lastOperation.ordinal());
        outState.putDouble(RESULT, Calculation.result);
        outState.putDouble(VAR1, Calculation.var1);
        outState.putDouble(VAR2, Calculation.var2);
        outState.putBoolean(IS_LAST_PRESS_EQUAL_MARK, Calculation.isLastPressButtonEqualMark);
        outState.putString(TEXT_MAIN_FIELD, textMainField);
        outState.putString(MAIN_FIELD, mainField.getText().toString());
        outState.putString(SECONDARY_FIELD, secondaryField.getText().toString());
        outState.putString(TEXT_SECONDARY_FIELD, textSecondaryField);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Calculation.lastOperation =
                Calculation.LastOperation.values()[savedInstanceState.getInt(LAST_OPERATION)];
        Calculation.result = savedInstanceState.getDouble(RESULT);
        Calculation.var1 = savedInstanceState.getDouble(VAR1);
        Calculation.var2 = savedInstanceState.getDouble(VAR2);
        Calculation.isLastPressButtonEqualMark =
                savedInstanceState.getBoolean(IS_LAST_PRESS_EQUAL_MARK);
        textMainField = savedInstanceState.getString(TEXT_MAIN_FIELD);
        mainField.setText(savedInstanceState.getString(MAIN_FIELD));
        secondaryField.setText(savedInstanceState.getString(SECONDARY_FIELD));
        textSecondaryField = savedInstanceState.getString(TEXT_SECONDARY_FIELD);
    }

    protected static void changeSizeText() {
        int NUMBER_OF_LARGE_CHARACTERS = 8;
        int NUMBER_OF_MEDIUM_CHARACTERS = 11;
        int SIZE_LARGE_TEXT = 100;
        int SIZE_MEDIUM_TEXT = 70;
        int SIZE_SMALL_TEXT = 40;

        if (textMainField.length() < NUMBER_OF_LARGE_CHARACTERS) {
            mainField.setTextSize(SIZE_LARGE_TEXT);
        } else if (textMainField.length() < NUMBER_OF_MEDIUM_CHARACTERS) {
            mainField.setTextSize(SIZE_MEDIUM_TEXT);
        } else {
            mainField.setTextSize(SIZE_SMALL_TEXT);
        }
    }
}