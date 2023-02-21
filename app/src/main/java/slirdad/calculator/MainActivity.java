package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final MainActivityViewHolder holder =
                Factory.getMainActivityViewHolder(this);

        holder.getMainTextView().setText("0"); //пока нет шареда

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(
                    Factory.getOnNumberButtonsClickListener(this));
        }
        holder.getPlusButton().setOnClickListener(Factory.getOnPlusButtonClickListener(this));
        holder.getMinusButton().setOnClickListener(
                Factory.getOnMinusButtonClickListener(this));
        holder.getMultiplicationSignButton().setOnClickListener(
                Factory.getOnMultiplicationButtonClickListener(this));
        holder.getDivisionSignButton().setOnClickListener(
                Factory.getOnDivisionButtonClickListener(this));
        holder.getDeleteLastCharacterButton().setOnClickListener(
                Factory.getOnDeleteLastCharButtonClickListener(this));
        holder.getSignChangeButton().setOnClickListener(
                Factory.getOnSignChangeButtonClickListener(this));
        holder.getEqualMarkButton().setOnClickListener(
                Factory.getOnEqualMarkButtonClickListener(this));
        holder.getAllCleanButton().setOnClickListener(
                Factory.getOnAllCleanButtonClickListener(this));
        holder.getPointButton().setOnClickListener(Factory.getOnPointButtonClickListener(this));
    }
}
