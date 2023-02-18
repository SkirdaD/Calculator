package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import slirdad.calculator.OnClickListeners.OnAllCleanButtonClickListener;
import slirdad.calculator.OnClickListeners.OnDeleteLastCharButtonClickListener;
import slirdad.calculator.OnClickListeners.OnDivisionButtonClickListener;
import slirdad.calculator.OnClickListeners.OnEqualMarkButtonClickListener;
import slirdad.calculator.OnClickListeners.OnMinusButtonClickListener;
import slirdad.calculator.OnClickListeners.OnMultiplicationButtonClickListener;
import slirdad.calculator.OnClickListeners.OnNumberButtonsClickListener;
import slirdad.calculator.OnClickListeners.OnPlusButtonClickListener;
import slirdad.calculator.OnClickListeners.OnSignChangeButtonClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final Calculator calculator = new Calculator();
        final MainActivityViewHolder viewHolder = new MainActivityViewHolder(this);
        final OnNumberButtonsClickListener onNumberButtonsClickListener =
                new OnNumberButtonsClickListener(calculator, viewHolder);

        viewHolder.getMainTextView().setText("0"); // так сделано, пока нет шареда

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(onNumberButtonsClickListener);
        }

        viewHolder.getPlusButton().
                setOnClickListener(new OnPlusButtonClickListener(calculator, viewHolder));

        viewHolder.getMinusButton().
                setOnClickListener(new OnMinusButtonClickListener(calculator, viewHolder, this));

        viewHolder.getMultiplicationSignButton().
                setOnClickListener(new OnMultiplicationButtonClickListener(calculator, viewHolder));

        viewHolder.getDivisionSignButton().
                setOnClickListener(new OnDivisionButtonClickListener(calculator, viewHolder));

        viewHolder.getDeleteLastCharacterButton().
                setOnClickListener(new OnDeleteLastCharButtonClickListener(calculator, viewHolder));

        viewHolder.getSignChangeButton().
                setOnClickListener(new OnSignChangeButtonClickListener(calculator, viewHolder));

        viewHolder.getEqualMarkButton().
                setOnClickListener(new OnEqualMarkButtonClickListener(calculator, viewHolder));

        viewHolder.getAllCleanButton().
                setOnClickListener(new OnAllCleanButtonClickListener(calculator, viewHolder));
    }
}
