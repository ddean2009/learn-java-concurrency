package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wayne
 * @version CyclicBarrierUsage,  2020/2/24 11:32 下午
 */
@Slf4j
public class CyclicBarrierUsage implements Runnable{

    private CyclicBarrier barrier;

    public CyclicBarrierUsage(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            log.info(Thread.currentThread().getName() +
                    " is waiting");
            barrier.await();
            log.info(Thread.currentThread().getName() +
                    " is released");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            // ...
            log.info("All previous tasks are completed");
        });

        Thread t1 = new Thread(new CyclicBarrierUsage(cyclicBarrier), "T1");
        Thread t2 = new Thread(new CyclicBarrierUsage(cyclicBarrier), "T2");
        Thread t3 = new Thread(new CyclicBarrierUsage(cyclicBarrier), "T3");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }
    }

}
