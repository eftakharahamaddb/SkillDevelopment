package com.skill.develoment.skilldevelopment.businesslogic;

import com.skill.develoment.skilldevelopment.pojos.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkApi {
    @GET("users/{id}/repos")
    Call<List<Repo>> getRepoList(
            @Path("id") String userId);

    @GET("users/{id}/repos")
    Observable<List<Repo>> getRepoListObservable(
            @Path("id") String id);
}
