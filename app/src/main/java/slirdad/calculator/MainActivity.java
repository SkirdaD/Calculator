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
        // здесь тебе он зачем? он на этом уровне что-то делает?
        HistoryDataBaseManager dataBaseManager = new HistoryDataBaseManager(this);
        // раз тебе нужен контекст чтобы создать фрагмент менеджер и бд менеджер,
        // то передавай контекст в MainActivityLogicHolder и там уже создавай что тебе надо,
        // активити будет чище, это и будет "почти" тот самый inject(this) про который везде пишут
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
