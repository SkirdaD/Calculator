package slirdad.calculator.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {

    private final MainActivityLogicHolder holder = new MainActivityLogicHolder(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holder.showCalculatorFragment();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.aboutApp) {
            holder.showAboutAppFragment(item);
        } else if (item.getItemId() == R.id.training) {
            holder.showCalculatorTrainingFragment(item);
        } else if (item.getItemId() == R.id.operationHistory) {
            holder.showHistoryScreenFragment(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
