package slirdad.calculator.MainActivityFragments.CalculationTrainingFragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;

import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.Operation;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;
import slirdad.calculator.MainActivityFragments.StringValues;

public class CalculationTrainingLogicHolder {

    private final CalculationTrainingViewHolder viewHolder;
    private final Calculator calculator = new Calculator();
    private Operation operation;

    CalculationTrainingLogicHolder(CalculationTrainingViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    void showAnswer(@SuppressWarnings("unused") View view) {
        double result = CalculationTrainingExtensionMethods.
                calculate(viewHolder, calculator, operation);

        String answer = String.valueOf(result);
        answer = CalculatorFragmentExtensionMethods.formatWholeDoubleAsInt(answer);
        viewHolder.getAnswerEditText().setText(answer);
    }

    @SuppressLint("ResourceAsColor")
    void setRandomValues(@SuppressWarnings("unused") View view) {
        viewHolder.getAnswerEditText().setBackgroundColor(Color.LTGRAY);
        viewHolder.getAnswerEditText().setText("");


        operation = CalculationTrainingExtensionMethods.getRandomOperation();

        viewHolder.getFirstNumTextView().
                setText(String.valueOf(
                        CalculationTrainingExtensionMethods.getRandomInteger()));

        viewHolder.getSecondNumTextView().
                setText(String.valueOf(
                        CalculationTrainingExtensionMethods.getRandomInteger()));


        switch (operation) {
            case ADDITION: {
                viewHolder.getOperationTextView().setText(StringValues.PLUS_SIGN);
                break;
            }
            case SUBTRACTION: {
                viewHolder.getOperationTextView().setText(StringValues.MINUS_SIGN);
                break;
            }
            case MULTIPLICATION: {
                viewHolder.getOperationTextView().setText(StringValues.MULTIPLICATION_SIGN);
                break;
            }
            case DIVISION: {
                viewHolder.getOperationTextView().setText(StringValues.DIVISION_SIGN);
                break;
            }
        }
    }

    void checkAnswer(@SuppressWarnings("unused") View view) {
        double result = CalculationTrainingExtensionMethods.
                calculate(viewHolder, calculator, operation);

        if (result != Double.parseDouble(viewHolder.getAnswerEditText().getText().toString())) {
            viewHolder.getAnswerEditText().setBackgroundColor(Color.RED);
        } else {
            viewHolder.getAnswerEditText().setBackgroundColor(Color.GREEN);
        }
    }
}
