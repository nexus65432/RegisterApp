package co.register.search.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import co.register.search.controller.RegisterPreference;
import co.register.search.listener.DatabaseCallback;
import co.register.search.model.MenuItem;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DbHelper {

    private static final String TAG = "DbHelper";

    private static DbHelper _instance;
    private AppDatabase db;

    public static DbHelper getInstance(Context context) {
        if (_instance == null) {
            // So we always have one context reference 
            _instance = new DbHelper(context.getApplicationContext());
        }
        return _instance;
    }

    public DbHelper(Context context) {
        db = AppDatabase.getInstance(context);
    }

    public void getMenuItemsForUserInput(final @NonNull DatabaseCallback databaseCallback,
                                         final @NonNull String userQuery) {
        if (TextUtils.isEmpty(userQuery)) {
            return;
        }
        db.menuItemDao().findByMenuItemName("%" + userQuery + "%", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MenuItem>>() {
                    @Override
                    public void accept(@NonNull List<MenuItem> menuItems) throws Exception {
                        databaseCallback.onMenuItemLoaded(menuItems);
                    }
                });
    }

    public void getAllMenuItems(final DatabaseCallback databaseCallback) {
        db.menuItemDao().loadAllMenuItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MenuItem>>() {
            @Override
            public void accept(@NonNull List<MenuItem> users) throws Exception {
                databaseCallback.onMenuItemLoaded(users);
            }
        });
    }

    /**
     * Initialize database with factory shipped Menu Items
     */
    public void initializeDatabaseWithDefaultMenu(final @NonNull Context context) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                initializeDefaultMenuItems();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
                RegisterPreference.getInstance(context).initializeRegister();
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

    /**
     * Default Menu Items....
     */
    private void initializeDefaultMenuItems() {

        Log.d(TAG, "Adding Default Menu Items");

        MenuItem item1 = new MenuItem("Chicken Fingers", "$14.47", 0);
        db.menuItemDao().insertMenuItem(item1);

        MenuItem item2 = new MenuItem("Dr. Pepper Drink", "$3.11", 1);
        db.menuItemDao().insertMenuItem(item2);

        MenuItem item3 = new MenuItem("Coke Drink", "$3.11", 1);
        db.menuItemDao().insertMenuItem(item3);

        MenuItem item4 = new MenuItem("Root Beer Drink", "$3.11", 1);
        db.menuItemDao().insertMenuItem(item4);

        MenuItem item5 = new MenuItem("Pepsi Drink", "$3.11", 0);
        db.menuItemDao().insertMenuItem(item5);

        MenuItem item6 = new MenuItem("Fries", "$1.14", 1);
        db.menuItemDao().insertMenuItem(item6);

        MenuItem item7 = new MenuItem("Fried Chicken Dinner", "$16.67", 1);
        db.menuItemDao().insertMenuItem(item7);

        MenuItem item8 = new MenuItem("Salad", "$8.67", 1);
        db.menuItemDao().insertMenuItem(item8);

        MenuItem item9 = new MenuItem("Tacos", "$14.99", 1);
        db.menuItemDao().insertMenuItem(item9);

        MenuItem item10 = new MenuItem("Bacon Burger", "$12.11", 1);
        db.menuItemDao().insertMenuItem(item10);

        MenuItem item11 = new MenuItem("Brownie", "$5.55", 1);
        db.menuItemDao().insertMenuItem(item11);

        MenuItem item12 = new MenuItem("Ice Cream", "$2.88", 1);
        db.menuItemDao().insertMenuItem(item12);

        MenuItem item13 = new MenuItem("Lobster and Steak", "$25.55", 1);
        db.menuItemDao().insertMenuItem(item13);

        MenuItem item14 = new MenuItem("Lobster", "$12.44", 1);
        db.menuItemDao().insertMenuItem(item14);

        MenuItem item15 = new MenuItem("Sirloin 6 oz.", "$9.99", 1);
        db.menuItemDao().insertMenuItem(item15);

        MenuItem item16 = new MenuItem("Sirloin 6 oz.", "$9.99", 1);
        db.menuItemDao().insertMenuItem(item16);

        MenuItem item17 = new MenuItem("Sirloin 6 oz.", "$9.99", 1);
        db.menuItemDao().insertMenuItem(item17);

        MenuItem item18 = new MenuItem("Sirloin 6 oz.", "$11.99", 1);
        db.menuItemDao().insertMenuItem(item18);

        MenuItem item19 = new MenuItem("Salmon Dinner", "$14.88", 1);
        db.menuItemDao().insertMenuItem(item19);

        MenuItem item20 = new MenuItem("Lamb soup", "$9.0", 0);
        db.menuItemDao().insertMenuItem(item20);

        MenuItem item21 = new MenuItem("Water Drink", "$0.0", 1);
        db.menuItemDao().insertMenuItem(item21);

        MenuItem item22 = new MenuItem("Baby Back Ribs", "$10.67", 1);
        db.menuItemDao().insertMenuItem(item22);

        MenuItem item23 = new MenuItem("Chips & Salsa", "$2.99", 1);
        db.menuItemDao().insertMenuItem(item23);

        MenuItem item24 = new MenuItem("Nachos", "$8.77", 1);
        db.menuItemDao().insertMenuItem(item24);

        MenuItem item25 = new MenuItem("Tomato Soup", "$1.33", 0);
        db.menuItemDao().insertMenuItem(item25);

        MenuItem item26 = new MenuItem("Jumbo Shrimp Plate", "$8.66", 1);
        db.menuItemDao().insertMenuItem(item26);

        MenuItem item27 = new MenuItem("Blueberry Toaster Studels", "$6.55", 1);
        db.menuItemDao().insertMenuItem(item27);

        MenuItem item28 = new MenuItem("Chicken & Waffles", "$14.44", 0);
        db.menuItemDao().insertMenuItem(item28);

        MenuItem item29 = new MenuItem("Jumbo Pancakes", "$9.99", 1);
        db.menuItemDao().insertMenuItem(item29);

        MenuItem item30 = new MenuItem("Corn Beef and eggs", "$12.12", 1);
        db.menuItemDao().insertMenuItem(item30);

        MenuItem item31 = new MenuItem("Mozzarella Sticks", "$9.1", 1);
        db.menuItemDao().insertMenuItem(item31);

        MenuItem item32 = new MenuItem("Mashed Potatoes", "$2.01", 1);
        db.menuItemDao().insertMenuItem(item32);

        MenuItem item33 = new MenuItem("Corn dogs", "$1.77", 0);
        db.menuItemDao().insertMenuItem(item33);

        MenuItem item34 = new MenuItem("Cookies and Ice Cream", "$8.11", 1);
        db.menuItemDao().insertMenuItem(item34);

        MenuItem item35 = new MenuItem("Sweet Tea Drink", "$1.11", 1);
        db.menuItemDao().insertMenuItem(item35);

        MenuItem item36 = new MenuItem("Green Tea Drink", "$0.99", 1);
        db.menuItemDao().insertMenuItem(item36);

        MenuItem item37 = new MenuItem("Chocolate Milk Drink", "$1.44", 1);
        db.menuItemDao().insertMenuItem(item37);

        MenuItem item38 = new MenuItem("Milk Drink", "$1.22", 1);
        db.menuItemDao().insertMenuItem(item38);

        MenuItem item39 = new MenuItem("Hot Chocolate Drink", "$2.0", 1);
        db.menuItemDao().insertMenuItem(item39);

        MenuItem item40 = new MenuItem("Beer Drink", "$4.01", 1);
        db.menuItemDao().insertMenuItem(item40);

        MenuItem item41 = new MenuItem("Vodka Drink", "$5.88", 1);
        db.menuItemDao().insertMenuItem(item41);

        MenuItem item42 = new MenuItem("Whiskey Drink", "$5.88", 1);
        db.menuItemDao().insertMenuItem(item42);

        MenuItem item43 = new MenuItem("White Russian Drink", "$5.88", 1);
        db.menuItemDao().insertMenuItem(item43);
    }

}
