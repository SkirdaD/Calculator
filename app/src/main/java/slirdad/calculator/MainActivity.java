package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import slirdad.calculator.Data.DataBase.HistoryDataBaseManager;

public class MainActivity extends AppCompatActivity {

    private MainActivityLogicHolder logicHolder;
    private HistoryDataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseManager = new HistoryDataBaseManager(this);
        logicHolder= new MainActivityLogicHolder(getSupportFragmentManager(), dataBaseManager);

        logicHolder.showCalculatorFragment();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.aboutApp) {
            logicHolder.showAboutAppFragment(item);
        } else if (item.getItemId() == R.id.training) {
            logicHolder.showCalculatorTrainingFragment(item);
        } else if (item.getItemId() == R.id.operationHistory) {
            logicHolder.showHistoryScreenFragment(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataBaseManager.openDataBase();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataBaseManager.closeDatabase();
    }
}
