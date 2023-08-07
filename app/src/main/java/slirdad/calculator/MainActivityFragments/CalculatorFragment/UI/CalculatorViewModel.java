package slirdad.calculator.MainActivityFragments.CalculatorFragment.UI;

import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private String mainText = "111";

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }
}
