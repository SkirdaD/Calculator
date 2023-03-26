package slirdad.calculator.MainActivityFragments.AboutAppFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import slirdad.calculator.R;

public class AboutAppFragment extends Fragment {
    private final MenuItem item;

    public AboutAppFragment(MenuItem item) {
        this.item = item;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_app_fragment, container, false);

        AboutAppViewHolder viewHolder = new AboutAppViewHolder(view);
        AboutAppLogicHolder logicHolder = new AboutAppLogicHolder(getContext());

        viewHolder.getViewGithubButton().setOnClickListener(logicHolder::goToGitHub);
        viewHolder.getWriteToDevelopersButton().setOnClickListener(logicHolder::sendEmail);
        viewHolder.getRateApplicationButton().setOnClickListener(logicHolder::rateApplication);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        item.setVisible(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        item.setVisible(true);
    }
}
