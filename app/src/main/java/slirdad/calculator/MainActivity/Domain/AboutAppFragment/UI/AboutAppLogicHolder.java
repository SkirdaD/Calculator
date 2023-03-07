package slirdad.calculator.MainActivity.Domain.AboutAppFragment.UI;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.fragment.app.Fragment;

class AboutAppLogicHolder {
    Fragment fragmentContext;

    AboutAppLogicHolder(Fragment context) {
        this.fragmentContext = context;
    }

    void goToGitHub(@SuppressWarnings("unused") View view) {
        fragmentContext.startActivity
                (new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SkirdaD/Calculator")));
    }

    void sendEmail(@SuppressWarnings("unused") View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO).
                setData(Uri.parse("mailto:")).
                putExtra(Intent.EXTRA_EMAIL, new String[]{"skirda_git@mail.ru"}).
                putExtra(Intent.EXTRA_SUBJECT, "Calculator.app").
                putExtra(Intent.EXTRA_TEXT, "Your text");
        fragmentContext.startActivity(Intent.createChooser(emailIntent, "Send e-mail..."));
    }

    void rateApplication(@SuppressWarnings("unused") View view) {
    }
}
