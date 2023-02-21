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
            button.setOnClickListener(OnClickListenerFactory.getOnNumberButtonsClickListener());
        }
        holder.getPlusButton().
                setOnClickListener(OnClickListenerFactory.getOnPlusButtonClickListener());
        holder.getMinusButton().
                setOnClickListener(OnClickListenerFactory.getOnMinusButtonClickListener());
        holder.getMultiplicationSignButton().
                setOnClickListener(OnClickListenerFactory.getOnMultiplicationButtonClickListener());
        holder.getDivisionSignButton().
                setOnClickListener(OnClickListenerFactory.getOnDivisionButtonClickListener());
        holder.getDeleteLastCharacterButton().
                setOnClickListener(OnClickListenerFactory.getOnDeleteLastCharButtonClickListener());
        holder.getSignChangeButton().
                setOnClickListener(OnClickListenerFactory.getOnSignChangeButtonClickListener());
        holder.getEqualMarkButton().
                setOnClickListener(OnClickListenerFactory.getOnEqualMarkButtonClickListener());
        holder.getAllCleanButton().
                setOnClickListener(OnClickListenerFactory.getOnAllCleanButtonClickListener());
        holder.getPointButton().
                setOnClickListener(OnClickListenerFactory.getOnPointButtonClickListener());
    }
}
