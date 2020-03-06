package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version ThreadPoolExecutorUsage,  2020/3/6 10:15 上午
 */
@Slf4j
public class ThreadPoolExecutorUsage {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.submit(()->log.info("submit through threadPoolExecutor"));
        threadPoolExecutor.shutdown();

        ThreadPoolExecutor executor1 =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor1.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor1.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor1.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        log.info("executor1 poolsize {}",executor1.getPoolSize());
        log.info("executor1 queuesize {}", executor1.getQueue().size());
        executor1.shutdown();

        ThreadPoolExecutor executor2 =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        log.info("executor2 poolsize {}", executor2.getPoolSize());
        log.info("executor2 queue size {}", executor2.getQueue().size());
        executor2.shutdown();

    }
}
