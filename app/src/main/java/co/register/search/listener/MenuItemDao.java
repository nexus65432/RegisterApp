package co.register.search.listener;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import co.register.search.model.MenuItem;
import io.reactivex.Single;

@Dao
public interface MenuItemDao {

    @Query("SELECT * FROM MenuItem ORDER BY ID")
    Single<List<MenuItem>> loadAllMenuItems();

    @Insert
    void insertMenuItem(MenuItem person);

    @Update
    void updateMenuItem(MenuItem person);

    @Delete
    void deleteMenuItem(MenuItem person);

    // This query is to show only the results which are present
    @Query("SELECT * FROM MenuItem WHERE itemName LIKE :query AND isAvailable = :isPresent")
    Single<List<MenuItem>> findByMenuItemName(String query, int isPresent);

//     This query is to show all results which matchs query
//    @Query("SELECT * FROM MenuItem WHERE itemName LIKE :query ")
//    Single<List<MenuItem>> findByMenuItemName(String query);
}
