package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final OnClickListenerFactory onCLFactory = new OnClickListenerFactory(this);
        final MainActivityViewHolderFactory holderFactory = new MainActivityViewHolderFactory(this);

        holderFactory.getMainActivityViewHolder().getMainTextView().setText("0"); //пока нет шареда

        for (Button button : holderFactory.getMainActivityViewHolder().getNumButtons()) {
            button.setOnClickListener(onCLFactory.getOnNumberButtonsClickListener());
        }
        holderFactory.getMainActivityViewHolder().getPlusButton().
                setOnClickListener(onCLFactory.getOnPlusButtonClickListener());
        holderFactory.getMainActivityViewHolder().getMinusButton().
                setOnClickListener(onCLFactory.getOnMinusButtonClickListener());
        holderFactory.getMainActivityViewHolder().getMultiplicationSignButton().
                setOnClickListener(onCLFactory.getOnMultiplicationButtonClickListener());
        holderFactory.getMainActivityViewHolder().getDivisionSignButton().
                setOnClickListener(onCLFactory.getOnDivisionButtonClickListener());
        holderFactory.getMainActivityViewHolder().getDeleteLastCharacterButton().
                setOnClickListener(onCLFactory.getOnDeleteLastCharButtonClickListener());
        holderFactory.getMainActivityViewHolder().getSignChangeButton().
                setOnClickListener(onCLFactory.getOnSignChangeButtonClickListener());
        holderFactory.getMainActivityViewHolder().getEqualMarkButton().
                setOnClickListener(onCLFactory.getOnEqualMarkButtonClickListener());
        holderFactory.getMainActivityViewHolder().getAllCleanButton().
                setOnClickListener(onCLFactory.getOnAllCleanButtonClickListener());
        holderFactory.getMainActivityViewHolder().getPointButton().
                setOnClickListener(onCLFactory.getOnPointButtonClickListener());
    }
}
