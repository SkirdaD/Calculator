package slirdad.calculator.CalculationTrainingFragment.UI;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;

import slirdad.calculator.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.CalculatorFragment.Domain.Operation;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragmentExtensionMethods;

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
                viewHolder.getOperationTextView().setText("+");
                break;
            }
            case SUBTRACTION: {
                viewHolder.getOperationTextView().setText("-");
                break;
            }
            case MULTIPLICATION: {
                viewHolder.getOperationTextView().setText("*");
                break;
            }
            case DIVISION: {
                viewHolder.getOperationTextView().setText("/");
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
