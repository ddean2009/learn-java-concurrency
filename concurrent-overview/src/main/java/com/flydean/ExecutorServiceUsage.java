package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version ExecutorServiceUsage,  2020/2/24 10:07 下午
 */
@Slf4j
public class ExecutorServiceUsage {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
//        ExecutorService executor =Executors.newSingleThreadExecutor();
                executor.submit(new Task());
//        executor.submit(() -> {
//            new Task();
//        });

        executor.shutdown();
//        executor.shutdownNow();
        try {
            executor.awaitTermination( 5l, TimeUnit.SECONDS );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
