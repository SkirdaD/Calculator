package slirdad.calculator;

import android.view.MenuItem;

import androidx.fragment.app.FragmentManager;

import slirdad.calculator.Data.DataBase.HistoryDataBaseManager;
import slirdad.calculator.MainActivityFragments.AboutAppFragment.AboutAppFragment;
import slirdad.calculator.MainActivityFragments.CalculationTrainingFragment.CalculationTrainingFragment;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.UI.CalculatorFragment;
import slirdad.calculator.MainActivityFragments.HistoryScreenFragment.HistoryScreenFragment;

public class MainActivityLogicHolder {

    private final HistoryDataBaseManager dataBaseManager;
    private final FragmentManager fragmentManager;
    private final CalculatorFragment calculatorFragment;

    public MainActivityLogicHolder(FragmentManager fragmentManager, HistoryDataBaseManager dataBaseManager) {
        this.fragmentManager = fragmentManager;
        this.dataBaseManager = dataBaseManager;
        calculatorFragment = new CalculatorFragment(dataBaseManager);
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

    public void showHistoryScreenFragment(MenuItem item) {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, new HistoryScreenFragment((item), dataBaseManager)).
                addToBackStack("historyScreen").
                commit();
        item.setVisible(false);
    }
}
