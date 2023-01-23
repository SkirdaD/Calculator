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

    /*
    этот блок переменных определяет значение переменной lastOperation ,
    то есть какое действие было выбрано. И она тут же и инициализируется.
    Они используются:
        - в лисенерах кнопок арифметических операций;
        - в лисенере кнопки равно для отображения нужного символа в secondaryField;
        - в методе ::operate;
        - в лисенере АС

    */
    int lastOperation = NULL;
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int DIVISION = 3;
    static final int MULTIPLICATION = 4;
    static final int NULL = 0;


    /*
    этот блок переменных необходим только для подгонки размера шрифта для "красивого" отображения.
    Используется в ::changeSizeText.
    */
    final int NUMBER_OF_LARGE_CHARACTERS = 8;
    final int NUMBER_OF_MEDIUM_CHARACTERS = 11;
    final int SIZE_LARGE_TEXT = 100;
    final int SIZE_MEDIUM_TEXT = 70;
    final int SIZE_SMALL_TEXT = 40;

    /*
    инициализация SP, которая используется в ::onStart и в ::onStop, для сохранения и извлечения
    при закрытии приложения.
    и тут же переменная для ключа
    */
    SharedPreferences SP;
    final String SAVE_TEXT = "save text";
    //final String IS_FIRST_RUN = "isFirstRun";


    /*
    Переменные (ключи) для методов onRestoreInstanceState и onSaveInstanceState.
    Используются только в них.
    Для поворота экрана.
     */
    final String LAST_OPERATION = "lastOperation";
    final String RESULT = "result";
    final String VAR1 = "var1";
    final String VAR2 = "var2";
    final String IS_LAST_PRESS_EQUAL_MARK = "isLastPressButtonEqualMark";
    final String TEXT_MAIN_FIELD = "textMainField";
    final String MAIN_FIELD = "mainField";
    final String SECONDARY_FIELD = "secondaryField";
    final String TEXT_SECONDARY_FIELD = "textSecondaryField";

    /*
    Инициализация переменной, которая показывает было ли нажато последним "=".
    Используется:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС

     */
    boolean isLastPressButtonEqualMark;


    Button buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5, buttonNum6, buttonNum7,
            buttonNum8, buttonNum9, buttonNum0, buttonAllClean, buttonDeleteLastCharacter,
            buttonPositiveToNegative, buttonDivisionSign, buttonMultiplicationSign,
            buttonMinus, buttonPlus, buttonEqualMark, buttonPoint;

    TextView mainField, secondaryField;

    /*
    Переменные инициализируюся дефолтными значениями.
    Используются:
      - во всех лисенерах кнопок операций;
      - в методах onRestoreInstanceState и onSaveInstanceState;
      - в методе ::operate;
      - в лисенере АС
     */
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
    String textMainField, textSecondaryField = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        SP = this.getSharedPreferences(SAVE_TEXT, MODE_PRIVATE);
        //SP = this.getSharedPreferences(IS_FIRST_RUN, MODE_PRIVATE);

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
            if (isLastPressButtonEqualMark) {        //продолжение дествий после нажатия на равно
                lastOperation = NULL;
                result = Double.parseDouble(mainField.getText().toString());
                var1 = 0;
            }

            //двойное подряд нажатие на действие = ничего не происходит
            if (textMainField.equals("") && lastOperation == ADDITION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "+" + " ";
            secondaryField.setText(textSecondaryField);

            /*если это не первое действие, то запускаем действие по предыдущему флагу,
            а если первое , то просто считываем с экрана число*/
            if (lastOperation != NULL) {
                operate();
            } else if (!isLastPressButtonEqualMark) {
                result = Double.parseDouble(textMainField);
            }

            lastOperation = ADDITION;
            isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonMultiplicationSign = view -> {
            if (isLastPressButtonEqualMark) {
                lastOperation = NULL;
                result = Double.parseDouble(mainField.getText().toString());
                var1 = 1;
            }
            if (textMainField.equals("") && lastOperation == MULTIPLICATION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "*" + " ";
            secondaryField.setText(textSecondaryField);

            if (lastOperation != NULL) {
                operate();
            } else if (!isLastPressButtonEqualMark) {
                result = Double.parseDouble(textMainField);
            }

            lastOperation = MULTIPLICATION;
            isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonMinus = view -> {
            if (isLastPressButtonEqualMark) {
                lastOperation = NULL;
                result = Double.parseDouble(mainField.getText().toString());
                var1 = 0;
            }
            if (textMainField.equals("") && lastOperation == SUBTRACTION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "-" + " ";
            secondaryField.setText(textSecondaryField);

            if (lastOperation != NULL) {
                operate();
            } else if (!isLastPressButtonEqualMark) {
                result = Double.parseDouble(textMainField);
            }

            lastOperation = SUBTRACTION;
            isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonDivisionSign = view -> {
            if (isLastPressButtonEqualMark) {
                lastOperation = NULL;
                result = Double.parseDouble(mainField.getText().toString());
                var1 = 1;
            }
            if (textMainField.equals("") && lastOperation == DIVISION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "/" + " ";
            secondaryField.setText(textSecondaryField);

            if (lastOperation != NULL) {
                operate();
            } else if (!isLastPressButtonEqualMark) {
                result = Double.parseDouble(textMainField);
            }

            lastOperation = DIVISION;
            isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonEqualMark = view -> {
            if (lastOperation == NULL) {
                return;
            }

            String var = "";
            if (isLastPressButtonEqualMark) {
                switch (lastOperation) {
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
            var1 = var2;
            operate();
            isLastPressButtonEqualMark = true;

            /*если в строке после запятой только один символ и он равен 0,
            то удаляем и точку и ноль*/
            /*
            Я бы, наверное, эту операцию поместил бы в отдельный метод.
            Хотя эта операция используется всего (пока) в двух местах и с разными входными данными
            (в одном месте со стрингами, а в другом в дабл.
            Так что его придётся, наверное, перегружать. Надо ли?
             */
            if ((String.valueOf(var1).indexOf(".") + 2) == String.valueOf(var1).length() &&
                    Character.toString(String.valueOf(var1).charAt(String.valueOf(var1).
                            indexOf(".") + 1)).compareTo("0") == 0) {
                var = String.valueOf(var1).substring(0, String.valueOf(var1).indexOf("."));
            } else var = String.valueOf(var1);

            textSecondaryField = textSecondaryField + var + " " + "=";
            secondaryField.setText(textSecondaryField);
            textSecondaryField = mainField.getText().toString();
        };

        View.OnClickListener onClickListenerButtonAllClean = view -> {
            textMainField = "0";
            var1 = 0;
            result = 0;
            lastOperation = 0;
            isLastPressButtonEqualMark = false;
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
        outState.putInt(LAST_OPERATION, lastOperation);
        outState.putDouble(RESULT, result);
        outState.putDouble(VAR1, var1);
        outState.putDouble(VAR2, var2);
        outState.putBoolean(IS_LAST_PRESS_EQUAL_MARK, isLastPressButtonEqualMark);
        outState.putString(TEXT_MAIN_FIELD, textMainField);
        outState.putString(MAIN_FIELD, mainField.getText().toString());
        outState.putString(SECONDARY_FIELD, secondaryField.getText().toString());
        outState.putString(TEXT_SECONDARY_FIELD, textSecondaryField);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getInt(LAST_OPERATION);
        result = savedInstanceState.getDouble(RESULT);
        var1 = savedInstanceState.getDouble(VAR1);
        var2 = savedInstanceState.getDouble(VAR2);
        isLastPressButtonEqualMark = savedInstanceState.getBoolean(IS_LAST_PRESS_EQUAL_MARK);
        textMainField = savedInstanceState.getString(TEXT_MAIN_FIELD);
        mainField.setText(savedInstanceState.getString(MAIN_FIELD));
        secondaryField.setText(savedInstanceState.getString(SECONDARY_FIELD));
        textSecondaryField = savedInstanceState.getString(TEXT_SECONDARY_FIELD);
    }

    protected void changeSizeText() {
        if (textMainField.length() < NUMBER_OF_LARGE_CHARACTERS) {
            mainField.setTextSize(SIZE_LARGE_TEXT);
        } else if (textMainField.length() < NUMBER_OF_MEDIUM_CHARACTERS) {
            mainField.setTextSize(SIZE_MEDIUM_TEXT);
        } else {
            mainField.setTextSize(SIZE_SMALL_TEXT);
        }
    }

    protected void operate() {
        /*если после одного дейсвия нажали сразу другое,
        то ничего не произойдет (только если это не кнопка равно).
        Просто сменится флаг.*/
        if (!textMainField.equals("")) {
            var1 = Double.parseDouble(textMainField);
        } else if (!isLastPressButtonEqualMark) {
            textSecondaryField = new StringBuffer(textSecondaryField).
                    delete(textSecondaryField.length() - 6,
                            textSecondaryField.length() - 3).toString();
            secondaryField.setText(textSecondaryField);
            return;
        }

        switch (lastOperation) {
            case ADDITION:
                result = result + var1;
                break;
            case MULTIPLICATION:
                result = result * var1;
                break;
            case SUBTRACTION:
                result = result - var1;
                break;
            case DIVISION:
                if (var1 != 0) {
                    result = result / var1;
                } else {
                    Toast.makeText(getApplicationContext(),
                            R.string.division_error,
                            Toast.LENGTH_LONG).show();
                    mainField.setText(R.string.error);
                    textMainField = "";
                    result = 0;
                    var1 = 0;
                    isLastPressButtonEqualMark = false;
                    //buttonAllClean.callOnClick();
                    return;
                }
                break;
        }
        var2 = var1;
        textMainField = String.valueOf(result);

        /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
        if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                        compareTo("0") == 0) {
            textMainField = textMainField.substring(0, textMainField.indexOf("."));
        }

        changeSizeText();
        mainField.setText(textMainField);
        textMainField = "";
    }
}