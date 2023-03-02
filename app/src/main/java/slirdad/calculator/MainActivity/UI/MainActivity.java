package slirdad.calculator.MainActivity.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import slirdad.calculator.AboutAppFragment.UI.AboutAppFragment;
import slirdad.calculator.CalculatorFragment.UI.CalculatorFragment;
import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {
    private AboutAppFragment aboutAppFragment;
    private CalculatorFragment calculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutAppFragment = new AboutAppFragment();
        calculatorFragment = new CalculatorFragment();

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment, calculatorFragment).commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_app) {
            getSupportFragmentManager().beginTransaction().hide(calculatorFragment).
                    add(R.id.fragment, aboutAppFragment).addToBackStack("aboutApp").commit();
        } else if (item.getItemId() == R.id.about_app2) {
            Toast.makeText(getApplicationContext(), "Экран в разработке", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
