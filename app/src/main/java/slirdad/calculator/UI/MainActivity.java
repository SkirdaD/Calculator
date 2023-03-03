package slirdad.calculator.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.HashMap;

import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {
    private final HashMap<Integer, String> buttonValuesMap = new HashMap<Integer, String>() {{
        put(R.id.button0, "0");
        put(R.id.button1, "1");
        put(R.id.button2, "2");
        put(R.id.button3, "3");
        put(R.id.button4, "4");
        put(R.id.button5, "5");
        put(R.id.button6, "6");
        put(R.id.button7, "7");
        put(R.id.button8, "8");
        put(R.id.button9, "9");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final MainActivityViewHolder viewHolder = new MainActivityViewHolder(this);
        final MainActivityLogicHolder logicHolder = new MainActivityLogicHolder(viewHolder, buttonValuesMap);

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(logicHolder::putNum);
        }
        viewHolder.getPlusButton().setOnClickListener(logicHolder::summarize);
        viewHolder.getMinusButton().setOnClickListener(logicHolder::subtract);
        viewHolder.getMultiplicationSignButton().setOnClickListener(logicHolder::multiply);
        viewHolder.getDivisionSignButton().setOnClickListener(logicHolder::divide);
        viewHolder.getEqualMarkButton().setOnClickListener(logicHolder::equal);

        viewHolder.getAllCleanButton().setOnClickListener(logicHolder::cleanAll);
        viewHolder.getPointButton().setOnClickListener(logicHolder::putDecimalPoint);
        viewHolder.getSignChangeButton().setOnClickListener(logicHolder::changeSign);
        viewHolder.getDeleteLastCharacterButton().setOnClickListener(logicHolder::deleteLastChar);
    }
}
