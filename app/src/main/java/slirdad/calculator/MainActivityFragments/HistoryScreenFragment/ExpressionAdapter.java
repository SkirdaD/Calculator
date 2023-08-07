package slirdad.calculator.MainActivityFragments.HistoryScreenFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import slirdad.calculator.MainActivityFragments.HistoryScreenFragment.DataBase.Expression;
import slirdad.calculator.R;

public class ExpressionAdapter extends RecyclerView.Adapter<ExpressionAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Expression> expressions;

    ExpressionAdapter(Context context, List<Expression> expressions) {
        this.expressions = expressions;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ExpressionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpressionAdapter.ViewHolder holder, int position) {
        Expression expression = expressions.get(position);
        holder.expressionResult.setText(expression.getExpressionResult());
        holder.expressionBody.setText(expression.getExpressionBody());
    }

    @Override
    public int getItemCount() {
        return expressions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView expressionResult, expressionBody;

        ViewHolder(View view) {
            super(view);
            expressionResult = view.findViewById(R.id.expressionResult);
            expressionBody = view.findViewById(R.id.expressionBody);
        }
    }
}
