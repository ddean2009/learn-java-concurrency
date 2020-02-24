package com.flydean;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version FutureUsage,  2020/2/24 11:28 下午
 */
public class FutureUsage {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            // ...
            Thread.sleep(10000l);
            return "Hello world";
        });

        if (future.isDone() && !future.isCancelled()) {
            try {
               String str = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
