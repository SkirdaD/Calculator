package slirdad.calculator.MainActivityFragments.CalculationTrainingFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import slirdad.calculator.R;

public class CalculationTrainingFragment extends Fragment {
    private final MenuItem item;

    public CalculationTrainingFragment(MenuItem item) {
        this.item = item;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculation_training_fragment, container, false);

        CalculationTrainingViewHolder viewHolder = new CalculationTrainingViewHolder(view);
        CalculationTrainingLogicHolder logicHolder = new CalculationTrainingLogicHolder(viewHolder);

        logicHolder.setRandomValues(view);

        viewHolder.getRefreshButton().setOnClickListener(logicHolder::setRandomValues);
        viewHolder.getHelpMeCountButton().setOnClickListener(logicHolder::showAnswer);
        viewHolder.getOkButton().setOnClickListener(logicHolder::checkAnswer);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        item.setVisible(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        item.setVisible(true);
    }
}
