package slirdad.calculator.MainActivity.Domain.AboutAppFragment.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import slirdad.calculator.R;

public class AboutAppFragment extends Fragment {
    private final MenuItem item;

    public AboutAppFragment(MenuItem item) {
        this.item = item;
    }

    @SuppressWarnings("RedundantCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_app_fragment, container, false);

        Button viewGithubButton = (Button) view.findViewById(R.id.go_to_github_button);
        Button writeToDevelopersButton = (Button) view.findViewById(R.id.write_to_developers_button);
        Button rateApplicationButton = (Button) view.findViewById(R.id.rate_the_app_button);

        viewGithubButton.setOnClickListener(this::onViewGithubButtonClick);
        writeToDevelopersButton.setOnClickListener(this::onWriteToDevelopersButtonClick);
        rateApplicationButton.setOnClickListener(this::onRateApplicationButtonClick);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        item.setVisible(true);
    }

    private void onViewGithubButtonClick(View v) {
        startActivity
                (new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SkirdaD/Calculator")));
    }

    private void onWriteToDevelopersButtonClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "skirda_git@mail.ru", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    private void onRateApplicationButtonClick(View view) {
    }
}