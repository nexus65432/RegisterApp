package co.register.search.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import co.register.search.R;
import co.register.search.adapter.MenuItemsSearchResultsAdapter;
import co.register.search.controller.MainPresenterImpl;
import co.register.search.listener.MainView;
import co.register.search.model.MenuItem;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";

    private EditText mEditWordView;
    private TextView mResultsStatus;
    private RecyclerView mRecyclerView;
    private MenuItemsSearchResultsAdapter mMenuItemsSearchResultsAdapter;
    private MainPresenterImpl mMainPresenterImpl;
    private boolean isUserTyping = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditWordView = findViewById(R.id.search_word);
        mEditWordView.addTextChangedListener(mEnterListener);
        mRecyclerView = findViewById(R.id.recyclerview);
        mResultsStatus = findViewById(R.id.error_message);
        setRecyclerView();
        mMainPresenterImpl = new MainPresenterImpl(MainActivity.this);
    }

    private void setRecyclerView() {
        mMenuItemsSearchResultsAdapter = new MenuItemsSearchResultsAdapter(null);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLayoutManager.getOrientation());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mMenuItemsSearchResultsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenterImpl.onAttach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenterImpl.prepareToExit();
    }

    private TextWatcher mEnterListener = new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                }

                @Override
                public void beforeTextChanged(CharSequence s,
                                              int start,
                                              int count,
                                              int after) {
                    if (count < after) {
                        isUserTyping = true;
                    } else {
                        isUserTyping = false;
                    }
                }

                @Override
                public void onTextChanged(CharSequence s,
                                          int start,
                                          int before,
                                          int count) {
                    if (isUserTyping && s.length() > 3) {
                        mMainPresenterImpl.getMatchingMenuItems(s.toString());
                    }
                }
            };

    @Override
    public void addNewItemsToList(@NonNull List<MenuItem> results) {
        Log.d(TAG, "Adding Results to List");
        if (results != null) {
            mResultsStatus.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mMenuItemsSearchResultsAdapter.updateAdapter(results);
            mMenuItemsSearchResultsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showEmptyList() {
        Log.d(TAG, "No Results Available");
        mRecyclerView.setVisibility(View.GONE);
        mMenuItemsSearchResultsAdapter.updateAdapter(null);
        mResultsStatus.setVisibility(View.VISIBLE);
        if (isUserTyping) {
            mResultsStatus.setText(R.string.no_results_message);
        }
    }

}