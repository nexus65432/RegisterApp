package co.register.search.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import co.register.search.database.DbHelper;
import co.register.search.listener.DatabaseCallback;
import co.register.search.listener.MainPresenter;
import co.register.search.listener.MainView;
import co.register.search.model.MenuItem;
import io.reactivex.disposables.CompositeDisposable;

/**
 * This class implements the logic which are needed for the UI
 * MainPresenter - controller for MainActivity
 */
public class MainPresenterImpl implements MainPresenter, DatabaseCallback {

    private static final String TAG = "MainPresenterImpl";

    private CompositeDisposable mCompositeDisposable = null;
    private MainView mMainView;
    private DbHelper mDbHelper;

    public MainPresenterImpl(@NonNull Context context) {
        this.mMainView = (MainView) context;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mCompositeDisposable = new CompositeDisposable();
        mDbHelper = DbHelper.getInstance(context);
    }

    @Override
    public void prepareToExit() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void onDetach() {
        mCompositeDisposable = null;
        mMainView = null;
        mDbHelper = null;
    }

    @Override
    public void getMatchingMenuItems(@NonNull String query) {
        Log.d(TAG, "getMatchingMenuItems " + query);
        mDbHelper.getMenuItemsForUserInput(this, query);
    }

    @Override
    public void onMenuItemLoaded(List<MenuItem> menuList) {
        if (menuList != null && menuList.size() > 0) {
            mMainView.addNewItemsToList(menuList);
        } else {
            mMainView.showEmptyList();
        }
    }
}
