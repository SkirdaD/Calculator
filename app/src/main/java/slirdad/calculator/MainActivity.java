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
import slirdad.calculator.OnClickListeners.OnPointButtonClickListener;
import slirdad.calculator.OnClickListeners.OnSignChangeButtonClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final MainActivityViewHolder viewHolder = new MainActivityViewHolder(this);
        final OnClickListenerFactory onCLFactory = new OnClickListenerFactory(this);



        viewHolder.getMainTextView().setText("0"); // так сделано, пока нет шареда

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(onCLFactory.getOnNumberButtonsClickListener());
        }
        viewHolder.getPlusButton().setOnClickListener(onCLFactory.getOnPlusButtonClickListener());
        viewHolder.getMinusButton().setOnClickListener(onCLFactory.getOnMinusButtonClickListener());
        viewHolder.getMultiplicationSignButton().setOnClickListener(onCLFactory.getOnMultiplicationButtonClickListener());
        viewHolder.getDivisionSignButton().setOnClickListener(onCLFactory.getOnDivisionButtonClickListener());
        viewHolder.getDeleteLastCharacterButton().setOnClickListener(onCLFactory.getOnDeleteLastCharButtonClickListener());
        viewHolder.getSignChangeButton().setOnClickListener(onCLFactory.getOnSignChangeButtonClickListener());
        viewHolder.getEqualMarkButton().setOnClickListener(onCLFactory.getOnEqualMarkButtonClickListener());
        viewHolder.getAllCleanButton().setOnClickListener(onCLFactory.getOnAllCleanButtonClickListener());
        viewHolder.getPointButton().setOnClickListener(onCLFactory.getOnPointButtonClickListener());
    }
}
