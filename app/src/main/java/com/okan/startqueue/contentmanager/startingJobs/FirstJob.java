package com.okan.startqueue.contentmanager.startingJobs;

import android.os.AsyncTask;
import android.util.Log;

import com.okan.startqueue.JobModel;
import com.okan.startqueue.contentmanager.ContentManager;
import com.okan.startqueue.datalayer.entities.PostModel;
import com.okan.startqueue.util.LLog;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class FirstJob extends AsyncTask<String, Void, String> implements JobModel.IJob {

    private static final String TAG = "üFirstJob";
    private JobModel.JobStatus jobStatus;
    private ContentManager _contentManager;

    public FirstJob(ContentManager contentManager) {
        this._contentManager = contentManager;
        setJobStatus(JobModel.JobStatus.INQUEUE);
    }

    @Override
    protected String doInBackground(String... params) {

        setJobStatus(JobModel.JobStatus.DOINBACKGROUND);

        try {
            Response<List<PostModel>> response = _contentManager.getPostsCall().execute();

            _contentManager.savePosts(FirstJob.this, response.body());

        } catch (IOException e) {
            LLog.e(TAG, FirstJob.class.getEnclosingMethod().getName() + ":" + e.toString());
        }

        setJobStatus(JobModel.JobStatus.DOINBACKGROUND_END);
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        //Log.d("ü", result);

        setJobStatus(JobModel.JobStatus.ONPOSTEXECUTE);
        setJobStatus(JobModel.JobStatus.FINISHED);

    }

    @Override
    public void setJobStatus(JobModel.JobStatus jobStatus) {
        Log.i(TAG, "-> " + jobStatus.name());
        this.jobStatus = jobStatus;
    }

    @Override
    public JobModel.JobStatus getJobStatus() {
        return jobStatus;
    }

    @Override
    public boolean isInQueue() {
        return jobStatus == JobModel.JobStatus.INQUEUE;
    }

    @Override
    public boolean isFinished() {
        return jobStatus == JobModel.JobStatus.FINISHED;
    }

    @Override
    public void runTheJob() {
        this.execute();
    }
}