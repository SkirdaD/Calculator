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
                MainActivityViewHolderFactory.getMainActivityViewHolder(this);
        final Calculator calculator = CalculatorFactory.getCalculator();

        holder.getMainTextView().setText("0"); //пока нет шареда

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(
                    OnClickListenerFactory.getOnNumberButtonsClickListener(calculator, holder));
        }
        holder.getPlusButton().setOnClickListener(
                OnClickListenerFactory.getOnPlusButtonClickListener(calculator, holder));
        holder.getMinusButton().setOnClickListener(
                OnClickListenerFactory.getOnMinusButtonClickListener(calculator, holder, this));
        holder.getMultiplicationSignButton().setOnClickListener(
                OnClickListenerFactory.getOnMultiplicationButtonClickListener(calculator, holder));
        holder.getDivisionSignButton().setOnClickListener(
                OnClickListenerFactory.getOnDivisionButtonClickListener(calculator, holder));
        holder.getDeleteLastCharacterButton().setOnClickListener(
                OnClickListenerFactory.getOnDeleteLastCharButtonClickListener(calculator, holder));
        holder.getSignChangeButton().setOnClickListener(
                OnClickListenerFactory.getOnSignChangeButtonClickListener(calculator, holder));
        holder.getEqualMarkButton().setOnClickListener(
                OnClickListenerFactory.getOnEqualMarkButtonClickListener(calculator, holder));
        holder.getAllCleanButton().setOnClickListener(
                OnClickListenerFactory.getOnAllCleanButtonClickListener(calculator, holder));
        holder.getPointButton().setOnClickListener(
                OnClickListenerFactory.getOnPointButtonClickListener(calculator, holder));
    }
}
