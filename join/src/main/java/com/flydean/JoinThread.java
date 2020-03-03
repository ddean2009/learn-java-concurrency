package com.flydean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version JoinUsage,  2020/3/4 6:11 上午
 */
@Slf4j
@NoArgsConstructor
public class JoinThread extends Thread{
    public int processingCount = 0;

    JoinThread(int processingCount) {
        this.processingCount = processingCount;
        log.info("Thread Created");
    }

    @Override
    public void run() {
        log.info("Thread " + Thread.currentThread().getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info("Thread " + Thread.currentThread().getName() + " interrupted");
            }
            processingCount--;
        }
        log.info("Thread " + Thread.currentThread().getName() + " exiting");
    }

    @Test
    public void joinTest()
            throws InterruptedException {
        Thread t2 = new Thread(new JoinThread(1));
        t2.start();
        log.info("Invoking join");
        t2.join();
        log.info("Returned from join");
        log.info("t2 status {}",t2.isAlive());
    }

    @Test
    public void testJoinTimeout()
            throws InterruptedException {
        Thread t3 =  new Thread(new JoinThread(10));
        t3.start();
        t3.join(1000);
        log.info("t3 status {}", t3.isAlive());
    }

    @Test
    public void testHappenBefore() throws InterruptedException {
        JoinThread t4 =  new JoinThread(10);
        t4.start();
        // not guaranteed to stop even if t4 finishes.
        do {
            log.info("inside the loop");
            Thread.sleep(1000);
        } while ( t4.processingCount > 0);
    }
}
