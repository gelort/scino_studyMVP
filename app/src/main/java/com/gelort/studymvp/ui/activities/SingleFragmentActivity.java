package com.gelort.studymvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gelort.studymvp.R;
import com.gelort.studymvp.ui.fragments.OnFragmentResultListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Name on 31/08/15.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity implements OnFragmentResultListener {

    protected Bundle mBundle;

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        handleIntent(getIntent());

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            addFragment();
        }
    }

    protected abstract Fragment getFragment();

    protected void handleIntent(Intent intent) {
        mBundle = intent.getExtras();
    }

    protected void addFragment() {
        replaceFragment(getFragment(), false);
    }

    protected Fragment findFragmentByClass(Class fragmentClass) {
        return getSupportFragmentManager().findFragmentByTag(fragmentClass.getName());
    }

    protected void replaceFragment(Fragment showFragment, boolean addToBackStack) {
        if (showFragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, showFragment, showFragment.getClass().getName());

            if (addToBackStack) fragmentTransaction.addToBackStack(showFragment.getClass().getName());

            fragmentTransaction.commit();
        }
    }

    protected Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    protected void setDisplayHomeAsUpEnabled(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }

    protected void setHomeAsUpIndicator(int resId) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    protected void hideActionBar() {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home: {
                onBackPressed();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClose() {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void onResult(Intent intent) {
        setResult(RESULT_OK, intent);
        finish();
    }
}
