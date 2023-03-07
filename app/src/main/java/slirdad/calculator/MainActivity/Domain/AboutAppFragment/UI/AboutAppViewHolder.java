package slirdad.calculator.MainActivity.Domain.AboutAppFragment.UI;

import android.view.View;
import android.widget.Button;

import slirdad.calculator.R;

class AboutAppViewHolder {
    private final Button viewGithubButton;
    private final Button writeToDevelopersButton;
    private final Button rateApplicationButton;

    @SuppressWarnings("RedundantCast")
    AboutAppViewHolder(View view) {

        viewGithubButton = (Button) view.findViewById(R.id.go_to_github_button);
        writeToDevelopersButton = (Button) view.findViewById(R.id.write_to_developers_button);
        rateApplicationButton = (Button) view.findViewById(R.id.rate_the_app_button);
    }

    Button getViewGithubButton() {
        return viewGithubButton;
    }

    Button getWriteToDevelopersButton() {
        return writeToDevelopersButton;
    }

    Button getRateApplicationButton() {
        return rateApplicationButton;
    }
}
