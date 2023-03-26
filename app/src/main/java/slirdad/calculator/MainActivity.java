package slirdad.calculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import slirdad.calculator.Data.DataBase.HistoryDataBaseManager;

public class MainActivity extends AppCompatActivity {

    private MainActivityLogicHolder logicHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HistoryDataBaseManager dataBaseManager = new HistoryDataBaseManager(this);
        logicHolder = new MainActivityLogicHolder(getSupportFragmentManager(), dataBaseManager);

        logicHolder.showCalculatorFragment();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        logicHolder.showSelectedFragment(item);
        return super.onOptionsItemSelected(item);
    }
}
