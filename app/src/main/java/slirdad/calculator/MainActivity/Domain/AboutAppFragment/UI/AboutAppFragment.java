package slirdad.calculator.MainActivity.Domain.AboutAppFragment.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import slirdad.calculator.R;

public class AboutAppFragment extends Fragment {
    MenuItem item;

    public AboutAppFragment(MenuItem item) {
        this.item = item;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_app_fragment, container, false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        item.setVisible(true);
    }
}