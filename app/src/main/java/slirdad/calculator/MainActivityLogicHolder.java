package slirdad.calculator;

import android.content.Context;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase.HistoryDataBaseManager;
import slirdad.calculator.MainActivityFragments.AboutAppFragment.AboutAppFragment;
import slirdad.calculator.MainActivityFragments.CalculationTrainingFragment.CalculationTrainingFragment;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.UI.CalculatorFragment;
import slirdad.calculator.MainActivityFragments.HistoryScreenFragment.HistoryScreenFragment;

public class MainActivityLogicHolder {

    private final HistoryDataBaseManager dataBaseManager;
    private final FragmentManager fragmentManager;
    private final CalculatorFragment calculatorFragment;

    public MainActivityLogicHolder(Context context) {

        this.fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        this.dataBaseManager = new HistoryDataBaseManager(context);
        this.calculatorFragment = new CalculatorFragment(dataBaseManager);
    }

    public void showSelectedFragment(MenuItem item) {
        if (item.getItemId() == R.id.aboutApp) {
            showAboutAppFragment(item);
        } else if (item.getItemId() == R.id.training) {
            showCalculatorTrainingFragment(item);
        } else if (item.getItemId() == R.id.operationHistory) {
            showHistoryScreenFragment(item);
        }
    }

    public void showCalculatorFragment() {
        fragmentManager.beginTransaction().
                add(R.id.fragment, calculatorFragment).
                commit();
    }

    public void showAboutAppFragment(MenuItem item) {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, new AboutAppFragment()).
                addToBackStack("aboutApp").
                commit();
    }

    public void showCalculatorTrainingFragment(MenuItem item) {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, new CalculationTrainingFragment(item)).
                addToBackStack("calculatorTraining").
                commit();
    }

    public void showHistoryScreenFragment(MenuItem item) {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, new HistoryScreenFragment((item), dataBaseManager)).
                addToBackStack("historyScreen").
                commit();
    }
}
