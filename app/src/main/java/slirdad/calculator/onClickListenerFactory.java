package slirdad.calculator;

import android.content.Context;

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
    private static final Calculator calculator = CalculatorFactory.getCalculator();

    public static OnNumberButtonsClickListener getOnNumberButtonsClickListener(MainActivityViewHolder holder) {
        return new OnNumberButtonsClickListener(calculator, holder);
    }

    public static OnPlusButtonClickListener getOnPlusButtonClickListener(MainActivityViewHolder holder) {
        return new OnPlusButtonClickListener(calculator, holder);
    }

    public static OnMinusButtonClickListener getOnMinusButtonClickListener(MainActivityViewHolder holder, Context context) {
        return new OnMinusButtonClickListener(calculator, holder, context);
    }

    public static OnMultiplicationButtonClickListener getOnMultiplicationButtonClickListener(MainActivityViewHolder holder) {
        return new OnMultiplicationButtonClickListener(calculator, holder);
    }

    public static OnDivisionButtonClickListener getOnDivisionButtonClickListener(MainActivityViewHolder holder) {
        return new OnDivisionButtonClickListener(calculator, holder);
    }

    public static OnDeleteLastCharButtonClickListener getOnDeleteLastCharButtonClickListener(MainActivityViewHolder holder) {
        return new OnDeleteLastCharButtonClickListener(calculator, holder);
    }

    public static OnSignChangeButtonClickListener getOnSignChangeButtonClickListener(MainActivityViewHolder holder) {
        return new OnSignChangeButtonClickListener(calculator, holder);
    }

    public static OnEqualMarkButtonClickListener getOnEqualMarkButtonClickListener(MainActivityViewHolder holder) {
        return new OnEqualMarkButtonClickListener(calculator, holder);
    }

    public static OnAllCleanButtonClickListener getOnAllCleanButtonClickListener(MainActivityViewHolder holder) {
        return new OnAllCleanButtonClickListener(calculator, holder);
    }

    public static OnPointButtonClickListener getOnPointButtonClickListener(MainActivityViewHolder holder) {
        return new OnPointButtonClickListener(calculator, holder);
    }
}
