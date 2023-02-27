package slirdad.calculator.UI;

import android.view.View;
import android.widget.TextView;

import slirdad.calculator.R;

public class OnCLMainActivityFactory implements View.OnClickListener {
    MainActivityViewHolder holder;

    public OnCLMainActivityFactory(MainActivityViewHolder holder) {
        this.holder = holder;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlus:
                pressPlus(holder.getMainTextView());
                break;
            case R.id.buttonMinus:
                pressMinus(holder.getMainTextView());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void pressMinus(TextView mainTextView) {
        mainTextView.setText("Минус");
    }

    private void pressPlus(TextView mainTextView) {
        mainTextView.setText("Плюс");
    }
}
