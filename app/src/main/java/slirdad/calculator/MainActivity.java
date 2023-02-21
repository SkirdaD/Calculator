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

        holder.getMainTextView().setText("0"); //пока нет шареда

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(
                    OnClickListenerFactory.getOnNumberButtonsClickListener(holder));
        }
        holder.getPlusButton().setOnClickListener(
                OnClickListenerFactory.getOnPlusButtonClickListener(holder));
        holder.getMinusButton().setOnClickListener(
                OnClickListenerFactory.getOnMinusButtonClickListener(holder, this));
        holder.getMultiplicationSignButton().setOnClickListener(
                OnClickListenerFactory.getOnMultiplicationButtonClickListener(holder));
        holder.getDivisionSignButton().setOnClickListener(
                OnClickListenerFactory.getOnDivisionButtonClickListener(holder));
        holder.getDeleteLastCharacterButton().setOnClickListener(
                OnClickListenerFactory.getOnDeleteLastCharButtonClickListener(holder));
        holder.getSignChangeButton().setOnClickListener(
                OnClickListenerFactory.getOnSignChangeButtonClickListener(holder));
        holder.getEqualMarkButton().setOnClickListener(
                OnClickListenerFactory.getOnEqualMarkButtonClickListener(holder));
        holder.getAllCleanButton().setOnClickListener(
                OnClickListenerFactory.getOnAllCleanButtonClickListener(holder));
        holder.getPointButton().setOnClickListener(
                OnClickListenerFactory.getOnPointButtonClickListener(holder));
    }
}
