package slirdad.calculator.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import slirdad.calculator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        final MainActivityViewHolder holder = new MainActivityViewHolder(this);
        final OnCLMainActivityFactory factory = new OnCLMainActivityFactory(holder);

        holder.getPlusButton().setOnClickListener(factory);
        holder.getMinusButton().setOnClickListener(factory);
    }
}
