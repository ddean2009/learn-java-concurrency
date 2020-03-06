package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version ScheduledThreadPoolExecutorUsage,  2020/3/6 10:42 上午
 */
@Slf4j
public class ScheduledThreadPoolExecutorUsage {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> {
            log.info("Hello World");
        }, 500, TimeUnit.MILLISECONDS);

        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor2.scheduleAtFixedRate(() -> {
            log.info("in ScheduledFuture");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
    }
}
