package com.gelort.studymvp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gelort.studymvp.R;
import com.gelort.studymvp.ui.fragments.ReposListFragment;

public class RepositoriesListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {

        Bundle bundle = getIntent().getExtras();

        ReposListFragment fragment = new ReposListFragment();

        if (bundle != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }
}
