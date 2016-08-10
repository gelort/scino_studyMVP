package com.gelort.studymvp.di.module;

import com.gelort.studymvp.common.Constants;
import com.gelort.studymvp.data.IRestApi;
import com.gelort.studymvp.model.RepositoryModel;
import com.gelort.studymvp.presenters.ReposListPresenter;
import com.gelort.studymvp.presenters.SearchRepositoryPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gelort on 05.08.2016.
 */

@Module
public class ApplicationModule  {

    @Provides
    @Singleton
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    public IRestApi provideRestApi(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       return  retrofit.create(IRestApi.class);
    }

    @Provides
    @Singleton
    public ReposListPresenter provideReposListPresenter() {
        return new ReposListPresenter();
    }

    @Provides
    @Singleton
    public SearchRepositoryPresenter provideSearchRepositoryPresenter() {
        return new SearchRepositoryPresenter();
    }

    @Provides
    @Singleton
    public RepositoryModel provideRepositoryModel() {
        return new RepositoryModel();
    }
}
