package com.gelort.studymvp.di.component;

import com.gelort.studymvp.di.module.ApplicationModule;
import com.gelort.studymvp.model.RepositoryModel;
import com.gelort.studymvp.presenters.ReposListPresenter;
import com.gelort.studymvp.presenters.SearchRepositoryPresenter;
import com.gelort.studymvp.ui.fragments.ReposListFragment;
import com.gelort.studymvp.ui.fragments.SearchRepositoryFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gelort on 05.08.2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ReposListFragment fragment);

    void inject(RepositoryModel model);

    void inject(ReposListPresenter presenter);

    void inject(SearchRepositoryFragment fragment);
}
