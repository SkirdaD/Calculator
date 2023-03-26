package slirdad.calculator.MainActivityFragments.CalculatorFragment.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import slirdad.calculator.Data.DataBase.HistoryDataBaseManager;
import slirdad.calculator.R;


public class CalculatorFragment extends Fragment {

    private final HistoryDataBaseManager dataBaseManager;

    public CalculatorFragment(HistoryDataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.calculator_fragment, container, false);

        final CalculatorFragmentViewHolder viewHolder = new CalculatorFragmentViewHolder(view);
        final CalculatorFragmentLogicHolder logicHolder =
                new CalculatorFragmentLogicHolder(viewHolder, dataBaseManager);

        for (Button button : viewHolder.getNumButtons()) {
            button.setOnClickListener(logicHolder::putNum);
        }
        viewHolder.getPlusButton().setOnClickListener(logicHolder::summarize);
        viewHolder.getMinusButton().setOnClickListener(logicHolder::subtract);
        viewHolder.getMultiplicationSignButton().setOnClickListener(logicHolder::multiply);
        viewHolder.getDivisionSignButton().setOnClickListener(logicHolder::divide);
        viewHolder.getEqualMarkButton().setOnClickListener(logicHolder::equal);

        viewHolder.getAllCleanButton().setOnClickListener(logicHolder::cleanAll);
        viewHolder.getPointButton().setOnClickListener(logicHolder::putDecimalPoint);
        viewHolder.getSignChangeButton().setOnClickListener(logicHolder::changeSign);
        viewHolder.getDeleteLastCharacterButton().setOnClickListener(logicHolder::deleteLastChar);

        return view;
    }
}
