package com.gelort.studymvp.presenters;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.gelort.studymvp.ui.activities.RepositoriesListActivity;
import com.gelort.studymvp.ui.fragments.ReposListFragment;
import com.gelort.studymvp.view.SearchRepositoryView;

/**
 * Created by gelort on 10.08.2016.
 */

public class SearchRepositoryPresenter extends BasePresenter<SearchRepositoryView> {

    @Override
    public void onCreateView(Bundle saveInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void searchRepository(String repository) {
        if (isValidRepositoryName(repository)) {
            Intent intent = new Intent(mView.getContext(), RepositoriesListActivity.class);
            intent.putExtra(ReposListFragment.EXTRA_PARAM_REPOSITORY_NAME, repository);
            mView.getContext().startActivity(intent);
        }
    }

    private boolean isValidRepositoryName(String name) {
        return !TextUtils.isEmpty(name);
    }
}
