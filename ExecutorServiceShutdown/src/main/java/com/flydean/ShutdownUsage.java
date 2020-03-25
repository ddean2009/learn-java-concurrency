package com.flydean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version ShutdownUsage,  2020/3/25 7:40 下午
 */
public class ShutdownUsage {

    public void useShutdown() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.submit(runnableTask);
        executor.shutdown();
        executor.awaitTermination(800, TimeUnit.MILLISECONDS);
    }
}
