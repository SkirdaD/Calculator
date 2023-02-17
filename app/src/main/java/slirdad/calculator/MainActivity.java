package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final Calculator calculator = new Calculator();
        final MainActivityViewHolder viewHolder = new MainActivityViewHolder(this);

        viewHolder.getMainTextView().setText("0"); // так сделано, пока нет шареда

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(new OnNumberButtonsClickListener(calculator, viewHolder));
        }
        viewHolder.getPlusButton().
                setOnClickListener(new OnPlusButtonClickListener(calculator, viewHolder));

        viewHolder.getMinusButton().
                setOnClickListener(new OnMinusButtonClickListener(calculator, viewHolder));
    }
}
