package com.gelort.studymvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gelort.studymvp.R;
import com.gelort.studymvp.SAApplication;
import com.gelort.studymvp.data.entity.Repository;
import com.gelort.studymvp.presenters.ReposListPresenter;
import com.gelort.studymvp.ui.adapters.RepositoryAdapter;
import com.gelort.studymvp.view.ReposListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gelort on 05.08.2016.
 */

public class ReposListFragment extends Fragment implements ReposListView {
    public static final String EXTRA_PARAM_REPOSITORY_NAME = "ReposListFragment.RepositoryName";

    @BindView(R.id.repository_recycler_view)
    protected RecyclerView mRepositoryRecyclerView;

    @Inject
    protected ReposListPresenter mPresenter;

    private RepositoryAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SAApplication.getApplicationComponent().inject(this);

        Bundle bundle = getArguments();

        if (bundle != null) {
            mPresenter.setRepositoryName(bundle.getString(EXTRA_PARAM_REPOSITORY_NAME, ""));
        }

        mPresenter.onCreateView(savedInstanceState);
        mPresenter.setView(this);

        mAdapter = new RepositoryAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repositories_fragment, container, false);

        ButterKnife.bind(this, view);

        mPresenter.onCreateView(savedInstanceState);

        mRepositoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRepositoryRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void showRepositories(List<Repository> repositories) {
        mAdapter.setItems(repositories);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();

        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mPresenter.onStart();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();

        super.onDestroy();
    }
}
