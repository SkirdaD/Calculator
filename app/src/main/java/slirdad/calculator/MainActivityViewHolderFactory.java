package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityViewHolderFactory {
    final private MainActivityViewHolder mainActivityViewHolder;

    public MainActivityViewHolderFactory(AppCompatActivity activity) {
        this.mainActivityViewHolder = new MainActivityViewHolder(activity);
    }

    public MainActivityViewHolder getMainActivityViewHolder() {
        return mainActivityViewHolder;
    }
}
