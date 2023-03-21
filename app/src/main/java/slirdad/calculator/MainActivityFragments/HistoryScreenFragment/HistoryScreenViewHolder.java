package slirdad.calculator.MainActivityFragments.HistoryScreenFragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import slirdad.calculator.R;

class HistoryScreenViewHolder {

    private final RecyclerView recyclerView;

    HistoryScreenViewHolder(View view) {
        recyclerView = view.findViewById(R.id.historyList);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
