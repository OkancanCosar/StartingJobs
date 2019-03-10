package com.okan.startqueue.Jobs;

import android.os.AsyncTask;
import android.util.Log;

import com.okan.startqueue.JobModel;

public class SecondJob extends AsyncTask<String, Void, String> implements JobModel.IJob {

    private static final String TAG = "üSecondJob";
    private JobModel.JobStatus jobStatus;

    public SecondJob() {
        setJobStatus(JobModel.JobStatus.INQUEUE);
    }

    @Override
    protected String doInBackground(String... params) {

        setJobStatus(JobModel.JobStatus.DOINBACKGROUND);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        setJobStatus(JobModel.JobStatus.DOINBACKGROUND_END);
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        //Log.d("ü", result);

        setJobStatus(JobModel.JobStatus.ONPOSTEXECUTE);

        try {

            Thread.sleep(1000);
        } catch (Exception e) {

        }
        setJobStatus(JobModel.JobStatus.ONPOSTEXECUTE_END);
        try {

            Thread.sleep(3000);
        } catch (Exception e) {

        }
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