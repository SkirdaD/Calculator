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

        viewHolder.getMainTextView().setText("0"); // так сделано, пока нет шареда

        final OnNumberButtonsClickListener onNumberButtonsClickListener =
                new OnNumberButtonsClickListener(calculator, viewHolder);
        final OnPlusButtonClickListener onPlusButtonClickListener =
                new OnPlusButtonClickListener(calculator, viewHolder);
        final OnMinusButtonClickListener onMinusButtonClickListener =
                new OnMinusButtonClickListener(calculator, viewHolder, this);
        final OnMultiplicationButtonClickListener onMultiplicationButtonClickListener =
                new OnMultiplicationButtonClickListener(calculator, viewHolder);
        final OnDivisionButtonClickListener onDivisionButtonClickListener =
                new OnDivisionButtonClickListener(calculator, viewHolder);
        final OnDeleteLastCharButtonClickListener onDeleteLastCharButtonClickListener =
                new OnDeleteLastCharButtonClickListener(calculator, viewHolder);
        final OnSignChangeButtonClickListener onSignChangeButtonClickListener =
                new OnSignChangeButtonClickListener(calculator, viewHolder);
        final OnEqualMarkButtonClickListener onEqualMarkButtonClickListener =
                new OnEqualMarkButtonClickListener(calculator, viewHolder);
        final OnAllCleanButtonClickListener onAllCleanButtonClickListener =
                new OnAllCleanButtonClickListener(calculator, viewHolder);

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(onNumberButtonsClickListener);
        }
        viewHolder.getPlusButton().setOnClickListener(onPlusButtonClickListener);
        viewHolder.getMinusButton().setOnClickListener(onMinusButtonClickListener);
        viewHolder.getMultiplicationSignButton().setOnClickListener(onMultiplicationButtonClickListener);
        viewHolder.getDivisionSignButton().setOnClickListener(onDivisionButtonClickListener);
        viewHolder.getDeleteLastCharacterButton().setOnClickListener(onDeleteLastCharButtonClickListener);
        viewHolder.getSignChangeButton().setOnClickListener(onSignChangeButtonClickListener);
        viewHolder.getEqualMarkButton().setOnClickListener(onEqualMarkButtonClickListener);
        viewHolder.getAllCleanButton().setOnClickListener(onAllCleanButtonClickListener);
    }
}
