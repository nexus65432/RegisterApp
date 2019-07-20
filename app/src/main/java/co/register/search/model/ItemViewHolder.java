package co.register.search.model;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import co.register.search.R;

/**
 * Custom view holder with a text view and two buttons.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    public final TextView menuItemName;
    public final TextView menuItemPrice;

    public ItemViewHolder(View itemView) {
        super(itemView);
        menuItemName = itemView.findViewById(R.id.menu_item_label);
        menuItemPrice = itemView.findViewById(R.id.menu_item_price);
    }
}
