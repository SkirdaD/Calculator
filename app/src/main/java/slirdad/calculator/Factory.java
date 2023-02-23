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

public class Factory {
    private static Context context;
    private static final Calculator calculator = new Calculator();
    private static MainActivityViewHolder holder;

    private Factory(Context context) {
        Factory.context = context;
    }

    public static void inject(Context context) {
        new Factory(context);
    }

    public static MainActivityViewHolder getMainActivityViewHolder() {
        holder = new MainActivityViewHolder((AppCompatActivity) context);
        return holder;
    }

    public static OnNumberButtonsClickListener getOnNumberButtonsClickListener() {
        return new OnNumberButtonsClickListener(calculator, holder);
    }

    public static OnPlusButtonClickListener getOnPlusButtonClickListener() {
        return new OnPlusButtonClickListener(calculator, holder);
    }

    public static OnMinusButtonClickListener getOnMinusButtonClickListener() {
        return new OnMinusButtonClickListener(calculator, holder);
    }

    public static OnMultiplicationButtonClickListener getOnMultiplicationButtonClickListener() {
        return new OnMultiplicationButtonClickListener(calculator, holder);
    }

    public static OnDivisionButtonClickListener getOnDivisionButtonClickListener() {
        return new OnDivisionButtonClickListener(calculator, holder);
    }

    public static OnDeleteLastCharButtonClickListener getOnDeleteLastCharButtonClickListener() {
        return new OnDeleteLastCharButtonClickListener(calculator, holder);
    }

    public static OnSignChangeButtonClickListener getOnSignChangeButtonClickListener() {
        return new OnSignChangeButtonClickListener(calculator, holder);
    }

    public static OnEqualMarkButtonClickListener getOnEqualMarkButtonClickListener() {
        return new OnEqualMarkButtonClickListener(calculator, holder);
    }

    public static OnAllCleanButtonClickListener getOnAllCleanButtonClickListener() {
        return new OnAllCleanButtonClickListener(calculator, holder);
    }

    public static OnPointButtonClickListener getOnPointButtonClickListener() {
        return new OnPointButtonClickListener(calculator, holder);
    }


}
