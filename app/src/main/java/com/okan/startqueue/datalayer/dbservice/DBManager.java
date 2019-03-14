package com.okan.startqueue.datalayer.dbservice;

import android.content.Context;

import com.okan.startqueue.JobModel;
import com.okan.startqueue.contentmanager.startingJobs.FirstJob;
import com.okan.startqueue.contentmanager.startingJobs.SecondJob;
import com.okan.startqueue.datalayer.entities.AlbumModel;
import com.okan.startqueue.datalayer.entities.PostModel;
import com.okan.startqueue.util.LLog;

import java.util.List;

public class DBManager {

    private static final String TAG = "üDBManager";

    private Context _context;
    private AppDatabase appDatabase;

    public DBManager(Context context) {
        this._context = context;
        appDatabase = AppDatabase.getAppDatabase(context);
    }


    public boolean savePosts(FirstJob firstJob, final List<PostModel> responseList) {

        firstJob.setJobStatus(JobModel.JobStatus.START_DB_SAVE);
        try {
            new Thread() {
                @Override
                public void run() {
                    appDatabase.postDao().insertPosts(responseList);
                }
            }.start();
        } catch (Exception e) {
            LLog.e(TAG, DBManager.class.getEnclosingMethod().getName() + ":" + e.toString());
            return false;
        }
        firstJob.setJobStatus(JobModel.JobStatus.FINISH_DB_SAVE);

        return true;
    }

    public boolean saveAlbums(SecondJob secondJob, final List<AlbumModel> responseList) {

        secondJob.setJobStatus(JobModel.JobStatus.START_DB_SAVE);

        try {
            new Thread() {
                @Override
                public void run() {
                    appDatabase.albumDao().insertAlbum(responseList);
                }
            }.start();
        } catch (Exception e) {
            LLog.e(TAG, DBManager.class.getEnclosingMethod().getName() + ":" + e.toString());
            return false;
        }
        secondJob.setJobStatus(JobModel.JobStatus.FINISH_DB_SAVE);
        return true;
    }
}
