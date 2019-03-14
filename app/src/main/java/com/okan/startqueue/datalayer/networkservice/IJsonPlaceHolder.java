package com.okan.startqueue.datalayer.networkservice;

import com.okan.startqueue.datalayer.entities.AlbumModel;
import com.okan.startqueue.datalayer.entities.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IJsonPlaceHolder {


    @GET("/albums")
    Call<List<AlbumModel>> getAlbums();

    @GET("/posts")
    Call<List<PostModel>> getPosts();


}
