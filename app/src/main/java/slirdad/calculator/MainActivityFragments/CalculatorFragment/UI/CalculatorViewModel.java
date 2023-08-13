package slirdad.calculator.MainActivityFragments.CalculatorFragment.UI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private MutableLiveData<String> textLiveData = new MutableLiveData<>();

    public LiveData<String> getTextLiveData() {
        return textLiveData;
    }

    public void setText(String newText) {
        textLiveData.setValue(newText);
    }
//    public String getMainText() {
//        return mainText;
//    }
//
//    public void setMainText(String mainText) {
//        this.mainText = mainText;
//    }
}
