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

        final MainActivityViewHolder holder = new MainActivityViewHolder(this);
        final OnCLFactory factory = new OnCLFactory(holder);

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(factory.getOnNumberButtonsClickListener());
        }
        //holder.getPlusButton().setOnClickListener(factory.getOnPlusButtonClickListener());
        holder.getPlusButton().setOnClickListener(factory.pressPlus(holder));
        holder.getMinusButton().setOnClickListener(factory.getOnMinusButtonClickListener());
        holder.getMultiplicationSignButton().setOnClickListener(
                factory.getOnMultiplicationButtonClickListener());
        holder.getDivisionSignButton().setOnClickListener(
                factory.getOnDivisionButtonClickListener());
        holder.getDeleteLastCharacterButton().setOnClickListener(
                factory.getOnDeleteLastCharButtonClickListener());
        holder.getSignChangeButton().setOnClickListener(
                factory.getOnSignChangeButtonClickListener());
        holder.getEqualMarkButton().setOnClickListener(factory.getOnEqualMarkButtonClickListener());
        holder.getAllCleanButton().setOnClickListener(factory.getOnAllCleanButtonClickListener());
        holder.getPointButton().setOnClickListener(factory.getOnPointButtonClickListener());
    }
}
