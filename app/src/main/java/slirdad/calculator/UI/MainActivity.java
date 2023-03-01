package slirdad.calculator.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import slirdad.calculator.AboutAppFragment;
import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {
    AboutAppFragment aboutAppFragment;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        aboutAppFragment = new AboutAppFragment();


        final MainActivityViewHolder holder = new MainActivityViewHolder(this);
        final OnCLFactory factory = new OnCLFactory(holder);

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(factory.getOnNumberButtonsClickListener());
        }
        holder.getPlusButton().setOnClickListener(factory.getOnPlusButtonClickListener());
        holder.getMinusButton().setOnClickListener(factory.getOnMinusButtonClickListener());
        holder.getMultiplicationSignButton().setOnClickListener(
                factory.getOnMultiplicationButtonClickListener());
        holder.getDivisionSignButton().setOnClickListener(
                factory.getOnDivisionButtonClickListener());
        holder.getDeleteLastCharacterButton().setOnClickListener(
                factory.getOnDeleteLastCharButtonClickListener());
        holder.getSignChangeButton().setOnClickListener(
                factory.getOnSignChangeButtonClickListener());
        holder.getEqualMarkButton().setOnClickListener(factory.getOnEqualMarkButtonClickListener());
        holder.getAllCleanButton().setOnClickListener(factory.getOnAllCleanButtonClickListener());
        holder.getPointButton().setOnClickListener(factory.getOnPointButtonClickListener());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_app) {
            fragmentTransaction.add(R.id.fragment, aboutAppFragment).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
