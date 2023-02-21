package slirdad.calculator;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyApplication {

    public static void getMyApplication(AppCompatActivity activity) {
        final MainActivityViewHolder holder =
                Factory.getMainActivityViewHolder(activity);

        holder.getMainTextView().setText("0"); //пока нет шареда

        for (Button button : holder.getNumButtons()) {
            button.setOnClickListener(
                    Factory.getOnNumberButtonsClickListener(activity));
        }
        holder.getPlusButton().setOnClickListener(Factory.getOnPlusButtonClickListener(activity));
        holder.getMinusButton().setOnClickListener(
                Factory.getOnMinusButtonClickListener(activity));
        holder.getMultiplicationSignButton().setOnClickListener(
                Factory.getOnMultiplicationButtonClickListener(activity));
        holder.getDivisionSignButton().setOnClickListener(
                Factory.getOnDivisionButtonClickListener(activity));
        holder.getDeleteLastCharacterButton().setOnClickListener(
                Factory.getOnDeleteLastCharButtonClickListener(activity));
        holder.getSignChangeButton().setOnClickListener(
                Factory.getOnSignChangeButtonClickListener(activity));
        holder.getEqualMarkButton().setOnClickListener(
                Factory.getOnEqualMarkButtonClickListener(activity));
        holder.getAllCleanButton().setOnClickListener(
                Factory.getOnAllCleanButtonClickListener(activity));
        holder.getPointButton().setOnClickListener(Factory.getOnPointButtonClickListener(activity));
    }
}
