package slirdad.calculator.MainActivity.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import slirdad.calculator.MainActivity.Domain.AboutAppFragment.UI.AboutAppFragment;
import slirdad.calculator.MainActivity.Domain.CalculatorFragment.UI.CalculatorFragment;
import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculatorFragment calculatorFragment = new CalculatorFragment();

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment, calculatorFragment).commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        item.setVisible(false);

        if (item.getItemId() == R.id.aboutApp) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment, new AboutAppFragment(item)).addToBackStack("aboutApp").commit();
            item.setVisible(false);
        } else if (item.getItemId() == R.id.newFragment) {
            Toast.makeText(getApplicationContext(), "Экран в разработке", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
