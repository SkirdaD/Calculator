package slirdad.calculator.CalculationTrainingFragment.UI;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import slirdad.calculator.R;

public class CalculationTrainingViewHolder {
    private final Button helpMeCountButton;
    private final TextView firstNumTextView;
    private final TextView secondNumTextView;
    private final TextView operationTextView;


    CalculationTrainingViewHolder(View view){
        helpMeCountButton = (Button) view.findViewById(R.id.helpMeCountButton);
        firstNumTextView = (TextView) view.findViewById(R.id.firstNumTextView);
        secondNumTextView = (TextView) view.findViewById(R.id.secondNumTextView);
        operationTextView = (TextView) view.findViewById(R.id.operationTextView);
    }

    public Button getHelpMeCountButton() {
        return helpMeCountButton;
    }

    public TextView getFirstNumTextView() {
        return firstNumTextView;
    }

    public TextView getSecondNumTextView() {
        return secondNumTextView;
    }

    public TextView getOperationTextView() {
        return operationTextView;
    }
}
