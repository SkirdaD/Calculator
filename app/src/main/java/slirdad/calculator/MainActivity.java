package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
        } else if (item.getItemId() == R.id.newFragment) {
            Toast.makeText(getApplicationContext(), "Экран в разработке", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
