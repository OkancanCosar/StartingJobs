package com.okan.startqueue.contentmanager;

import com.okan.startqueue.contentmanager.startingJobs.FirstJob;
import com.okan.startqueue.contentmanager.startingJobs.SecondJob;
import com.okan.startqueue.util.LLog;

public class Chef implements Runnable {

    private static final String TAG = "üChef";

    @Override
    public void run() {
        while (true) {

            if (!ContentManager._startingJobQueue.isEmpty()) {
                /* Listede eleman var */

                Object mObject = ContentManager._startingJobQueue.get(0);

                /*
                 * TODO todo TODO todo TODO todo TODO todo TODO todo
                 *              MAKE IT BETTER
                 *              MAKE IT BETTER
                 * TODO todo TODO todo TODO todo TODO todo TODO todo
                 */
                if (FirstJob.class.isInstance(mObject)) {
                    FirstJob firstJob = FirstJob.class.cast(mObject);
                    if (firstJob.isInQueue()) {
                        firstJob.runTheJob();
                    } else if (firstJob.isFinished()) {
                        ContentManager._startingJobQueue.remove(mObject);
                    }
                } else if (SecondJob.class.isInstance(mObject)) {
                    SecondJob secondJob = SecondJob.class.cast(mObject);
                    if (secondJob.isInQueue()) {
                        secondJob.runTheJob();
                    } else if (secondJob.isFinished()) {
                        ContentManager._startingJobQueue.remove(mObject);
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                LLog.e(TAG, Chef.class.getEnclosingMethod().getName() + ":" + e.toString());
            }
        }
    }
}

