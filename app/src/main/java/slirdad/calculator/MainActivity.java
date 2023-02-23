package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        Factory.inject(this);

        final MainActivityViewHolder holder = Factory.getMainActivityViewHolder();

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(Factory.getOnNumberButtonsClickListener());
        }
        holder.getPlusButton().setOnClickListener(Factory.getOnPlusButtonClickListener());
        holder.getMinusButton().setOnClickListener(Factory.getOnMinusButtonClickListener());
        holder.getMultiplicationSignButton().setOnClickListener(
                Factory.getOnMultiplicationButtonClickListener());
        holder.getDivisionSignButton().setOnClickListener(
                Factory.getOnDivisionButtonClickListener());
        holder.getDeleteLastCharacterButton().setOnClickListener(
                Factory.getOnDeleteLastCharButtonClickListener());
        holder.getSignChangeButton().setOnClickListener(
                Factory.getOnSignChangeButtonClickListener());
        holder.getEqualMarkButton().setOnClickListener(Factory.getOnEqualMarkButtonClickListener());
        holder.getAllCleanButton().setOnClickListener(Factory.getOnAllCleanButtonClickListener());
        holder.getPointButton().setOnClickListener(Factory.getOnPointButtonClickListener());
    }
}
