package com.gelort.studymvp.presenters;

import android.os.Bundle;

import com.gelort.studymvp.SAApplication;
import com.gelort.studymvp.data.entity.Repository;
import com.gelort.studymvp.model.RepositoryModel;
import com.gelort.studymvp.view.ReposListView;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gelort on 05.08.2016.
 */

public class ReposListPresenter extends BasePresenter<ReposListView> {
    private String mRepositoryName;

    @Inject
    protected RepositoryModel mRepositoryModel;

    public ReposListPresenter() {
        SAApplication.getApplicationComponent().inject(this);
    }

    public void setRepositoryName(String repositoryName) {
        this.mRepositoryName = repositoryName;
    }

    @Override
    public void onCreateView(Bundle saveInstance) {
      Subscription subscription = mRepositoryModel.getRepositories(mRepositoryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Repository>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e, "error load repositories");
                    }

                    @Override
                    public void onNext(List<Repository> repositories) {
                        mView.showRepositories(repositories);
                    }
                });

        addSubscription(subscription);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
