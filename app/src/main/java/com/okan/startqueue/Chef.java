package com.okan.startqueue;

import com.okan.startqueue.Jobs.FirstJob;
import com.okan.startqueue.Jobs.SecondJob;

import java.util.ArrayList;

public class Chef implements Runnable {

    private static final String TAG = "üChef";

    public static ArrayList<Object> mQueue = new ArrayList<>();

    @Override
    public void run() {
        while (true) {

            if (!mQueue.isEmpty()) {
                /* Listede eleman var */

                Object mObject = mQueue.get(0);

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
                        mQueue.remove(mObject);
                    }
                } else if (SecondJob.class.isInstance(mObject)) {
                    SecondJob secondJob = SecondJob.class.cast(mObject);
                    if (secondJob.isInQueue()) {
                        secondJob.runTheJob();
                    } else if (secondJob.isFinished()) {
                        mQueue.remove(mObject);
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }
        }
    }
}

