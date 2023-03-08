package slirdad.calculator.AboutAppFragment.UI;

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
        String repositoryURL = "https://github.com/SkirdaD/Calculator";

        fragmentContext.startActivity
                (new Intent(Intent.ACTION_VIEW, Uri.parse(repositoryURL)));
    }

    void sendEmail(@SuppressWarnings("unused") View view) {
        String eMail = "skirda_git@mail.ru";
        String eMailSubject = "Calculator.app";
        String yourText = "Your text";
        String sendEMail = "Send e-mail...";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO).
                setData(Uri.parse("mailto:")).
                putExtra(Intent.EXTRA_EMAIL, new String[]{eMail}).
                putExtra(Intent.EXTRA_SUBJECT, eMailSubject).
                putExtra(Intent.EXTRA_TEXT, yourText);
        fragmentContext.startActivity(Intent.createChooser(emailIntent, sendEMail));
    }

    void rateApplication(@SuppressWarnings("unused") View view) {
    }
}
