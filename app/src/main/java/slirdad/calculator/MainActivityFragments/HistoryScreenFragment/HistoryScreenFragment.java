package slirdad.calculator.MainActivityFragments.HistoryScreenFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import slirdad.calculator.R;

public class HistoryScreenFragment extends Fragment {
    private final MenuItem item;

    public HistoryScreenFragment(MenuItem item) {
        this.item = item;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.history_screen_fragment, container, false);

        HistoryScreenViewHolder viewHolder = new HistoryScreenViewHolder(view);
        HistoryScreenLogicHolder logicHolder = new HistoryScreenLogicHolder(getContext());

        viewHolder.getRecyclerView().setAdapter(logicHolder.getAdapter());

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        item.setVisible(true);
    }
}
