package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import slirdad.calculator.OnClickListeners.OnMinusButtonClickListener;
import slirdad.calculator.OnClickListeners.OnNumberButtonsClickListener;
import slirdad.calculator.OnClickListeners.OnPlusButtonClickListener;

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
                setOnClickListener(new OnMinusButtonClickListener(calculator, viewHolder));
    }
}
