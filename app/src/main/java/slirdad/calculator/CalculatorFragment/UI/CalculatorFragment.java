package slirdad.calculator.CalculatorFragment.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import slirdad.calculator.R;


public class CalculatorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator_fragment, container, false);

        CalculatorFragmentViewHolder holder = new CalculatorFragmentViewHolder(view);
        OnCLFactory factory = new OnCLFactory(holder);

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(factory.getOnNumberButtonsClickListener());
        }
        holder.getPlusButton().setOnClickListener(factory.getOnPlusButtonClickListener());
        holder.getMinusButton().setOnClickListener(factory.getOnMinusButtonClickListener());
        holder.getMultiplicationSignButton().setOnClickListener(
                factory.getOnMultiplicationButtonClickListener());
        holder.getDivisionSignButton().setOnClickListener(
                factory.getOnDivisionButtonClickListener());
        holder.getDeleteLastCharacterButton().setOnClickListener(
                factory.getOnDeleteLastCharButtonClickListener());
        holder.getSignChangeButton().setOnClickListener(
                factory.getOnSignChangeButtonClickListener());
        holder.getEqualMarkButton().setOnClickListener(factory.getOnEqualMarkButtonClickListener());
        holder.getAllCleanButton().setOnClickListener(factory.getOnAllCleanButtonClickListener());
        holder.getPointButton().setOnClickListener(factory.getOnPointButtonClickListener());

        return view;
    }
}
