package slirdad.calculator;

import android.content.Context;

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
    CalculatorFactory calculatorFactory = new CalculatorFactory();
    Calculator calculator = calculatorFactory.getCalculator();
    MainActivityViewHolder viewHolder = new MainActivityViewHolder;
    Context context;

    public OnClickListenerFactory(AppCompatActivity activity) {
        this.context = activity;
    }

    final private OnNumberButtonsClickListener onNumberButtonsClickListener =
            new OnNumberButtonsClickListener(calculator, viewHolder);
    final private OnPlusButtonClickListener onPlusButtonClickListener =
            new OnPlusButtonClickListener(calculator, viewHolder);
    final private OnMinusButtonClickListener onMinusButtonClickListener =
            new OnMinusButtonClickListener(calculator, viewHolder, context);
    final private OnMultiplicationButtonClickListener onMultiplicationButtonClickListener =
            new OnMultiplicationButtonClickListener(calculator, viewHolder);
    final private OnDivisionButtonClickListener onDivisionButtonClickListener =
            new OnDivisionButtonClickListener(calculator, viewHolder);
    final private OnDeleteLastCharButtonClickListener onDeleteLastCharButtonClickListener =
            new OnDeleteLastCharButtonClickListener(calculator, viewHolder);
    final private OnSignChangeButtonClickListener onSignChangeButtonClickListener =
            new OnSignChangeButtonClickListener(calculator, viewHolder);
    final private OnEqualMarkButtonClickListener onEqualMarkButtonClickListener =
            new OnEqualMarkButtonClickListener(calculator, viewHolder);
    final private OnAllCleanButtonClickListener onAllCleanButtonClickListener =
            new OnAllCleanButtonClickListener(calculator, viewHolder);
    final private OnPointButtonClickListener onPointButtonClickListener =
            new OnPointButtonClickListener(calculator, viewHolder);

    public OnNumberButtonsClickListener getOnNumberButtonsClickListener() {
        return onNumberButtonsClickListener;
    }

    public OnPlusButtonClickListener getOnPlusButtonClickListener() {
        return onPlusButtonClickListener;
    }

    public OnMinusButtonClickListener getOnMinusButtonClickListener() {
        return onMinusButtonClickListener;
    }

    public OnMultiplicationButtonClickListener getOnMultiplicationButtonClickListener() {
        return onMultiplicationButtonClickListener;
    }

    public OnDivisionButtonClickListener getOnDivisionButtonClickListener() {
        return onDivisionButtonClickListener;
    }

    public OnDeleteLastCharButtonClickListener getOnDeleteLastCharButtonClickListener() {
        return onDeleteLastCharButtonClickListener;
    }

    public OnSignChangeButtonClickListener getOnSignChangeButtonClickListener() {
        return onSignChangeButtonClickListener;
    }

    public OnEqualMarkButtonClickListener getOnEqualMarkButtonClickListener() {
        return onEqualMarkButtonClickListener;
    }

    public OnAllCleanButtonClickListener getOnAllCleanButtonClickListener() {
        return onAllCleanButtonClickListener;
    }

    public OnPointButtonClickListener getOnPointButtonClickListener() {
        return onPointButtonClickListener;
    }
}

