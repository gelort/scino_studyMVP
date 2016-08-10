package com.gelort.studymvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gelort.studymvp.R;
import com.gelort.studymvp.SAApplication;
import com.gelort.studymvp.presenters.SearchRepositoryPresenter;
import com.gelort.studymvp.view.SearchRepositoryView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gelort on 10.08.2016.
 */

public class SearchRepositoryFragment extends Fragment implements SearchRepositoryView {

    @BindView(R.id.user_name)
    protected EditText mSearchRepositoryEditText;

    @Inject
    protected SearchRepositoryPresenter mSearchPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SAApplication.getApplicationComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_repository_fragment, container, false);

        ButterKnife.bind(this, view);

        mSearchPresenter.onCreateView(savedInstanceState);
        mSearchPresenter.setView(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSearchPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mSearchPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSearchPresenter.onDestroy();
    }

    @OnClick(R.id.search)
    public void onRepositorySearch() {
        mSearchPresenter.searchRepository(mSearchRepositoryEditText.getText().toString());
    }
}
