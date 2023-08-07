package slirdad.calculator.MainActivityFragments.CalculationTrainingFragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import slirdad.calculator.R;

public class CalculationTrainingViewHolder {
    private final Button helpMeCountButton;
    private final TextView firstNumTextView;
    private final TextView secondNumTextView;
    private final TextView operationTextView;
    private final EditText answerEditText;
    private final Button refreshButton;
    private final Button okButton;

    @SuppressWarnings("RedundantCast")
    CalculationTrainingViewHolder(View view) {
        helpMeCountButton = (Button) view.findViewById(R.id.helpMeCountButton);
        firstNumTextView = (TextView) view.findViewById(R.id.firstNumTextView);
        secondNumTextView = (TextView) view.findViewById(R.id.secondNumTextView);
        operationTextView = (TextView) view.findViewById(R.id.operationTextView);
        answerEditText = (EditText) view.findViewById(R.id.answerEditTextNumber);
        refreshButton = (Button) view.findViewById(R.id.refreshButton);
        okButton = (Button) view.findViewById(R.id.okButton);

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

    public EditText getAnswerEditText() {
        return answerEditText;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public Button getOkButton() {
        return okButton;
    }
}
