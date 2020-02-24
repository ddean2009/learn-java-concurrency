package com.flydean;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version ScheduledExecutorServiceUsage,  2020/2/24 11:15 下午
 */
public class ScheduledExecutorServiceUsage {

    public static void main(String[] args) {
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executorService.schedule(() -> {
            // ...
            return "Hello world";
        }, 1, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
            // ...
        }, 1, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
