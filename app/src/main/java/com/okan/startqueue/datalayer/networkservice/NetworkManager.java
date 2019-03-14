package com.okan.startqueue.datalayer.networkservice;

import android.content.Context;

import com.okan.startqueue.datalayer.entities.AlbumModel;
import com.okan.startqueue.datalayer.entities.PostModel;

import java.util.List;

import retrofit2.Call;

public class NetworkManager {

    private static final String TAG = "üNetworkManager";
    private Context _context;

    private IJsonPlaceHolder ijsonPlaceHolder;
    private IReqRes iReqRes;


    public NetworkManager(Context context) {
        this._context = context;

        iReqRes = Retro.getClient(Retro.RetroClient.REQRES).create(IReqRes.class);
        ijsonPlaceHolder = Retro.getClient(Retro.RetroClient.JSONPLACEHOLDER).create(IJsonPlaceHolder.class);

    }

    public Call<List<PostModel>> getPostsCall() {
        return ijsonPlaceHolder.getPosts();
    }

    public Call<List<AlbumModel>> getAlbumsCall() {
        return ijsonPlaceHolder.getAlbums();
    }
}
