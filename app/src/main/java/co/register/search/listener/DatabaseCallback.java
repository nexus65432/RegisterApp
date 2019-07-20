package co.register.search.listener;

import java.util.List;

import co.register.search.model.MenuItem;


public interface DatabaseCallback {

    /**
     * Pass the fetched menuItems to the caller.
     * @param menuList
     */
    void onMenuItemLoaded(List<MenuItem> menuList);
}
