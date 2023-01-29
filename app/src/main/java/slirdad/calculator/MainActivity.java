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

    /*  Создаю объект класса Calculation для доступа к переменным экземпляра класса.
            Не уверен, что это должно быть тут. Пока тут.
        Сначала создал в онКрейте. Всё работало, кроме onRestoreInstanceState и onSaveInstanceState.
        Я понимаю, что это связано с ЖЦ. Пока точно объяснить не могу.
        Но когда создаю объект в онКрейт, то при дестрое он уничтожается.
        Думаю, связано с этим.
        Сделал приватным, т.к. кроме активити его никто не должен использовать.
        И студия пишет, что может быть файнл. Не стал делать, т.к не понимаю пока этого.
         */
    private Calculation calculation = new Calculation();

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

        SP = this.getSharedPreferences(StringKeys.SAVE_TEXT, MODE_PRIVATE);

         /*
    Баттоны используютя:
     - в поиске вьюшек
     - в назначении лисенера для соответствующей кнопки
     Поэтому можно сделать их локальными.
     */
        Button buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5, buttonNum6, buttonNum7,
                buttonNum8, buttonNum9, buttonNum0, buttonAllClean, buttonDeleteLastCharacter,
                buttonPositiveToNegative, buttonDivisionSign, buttonMultiplicationSign,
                buttonMinus, buttonPlus, buttonEqualMark, buttonPoint;

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
            if (calculation.var1 == 0 &&
                    calculation.lastOperation == Calculation.LastOperation.DIVISION) {
                Toast.makeText(getApplicationContext(),
                        R.string.division_error,
                        Toast.LENGTH_LONG).show();
                mainField.setText(R.string.error);
                textMainField = "";
                textSecondaryField = "";
                secondaryField.setText(textSecondaryField);
                return;
            }

            if (calculation.isLastPressButtonEqualMark) {//продолжение дествий после равно
                calculation.lastOperation = Calculation.LastOperation.NULL;
                calculation.result = Double.parseDouble(mainField.getText().toString());
                calculation.var1 = 0;
            }

            //двойное подряд нажатие на действие = ничего не происходит
            if (textMainField.equals("") &&
                    calculation.lastOperation == Calculation.LastOperation.ADDITION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "+" + " ";
            secondaryField.setText(textSecondaryField);

            /*если это не первое действие, то запускаем действие по предыдущему флагу,
            а если первое , то просто считываем с экрана число*/
            if (calculation.lastOperation != Calculation.LastOperation.NULL) {
//начало старого оперэйт
                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculation.var1 = Double.parseDouble(textMainField);
                } else if (!calculation.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculation.operate();

                textMainField = String.valueOf(calculation.result);

                /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
                if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                        Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                                compareTo("0") == 0) {
                    textMainField = textMainField.substring(0, textMainField.indexOf("."));
                }

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
//конец старого оперэйт


            } else if (!calculation.isLastPressButtonEqualMark) {
                calculation.result = Double.parseDouble(textMainField);
            }

            calculation.lastOperation = Calculation.LastOperation.ADDITION;
            calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };


        View.OnClickListener onClickListenerButtonMultiplicationSign = view -> {
            if (calculation.isLastPressButtonEqualMark) {
                calculation.lastOperation = Calculation.LastOperation.NULL;
                calculation.result = Double.parseDouble(mainField.getText().toString());
                calculation.var1 = 1;
            }
            if (textMainField.equals("") &&
                    calculation.lastOperation == Calculation.LastOperation.MULTIPLICATION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "*" + " ";
            secondaryField.setText(textSecondaryField);

            if (calculation.lastOperation != Calculation.LastOperation.NULL) {
                                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculation.var1 = Double.parseDouble(textMainField);
                } else if (!calculation.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculation.operate();

                textMainField = String.valueOf(calculation.result);

                /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
                if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                        Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                                compareTo("0") == 0) {
                    textMainField = textMainField.substring(0, textMainField.indexOf("."));
                }

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
            } else if (!calculation.isLastPressButtonEqualMark) {
                calculation.result = Double.parseDouble(textMainField);
            }

            calculation.lastOperation = Calculation.LastOperation.MULTIPLICATION;
            calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonMinus = view -> {
            if (calculation.isLastPressButtonEqualMark) {
                calculation.lastOperation = Calculation.LastOperation.NULL;
                calculation.result = Double.parseDouble(mainField.getText().toString());
                calculation.var1 = 0;
            }
            if (textMainField.equals("") &&
                    calculation.lastOperation == Calculation.LastOperation.SUBTRACTION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "-" + " ";
            secondaryField.setText(textSecondaryField);

            if (calculation.lastOperation != Calculation.LastOperation.NULL) {
                                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculation.var1 = Double.parseDouble(textMainField);
                } else if (!calculation.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculation.operate();

                textMainField = String.valueOf(calculation.result);

                /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
                if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                        Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                                compareTo("0") == 0) {
                    textMainField = textMainField.substring(0, textMainField.indexOf("."));
                }

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
            } else if (!calculation.isLastPressButtonEqualMark) {
                calculation.result = Double.parseDouble(textMainField);
            }

            calculation.lastOperation = Calculation.LastOperation.SUBTRACTION;
            calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonDivisionSign = view -> {
            if (calculation.isLastPressButtonEqualMark) {
                calculation.lastOperation = Calculation.LastOperation.NULL;
                calculation.result = Double.parseDouble(mainField.getText().toString());
                calculation.var1 = 1;
            }
            if (textMainField.equals("") &&
                    calculation.lastOperation == Calculation.LastOperation.DIVISION) {
                return;
            }

            textSecondaryField = textSecondaryField + textMainField + " " + "/" + " ";
            secondaryField.setText(textSecondaryField);

            if (calculation.lastOperation != Calculation.LastOperation.NULL) {
                /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
                if (!textMainField.equals("")) {
                    calculation.var1 = Double.parseDouble(textMainField);
                } else if (!calculation.isLastPressButtonEqualMark) {
                    textSecondaryField = new StringBuffer(textSecondaryField).
                            delete(textSecondaryField.length() - 6,
                                    textSecondaryField.length() - 3).toString();
                    secondaryField.setText(textSecondaryField);
                    //return;
                }

                calculation.operate();
                /*if (calculation.var1 == 0){
                    Toast.makeText(getApplicationContext(),
                            R.string.division_error,
                            Toast.LENGTH_LONG).show();
                    mainField.setText(R.string.error);
                    textMainField = "";
                    return;
                }*/

                textMainField = String.valueOf(calculation.result);

                /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
                if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                        Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                                compareTo("0") == 0) {
                    textMainField = textMainField.substring(0, textMainField.indexOf("."));
                }

                changeSizeText();
                mainField.setText(textMainField);
                textMainField = "";
            } else if (!calculation.isLastPressButtonEqualMark) {
                calculation.result = Double.parseDouble(textMainField);
            }

            calculation.lastOperation = Calculation.LastOperation.DIVISION;
            calculation.isLastPressButtonEqualMark = false;
            textMainField = "";
        };

        View.OnClickListener onClickListenerButtonEqualMark = view -> {
            if (calculation.lastOperation == Calculation.LastOperation.NULL) {
                return;
            }

            String var = "";
            if (calculation.isLastPressButtonEqualMark) {
                switch (calculation.lastOperation) {
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
            calculation.var1 = calculation.var2;
                            /*если после одного дейсвия нажали сразу другое,
                  то ничего не произойдет (только если это не кнопка равно).
                  Просто сменится флаг.
                */
            if (!textMainField.equals("")) {
                calculation.var1 = Double.parseDouble(textMainField);
            } else if (!calculation.isLastPressButtonEqualMark) {
                textSecondaryField = new StringBuffer(textSecondaryField).
                        delete(textSecondaryField.length() - 6,
                                textSecondaryField.length() - 3).toString();
                secondaryField.setText(textSecondaryField);
                //return;
            }

            calculation.operate();

            textMainField = String.valueOf(calculation.result);

            /*если в строке после запятой только один символ и он равен 0, то удаляем и точку и ноль*/
            if ((textMainField.indexOf(".") + 2) == textMainField.length() &&
                    Character.toString(textMainField.charAt(textMainField.indexOf(".") + 1)).
                            compareTo("0") == 0) {
                textMainField = textMainField.substring(0, textMainField.indexOf("."));
            }

            changeSizeText();
            mainField.setText(textMainField);
            textMainField = "";
            calculation.isLastPressButtonEqualMark = true;

            /*если в строке после запятой только один символ и он равен 0,
            то удаляем и точку и ноль*/
            /*
            Я бы, наверное, эту операцию поместил бы в отдельный метод.
            Хотя эта операция используется всего (пока) в двух местах и с разными входными данными
            (в одном месте со стрингами, а в другом в дабл.
            Так что его придётся, наверное, перегружать. Надо ли?
             */
            if ((String.valueOf(calculation.var1).indexOf(".") + 2) == String.valueOf(calculation.var1).length() &&
                    Character.toString(String.valueOf(calculation.var1).charAt(String.valueOf(calculation.var1).
                            indexOf(".") + 1)).compareTo("0") == 0) {
                var = String.valueOf(calculation.var1).substring(0, String.valueOf(calculation.var1).indexOf("."));
            } else var = String.valueOf(calculation.var1);

            textSecondaryField = textSecondaryField + var + " " + "=";
            secondaryField.setText(textSecondaryField);
            textSecondaryField = mainField.getText().toString();
        };

        View.OnClickListener onClickListenerButtonAllClean = view -> {
            textMainField = "0";
            calculation.var1 = 0;
            calculation.result = 0;
            calculation.lastOperation = Calculation.LastOperation.NULL;
            calculation.isLastPressButtonEqualMark = false;
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
        outState.putInt(StringKeys.LAST_OPERATION, calculation.lastOperation.ordinal());
        outState.putDouble(StringKeys.RESULT, calculation.result);
        outState.putDouble(StringKeys.VAR1, calculation.var1);
        outState.putDouble(StringKeys.VAR2, calculation.var2);
        outState.putBoolean(StringKeys.IS_LAST_PRESS_EQUAL_MARK,
                calculation.isLastPressButtonEqualMark);
        outState.putString(StringKeys.TEXT_MAIN_FIELD, textMainField);
        outState.putString(StringKeys.MAIN_FIELD, mainField.getText().toString());
        outState.putString(StringKeys.SECONDARY_FIELD, secondaryField.getText().toString());
        outState.putString(StringKeys.TEXT_SECONDARY_FIELD, textSecondaryField);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculation.lastOperation = Calculation.LastOperation.
                values()[savedInstanceState.getInt(StringKeys.LAST_OPERATION)];
        calculation.result = savedInstanceState.getDouble(StringKeys.RESULT);
        calculation.var1 = savedInstanceState.getDouble(StringKeys.VAR1);
        calculation.var2 = savedInstanceState.getDouble(StringKeys.VAR2);
        calculation.isLastPressButtonEqualMark =
                savedInstanceState.getBoolean(StringKeys.IS_LAST_PRESS_EQUAL_MARK);
        textMainField = savedInstanceState.getString(StringKeys.TEXT_MAIN_FIELD);
        mainField.setText(savedInstanceState.getString(StringKeys.MAIN_FIELD));
        secondaryField.setText(savedInstanceState.getString(StringKeys.SECONDARY_FIELD));
        textSecondaryField = savedInstanceState.getString(StringKeys.TEXT_SECONDARY_FIELD);
    }


    /*
    Используется только в мэйне, поэтому приват.
     */
    private void changeSizeText() {
        //локальные переменные нет смысла делать константами
        int number_of_large_characters = 8;
        int number_of_medium_characters = 11;
        int size_large_text = 100;
        int size_medium_text = 70;
        int size_small_text = 40;

        if (textMainField.length() < number_of_large_characters) {
            mainField.setTextSize(size_large_text);
        } else if (textMainField.length() < number_of_medium_characters) {
            mainField.setTextSize(size_medium_text);
        } else {
            mainField.setTextSize(size_small_text);
        }
    }
}