package com.okan.startqueue;

public class JobModel {

    public enum JobStatus {
        INQUEUE,
        STARTED,
        DOINBACKGROUND,
        DOINBACKGROUND_END,
        ONPOSTEXECUTE,
        ONPOSTEXECUTE_END,
        FINISHED,

        START_DB_SAVE,
        FINISH_DB_SAVE
    }

    public interface IJob {
        void setJobStatus(JobStatus jobStatus);

        JobStatus getJobStatus();

        boolean isInQueue();

        boolean isFinished();

        void runTheJob();
    }


}
