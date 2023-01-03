package slirdad.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int DIVISION = 3;
    static final int MULTIPLICATION = 4;
    static final int NULL = 0;

    //final String TAG = "Dima logs";

    SharedPreferences SP;
    final String SAVE_TEXT = "save text";

    boolean isLastPressButtonEqualMark;

    int lastOperation = NULL;

    Button buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5, buttonNum6, buttonNum7, buttonNum8, buttonNum9, buttonNum0,
           buttonAllClean, buttonDeleteLastCharacter, buttonPositiveToNegative, buttonDivisionSign, buttonMultiplicationSign,
           buttonMinus, buttonPlus, buttonEqualMark, buttonPoint;

    TextView mainField, secondaryField;

    double result = 0;
    double var1 = 0;
    double var2 = 0;

    String textMainField = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        mainField =(TextView) findViewById(R.id.textView1);
        secondaryField =(TextView) findViewById(R.id.textView2);

        mainField.setText(textMainField);

        View.OnClickListener onCLNumber = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textMainField.equals("0")){  // что бы при вводе затирался начальный ноль
                    textMainField = "";
                }
                switch (view.getId()) {
                    case R.id.button1: textMainField = textMainField + "1";
                        break;
                    case R.id.button2: textMainField = textMainField + "2";
                        break;
                    case R.id.button3: textMainField = textMainField + "3";
                        break;
                    case R.id.button4: textMainField = textMainField + "4";
                        break;
                    case R.id.button5: textMainField = textMainField + "5";
                        break;
                    case R.id.button6: textMainField = textMainField + "6";
                        break;
                    case R.id.button7: textMainField = textMainField + "7";
                        break;
                    case R.id.button8: textMainField = textMainField + "8";
                        break;
                    case R.id.button9: textMainField = textMainField + "9";
                        break;
                    case R.id.button0: textMainField = textMainField + "0";
                        break;
                    case R.id.buttonPoint:
                        if (!textMainField.contains(".")) {    //если в строке нет точки
                            textMainField = (textMainField.equals(""))? ("0.") : (textMainField + ".");
                        }
                        else return;
                        break;
                    default:break;
                }

                changeSizeText();
                mainField.setText(textMainField);
                //twSmall.setText("var1= " + var1+ "  " +"res =" + res+"   " + "textBig=" + textBig+"   " + "action=" + action+"   " + "wasRes=" + wasRes);
            }
        };

        buttonNum0.setOnClickListener(onCLNumber);
        buttonNum1.setOnClickListener(onCLNumber);
        buttonNum2.setOnClickListener(onCLNumber);
        buttonNum3.setOnClickListener(onCLNumber);
        buttonNum4.setOnClickListener(onCLNumber);
        buttonNum5.setOnClickListener(onCLNumber);
        buttonNum6.setOnClickListener(onCLNumber);
        buttonNum7.setOnClickListener(onCLNumber);
        buttonNum8.setOnClickListener(onCLNumber);
        buttonNum9.setOnClickListener(onCLNumber);
        buttonPoint.setOnClickListener(onCLNumber);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLastPressButtonEqualMark){        //продолжение дествий после нажатия на равно
                    lastOperation = NULL;
                    result = Double.parseDouble(mainField.getText().toString());
                    var1 = 0;
                }

                if (textMainField.equals("") && lastOperation == ADDITION){           //двойное подряд нажатие на действие = ничего не происходит
                    return;
                }
                if (lastOperation != NULL){                              //если это не первое действие
                    operation(view);                                //запускаем действие по предыдущему флагу
                }
                else if (!isLastPressButtonEqualMark){
                    result = Double.parseDouble(textMainField);       //если первое действие, то просто считываем с экрана число
                }

                lastOperation = ADDITION;
                isLastPressButtonEqualMark = false;
                textMainField = "";

                //twSmall.setText("var1= " + var1+ "  " +"res =" + res+"   " + "textBig=" + textBig+"   " + "action=" + action+"   " + "wasRes=" + wasRes);

            }
        });
        buttonMultiplicationSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLastPressButtonEqualMark){        //продолжение дествий после нажатия на равно
                    lastOperation = NULL;
                    result = Double.parseDouble(mainField.getText().toString());
                    var1 = 1;
                }
                if (textMainField.equals("") && lastOperation == MULTIPLICATION){
                    return;
                }
                if (lastOperation != NULL){
                    operation(view);
                }
                else if (!isLastPressButtonEqualMark){
                    result = Double.parseDouble(textMainField);       //если первое действие, то просто считываем с экрана число
                }

                lastOperation = MULTIPLICATION;
                isLastPressButtonEqualMark = false;
                textMainField = "";
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLastPressButtonEqualMark){        //продолжение дествий после нажатия на равно
                    lastOperation = NULL;
                    result = Double.parseDouble(mainField.getText().toString());
                    var1 = 0;
                }
                if (textMainField.equals("") && lastOperation == SUBTRACTION){
                    return;
                }
                if (lastOperation != NULL){
                    operation(view);
                }
                else if (!isLastPressButtonEqualMark){
                    result = Double.parseDouble(textMainField);       //если первое действие, то просто считываем с экрана число
                }

                lastOperation = SUBTRACTION;
                isLastPressButtonEqualMark = false;
                textMainField = "";
            }
        });
        buttonDivisionSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLastPressButtonEqualMark){        //продолжение дествий после нажатия на равно
                    lastOperation = NULL;
                    result = Double.parseDouble(mainField.getText().toString());
                    var1 = 1;
                }
                if (textMainField.equals("") && lastOperation == DIVISION){
                    return;
                }
                if (lastOperation != NULL){
                    operation(view);
                }
                else if (!isLastPressButtonEqualMark){
                    result = Double.parseDouble(textMainField);       //если первое действие, то просто считываем с экрана число
                }

                lastOperation = DIVISION;
                isLastPressButtonEqualMark = false;
                textMainField = "";
            }
        });

        buttonEqualMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = var2;  //если подряд нажимать = , то var1 не затирается в следующем Action, а так же при повороте экрана
                operation(view);
                isLastPressButtonEqualMark = true;
                //twSmall.setText("var1= " + var1+ "  " +"res =" + res+"   " + "textBig=" + textBig+"   " + "action=" + action+"   " + "wasRes=" + wasRes);
            }
        });
        buttonAllClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textMainField = "0";
                var1 = 0;
                result = 0;
                lastOperation = 0;
                isLastPressButtonEqualMark = false;
                changeSizeText();
                mainField.setText(textMainField);
                //twSmall.setText("var1= " + var1+ "  " +"res =" + res+"   " + "textBig=" + textBig+"   " + "action=" + action+"   " + "wasRes=" + wasRes);

            }
        });
        buttonDeleteLastCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textMainField.length()>1) {
                    textMainField = textMainField.substring(0, textMainField.length() - 1);
                }
                else textMainField = "0";
                mainField.setText(textMainField);
                changeSizeText();
            }
        });
        buttonPositiveToNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textMainField = mainField.getText().toString();  //что бы можно было менять знак в процессе вычислений, а не только в начале

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
                    //return;
                }
            }
        });
    }

    void operation(View view) {
        if (!textMainField.equals("")){
            var1 = Double.parseDouble(textMainField);
        }
        else if (!isLastPressButtonEqualMark) return;            //если после одного дейсвия нажали сразу другое, то ничего не произойдет (только если это не кнопка равно). Просто сменится флаг.

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
                try {
                    result = result / var1;
                }
                catch (ArithmeticException e){
                    Toast.makeText(getApplicationContext(), "ОШИБКА ДЕЛЕНИЯ НА НОЛЬ", Toast.LENGTH_LONG).show();
                    mainField.setText("Ошибка");
                    //buttonAllClean.callOnClick();
                    return;
                }

                break;
        }
        var2 = var1;

        textMainField = String.valueOf(result);
        if ((textMainField.indexOf(".")+2)== textMainField.length()  &&
                Character.toString(textMainField.charAt(textMainField.indexOf(".")+1)).compareTo("0") == 0){       //если в строке после запятой только один символ и он равен 0
            textMainField = textMainField.substring(0, textMainField.indexOf("."));                                      //то удаляем и точку и ноль
        }

        changeSizeText();
        mainField.setText(textMainField);
        textMainField = "";

    }

    void changeSizeText(){
        if (textMainField.length()<8){
            mainField.setTextSize(100);
        }
        else if (textMainField.length()<11){
            mainField.setTextSize(70);
        }
        else {
            mainField.setTextSize(40);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lastOperation", lastOperation);
        outState.putDouble("result", result);
        outState.putDouble("var1",var1);
        outState.putDouble("var2", var2);
        outState.putBoolean("isLastPressButtonEqualMark", isLastPressButtonEqualMark);
        outState.putString("textMainField", textMainField);
        outState.putString("mainField", mainField.getText().toString());

        //Log.d(TAG, "сохранение параметров");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getInt("lastOperation");
        result = savedInstanceState.getDouble("result");
        var1 = savedInstanceState.getDouble("var1");
        var2 = savedInstanceState.getDouble("var2");
        isLastPressButtonEqualMark = savedInstanceState.getBoolean("isLastPressButtonEqualMark");
        textMainField = savedInstanceState.getString("textMainField");
        mainField.setText(savedInstanceState.getString("mainField"));

        //Log.d(TAG, "загрузка параметров");
    }

    @Override
    protected void onStart() {
        super.onStart();
        textMainField = SP.getString("save text", "");
        changeSizeText();
        mainField.setText(textMainField);

        //Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SP.edit().putString("save text", mainField.getText().toString()).apply();//commit();  //я так понял, что если мне не нужно проверить успешно или нет сохранилось, то использую apply()
    }

}