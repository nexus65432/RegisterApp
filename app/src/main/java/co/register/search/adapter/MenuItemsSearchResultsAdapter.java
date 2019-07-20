package co.register.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.register.search.R;
import co.register.search.model.ItemViewHolder;
import co.register.search.model.MenuItem;

/**
 * Implements a simple Adapter for a RecyclerView.
 */
public class MenuItemsSearchResultsAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<MenuItem> mMenuItem;

    public MenuItemsSearchResultsAdapter(List<MenuItem> items) {
        mMenuItem = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final MenuItem item = mMenuItem.get(position);
        holder.menuItemName.setText(item.getItemName());
        holder.menuItemPrice.setText(item.getItemPrice());
        // This is enhancements, which I added
        //holder.menuItemPrice.setText(item.getItemPrice() + " " + ((item.getIsAvailable() == 1) ? "[Available]" : "[Not Available]" ));
    }

    @Override
    public int getItemCount() {
        if (mMenuItem != null && mMenuItem.size() > 0) {
            return mMenuItem.size();
        } else {
            return 0;
        }
    }

    public void updateAdapter(List<MenuItem> items) {
        mMenuItem = items;
    }
}


