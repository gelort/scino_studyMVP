package com.gelort.studymvp.ui.activities;

import android.support.v4.app.Fragment;

import com.gelort.studymvp.ui.fragments.SearchRepositoryFragment;

/**
 * Created by gelort on 10.08.2016.
 */

public class SearchRepositoryActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new SearchRepositoryFragment();
    }
}
