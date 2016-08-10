package com.gelort.studymvp.presenters;

import android.os.Bundle;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by gelort on 05.08.2016.
 */

public abstract class BasePresenter<T> implements ILifePresenter {
    protected CompositeSubscription mCompositeSubscription;

    protected T mView;

    public void setView(T view) {
        this.mView = view;
    }

    public BasePresenter() {
        mCompositeSubscription = new CompositeSubscription();
    }

    public void addSubscription(Subscription subscription) {
        mCompositeSubscription.add(subscription);
    }

    public void unSubscriptions() {
        mCompositeSubscription.unsubscribe();
    }

    @Override
    public void onDestroy() {
        unSubscriptions();
    }
}
