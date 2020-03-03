package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version TimedWaitThread,  2020/3/3 10:42 上午
 */
@Slf4j
public class TimedWaitThread implements  Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted", e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimedWaitThread obj1 = new TimedWaitThread();
        Thread t1 = new Thread(obj1);
        t1.start();

        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        log.info(t1.getState().toString());
    }
}
