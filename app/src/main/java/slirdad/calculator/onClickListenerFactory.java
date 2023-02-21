package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

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

class OnClickListenerFactory {

    private static OnNumberButtonsClickListener onNumberButtonsClickListener;
    private static OnPlusButtonClickListener onPlusButtonClickListener;
    private static OnMinusButtonClickListener onMinusButtonClickListener;
    private static OnMultiplicationButtonClickListener onMultiplicationButtonClickListener;
    private static OnDivisionButtonClickListener onDivisionButtonClickListener;
    private static OnDeleteLastCharButtonClickListener onDeleteLastCharButtonClickListener;
    private static OnSignChangeButtonClickListener onSignChangeButtonClickListener;
    private static OnEqualMarkButtonClickListener onEqualMarkButtonClickListener;
    private static OnAllCleanButtonClickListener onAllCleanButtonClickListener;
    private static OnPointButtonClickListener onPointButtonClickListener;



    public OnClickListenerFactory(AppCompatActivity activity) {
        MainActivityViewHolder viewHolder =
                MainActivityViewHolderFactory.getMainActivityViewHolder(activity);

        Calculator calculator = CalculatorFactory.getCalculator();

        onNumberButtonsClickListener = new OnNumberButtonsClickListener(calculator, viewHolder);
        onPlusButtonClickListener = new OnPlusButtonClickListener(calculator, viewHolder);
        onMinusButtonClickListener = new OnMinusButtonClickListener(calculator, viewHolder, activity);
        onMultiplicationButtonClickListener =
                new OnMultiplicationButtonClickListener(calculator, viewHolder);
        onDivisionButtonClickListener = new OnDivisionButtonClickListener(calculator, viewHolder);
        onDeleteLastCharButtonClickListener =
                new OnDeleteLastCharButtonClickListener(calculator, viewHolder);
        onSignChangeButtonClickListener = new OnSignChangeButtonClickListener(calculator, viewHolder);
        onEqualMarkButtonClickListener = new OnEqualMarkButtonClickListener(calculator, viewHolder);
        onAllCleanButtonClickListener = new OnAllCleanButtonClickListener(calculator, viewHolder);
        onPointButtonClickListener = new OnPointButtonClickListener(calculator, viewHolder);
    }

    public static OnNumberButtonsClickListener getOnNumberButtonsClickListener() {
        return onNumberButtonsClickListener;
    }

    public static OnPlusButtonClickListener getOnPlusButtonClickListener() {
        return onPlusButtonClickListener;
    }

    public static OnMinusButtonClickListener getOnMinusButtonClickListener() {
        return onMinusButtonClickListener;
    }

    public static OnMultiplicationButtonClickListener getOnMultiplicationButtonClickListener() {
        return onMultiplicationButtonClickListener;
    }

    public static OnDivisionButtonClickListener getOnDivisionButtonClickListener() {
        return onDivisionButtonClickListener;
    }

    public static OnDeleteLastCharButtonClickListener getOnDeleteLastCharButtonClickListener() {
        return onDeleteLastCharButtonClickListener;
    }

    public static OnSignChangeButtonClickListener getOnSignChangeButtonClickListener() {
        return onSignChangeButtonClickListener;
    }

    public static OnEqualMarkButtonClickListener getOnEqualMarkButtonClickListener() {
        return onEqualMarkButtonClickListener;
    }

    public static OnAllCleanButtonClickListener getOnAllCleanButtonClickListener() {
        return onAllCleanButtonClickListener;
    }

    public static OnPointButtonClickListener getOnPointButtonClickListener() {
        return onPointButtonClickListener;
    }
}
