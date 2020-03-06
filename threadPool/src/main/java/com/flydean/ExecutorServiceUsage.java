package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 * @version ExecutorServiceUsage,  2020/3/6 9:50 上午
 */
@Slf4j
public class ExecutorServiceUsage {

    public static void main(String[] args) {

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> log.info("in Executor"));


        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.submit(()->log.info("in ExecutorService"));
        executorService.shutdown();
    }
}
