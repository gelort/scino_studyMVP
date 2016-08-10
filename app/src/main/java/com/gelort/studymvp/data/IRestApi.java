package com.gelort.studymvp.data;

import com.gelort.studymvp.data.entity.Repository;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gelort on 05.08.2016.
 */

public interface IRestApi {

    @GET("users/{user}/repos")
    Observable<List<Repository>> getRepositories(@Path("user") String user);
}
