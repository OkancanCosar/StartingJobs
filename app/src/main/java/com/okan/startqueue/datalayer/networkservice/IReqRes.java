package com.okan.startqueue.datalayer.networkservice;

import com.okan.startqueue.datalayer.entities.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IReqRes {

    @GET("/api/users")
    Call<List<UserModel>> getUsers();

    @POST("/api/users")
    void saveUsers(UserModel... userModels);

    @DELETE("/api/users")
    void deleteUsers(UserModel... userModels);
}
