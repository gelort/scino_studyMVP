package com.gelort.studymvp.model;

import com.gelort.studymvp.SAApplication;
import com.gelort.studymvp.data.IRestApi;
import com.gelort.studymvp.data.entity.Repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by gelort on 08.08.2016.
 */

public class RepositoryModel {

    @Inject
    protected IRestApi mRestApi;

    public RepositoryModel() {
        SAApplication.getApplicationComponent().inject(this);
    }

    public Observable<List<Repository>> getRepositories(String user) {
        return mRestApi.getRepositories(user);
    }
}
