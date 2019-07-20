package co.register.search.listener;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import co.register.search.model.MenuItem;

/**
 * This interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MainView {

    /**
     * Add photos to the adapter
     * @param results
     */
    void addNewItemsToList(@NonNull List<MenuItem> results);

    /**
     * Clear the list and present user with right full information
     */
    void showEmptyList();
}
