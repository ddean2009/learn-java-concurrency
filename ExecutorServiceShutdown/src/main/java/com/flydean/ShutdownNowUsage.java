package com.flydean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version ShutdownNowUsage,  2020/3/25 7:56 下午
 */
public class ShutdownNowUsage {

    public void useShutdownNow() throws InterruptedException {
        TrackingExecutor trackingExecutor=new TrackingExecutor(Executors.newCachedThreadPool());

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        trackingExecutor.submit(runnableTask);
        List<Runnable> notrunList=trackingExecutor.shutdownNow();
        if(trackingExecutor.awaitTermination(800, TimeUnit.SECONDS)){
            List<Runnable> runButCancelledList= trackingExecutor.getCancelledTask();
        }
    }
}
