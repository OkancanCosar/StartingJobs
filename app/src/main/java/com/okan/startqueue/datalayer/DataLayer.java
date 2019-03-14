package com.okan.startqueue.datalayer;

import android.content.Context;

import com.okan.startqueue.contentmanager.startingJobs.FirstJob;
import com.okan.startqueue.contentmanager.startingJobs.SecondJob;
import com.okan.startqueue.datalayer.dbservice.DBManager;
import com.okan.startqueue.datalayer.entities.AlbumModel;
import com.okan.startqueue.datalayer.entities.PostModel;
import com.okan.startqueue.datalayer.networkservice.NetworkManager;

import java.util.List;

import retrofit2.Call;

public class DataLayer {

    private static final String TAG = "üDataLayer";
    private Context _context;
    private NetworkManager _networkManager;
    private DBManager _dbManager;

    public DataLayer(Context context) {
        this._context = context;
        _networkManager = new NetworkManager(_context);
        _dbManager = new DBManager(_context);
    }

    public Call<List<PostModel>> getPostsCall() {
        return _networkManager.getPostsCall();
    }

    public Call<List<AlbumModel>> getAlbumsCall() {
        return _networkManager.getAlbumsCall();
    }

    public boolean savePosts(FirstJob firstJob, List<PostModel> responseList) {
        return _dbManager.savePosts(firstJob, responseList);
    }

    public boolean saveAlbums(SecondJob secondJob, List<AlbumModel> responseList) {
        return _dbManager.saveAlbums(secondJob, responseList);
    }
}
