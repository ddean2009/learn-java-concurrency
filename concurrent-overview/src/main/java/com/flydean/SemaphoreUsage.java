package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @author wayne
 * @version SemaphoreUsage,  2020/2/24 11:41 下午
 */
@Slf4j
public class SemaphoreUsage {

    static Semaphore semaphore = new Semaphore(10);

    public void execute() throws InterruptedException {

        log.info("Number of threads waiting to acquire: " +
                semaphore.getQueueLength());

        if (semaphore.tryAcquire()) {
            try {
                // ...
            }
            finally {
                semaphore.release();
            }
        }

    }

    public static void main(String[] args) {

    }
}
