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

public class Factory {
    private static final Calculator calculator = new Calculator();
    private static MainActivityViewHolder holder;

    public static MainActivityViewHolder getMainActivityViewHolder(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new MainActivityViewHolder(activity);
    }

    public static OnNumberButtonsClickListener getOnNumberButtonsClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnNumberButtonsClickListener(calculator, holder);
    }

    public static OnPlusButtonClickListener getOnPlusButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnPlusButtonClickListener(calculator, holder);
    }

    public static OnMinusButtonClickListener getOnMinusButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnMinusButtonClickListener(calculator, holder, activity);
    }

    public static OnMultiplicationButtonClickListener getOnMultiplicationButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnMultiplicationButtonClickListener(calculator, holder);
    }

    public static OnDivisionButtonClickListener getOnDivisionButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnDivisionButtonClickListener(calculator, holder);
    }

    public static OnDeleteLastCharButtonClickListener getOnDeleteLastCharButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnDeleteLastCharButtonClickListener(calculator, holder);
    }

    public static OnSignChangeButtonClickListener getOnSignChangeButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnSignChangeButtonClickListener(calculator, holder);
    }

    public static OnEqualMarkButtonClickListener getOnEqualMarkButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnEqualMarkButtonClickListener(calculator, holder);
    }

    public static OnAllCleanButtonClickListener getOnAllCleanButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnAllCleanButtonClickListener(calculator, holder);
    }

    public static OnPointButtonClickListener getOnPointButtonClickListener(AppCompatActivity activity) {
        holder = new MainActivityViewHolder(activity);
        return new OnPointButtonClickListener(calculator, holder);
    }


}
