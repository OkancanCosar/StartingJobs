package com.okan.startqueue.contentmanager;

import android.content.Context;

import com.okan.startqueue.contentmanager.startingJobs.FirstJob;
import com.okan.startqueue.contentmanager.startingJobs.SecondJob;
import com.okan.startqueue.datalayer.DataLayer;
import com.okan.startqueue.datalayer.entities.AlbumModel;
import com.okan.startqueue.datalayer.entities.PostModel;
import com.okan.startqueue.util.LLog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ContentManager {

    private static final String TAG = "üContentManager";

    public static ArrayList<Object> _startingJobQueue = new ArrayList<>();
    private Context _context;
    private DataLayer _dataLayer;

    public ContentManager(Context context) {
        this._context = context;
        this._dataLayer = new DataLayer(_context);
    }

    public Context get_context() {
        return _context;
    }

    public boolean initiationForStartingJobs() {
        try {
            new Thread(new Chef()).start();
        } catch (Exception e) {
            LLog.e(TAG, ContentManager.class.getEnclosingMethod().getName() + ":" + e.toString());
            return false;
        }
        return true;
    }

    public boolean addSomeJobs() {
        try {
            _startingJobQueue.add(new FirstJob(ContentManager.this));
            _startingJobQueue.add(new SecondJob(ContentManager.this));
        } catch (Exception e) {
            LLog.e(TAG, ContentManager.class.getEnclosingMethod().getName() + ":" + e.toString());
            return false;
        }
        return true;
    }

    public Call<List<PostModel>> getPostsCall() {
        return _dataLayer.getPostsCall();
    }

    public Call<List<AlbumModel>> getAlbumsCall() {
        return _dataLayer.getAlbumsCall();
    }

    public boolean savePosts(FirstJob firstJob, List<PostModel> responseList) {
        return _dataLayer.savePosts(firstJob, responseList);
    }

    public boolean saveAlbums(SecondJob secondJob, List<AlbumModel> responseList) {
        return _dataLayer.saveAlbums(secondJob, responseList);
    }
}
