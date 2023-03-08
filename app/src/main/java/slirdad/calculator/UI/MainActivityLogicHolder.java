package slirdad.calculator.UI;

import android.view.MenuItem;

import androidx.fragment.app.FragmentManager;

import slirdad.calculator.AboutAppFragment.UI.AboutAppFragment;
import slirdad.calculator.CalculationTrainingFragment.UI.CalculationTrainingFragment;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragment;
import slirdad.calculator.R;

public class MainActivityLogicHolder {

    private final FragmentManager fragmentManager;
    private final CalculatorFragment calculatorFragment = new CalculatorFragment();

    public MainActivityLogicHolder(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showCalculatorFragment() {
        fragmentManager.beginTransaction().
                add(R.id.fragment, calculatorFragment).
                commit();
    }

    public void showAboutAppFragment(MenuItem item) {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, new AboutAppFragment(item)).
                addToBackStack("aboutApp").
                commit();
        item.setVisible(false);
    }

    public void showCalculatorTrainingFragment(MenuItem item) {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, new CalculationTrainingFragment(item)).
                addToBackStack("calculatorTraining").
                commit();
        item.setVisible(false);
    }
}