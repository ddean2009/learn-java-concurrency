package com.flydean;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * @author wayne
 * @version SemaphoreUsage,  2020/3/26 11:19 上午
 */
public class SemaphoreUsage {

    private final Executor executor;
    private final Semaphore semaphore;

    public SemaphoreUsage(Executor executor, int count) {
        this.executor = executor;
        this.semaphore = new Semaphore(count);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(() -> {
                        try {
                            command.run();
                        } finally {
                            semaphore.release();
                        }
                    }
            );
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }

}
