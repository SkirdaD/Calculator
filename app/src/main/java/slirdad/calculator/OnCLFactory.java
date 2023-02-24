package slirdad.calculator;

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

class OnCLFactory {
    private final OnNumberButtonsClickListener onNumberButtonsClickListener;
    private final OnPlusButtonClickListener onPlusButtonClickListener;
    private final OnMinusButtonClickListener onMinusButtonClickListener;
    private final OnMultiplicationButtonClickListener onMultiplicationButtonClickListener;
    private final OnDivisionButtonClickListener onDivisionButtonClickListener;
    private final OnDeleteLastCharButtonClickListener onDeleteLastCharButtonClickListener;
    private final OnSignChangeButtonClickListener onSignChangeButtonClickListener;
    private final OnEqualMarkButtonClickListener onEqualMarkButtonClickListener;
    private final OnAllCleanButtonClickListener onAllCleanButtonClickListener;
    private final OnPointButtonClickListener onPointButtonClickListener;


    OnCLFactory(MainActivityViewHolder holder) {
        Calculator calculator = new Calculator();
        onNumberButtonsClickListener = new OnNumberButtonsClickListener(calculator, holder);
        onPlusButtonClickListener = new OnPlusButtonClickListener(calculator, holder);
        onMinusButtonClickListener = new OnMinusButtonClickListener(calculator, holder);
        onMultiplicationButtonClickListener = new OnMultiplicationButtonClickListener(calculator, holder);
        onDivisionButtonClickListener = new OnDivisionButtonClickListener(calculator, holder);
        onDeleteLastCharButtonClickListener = new OnDeleteLastCharButtonClickListener(calculator,holder);
        onSignChangeButtonClickListener = new OnSignChangeButtonClickListener(calculator, holder);
        onEqualMarkButtonClickListener = new OnEqualMarkButtonClickListener(calculator, holder);
        onAllCleanButtonClickListener = new OnAllCleanButtonClickListener(calculator, holder);
        onPointButtonClickListener = new OnPointButtonClickListener(calculator, holder);

    }

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
