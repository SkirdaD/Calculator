package slirdad.calculator.MainActivityFragments.AboutAppFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;


import slirdad.calculator.MainActivityFragments.StringValues;

class AboutAppLogicHolder {
    Context fragmentContext;

    AboutAppLogicHolder(Context context) {
        this.fragmentContext = context;
    }

    void goToGitHub(@SuppressWarnings("unused") View view) {
        fragmentContext.startActivity
                (new Intent(Intent.ACTION_VIEW, Uri.parse(StringValues.REPOSITORY_URL)));
    }

    void sendEmail(@SuppressWarnings("unused") View view) {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO).
                setData(Uri.parse("mailto:")).
                putExtra(Intent.EXTRA_EMAIL, new String[]{StringValues.EMAIL}).
                putExtra(Intent.EXTRA_SUBJECT, StringValues.EMAIL_SUBJECT).
                putExtra(Intent.EXTRA_TEXT, StringValues.YOUR_TEXT);
        fragmentContext.startActivity(Intent.createChooser(emailIntent, StringValues.SEND_EMAIL));
    }

    void rateApplication(@SuppressWarnings("unused") View view) {
    }
}
