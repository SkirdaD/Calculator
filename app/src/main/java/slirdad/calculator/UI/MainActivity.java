package slirdad.calculator.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final MainActivityViewHolder viewHolder = new MainActivityViewHolder(this);
        final MainActivityLogicHolder logicHolder = new MainActivityLogicHolder(viewHolder);

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(logicHolder::putNum);
        }
        viewHolder.getPlusButton().setOnClickListener(logicHolder::summarize);
        viewHolder.getMinusButton().setOnClickListener(v -> logicHolder.subtract());
        viewHolder.getMultiplicationSignButton().setOnClickListener(v -> logicHolder.multiply());
        viewHolder.getDivisionSignButton().setOnClickListener(v -> logicHolder.divide());
        viewHolder.getEqualMarkButton().setOnClickListener(v -> logicHolder.equal());

        viewHolder.getAllCleanButton().setOnClickListener(v -> logicHolder.cleanAll());
        viewHolder.getPointButton().setOnClickListener(v -> logicHolder.putDecimalPoint());
        viewHolder.getSignChangeButton().setOnClickListener(v -> logicHolder.changeSign());
        viewHolder.getDeleteLastCharacterButton().setOnClickListener(v -> logicHolder.deleteLastChar());
    }
}
