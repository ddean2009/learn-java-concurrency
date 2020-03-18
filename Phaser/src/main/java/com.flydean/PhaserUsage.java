package com.flydean;

import java.util.concurrent.Phaser;

/**
 * @author wayne
 * @version PhaserUsage,  2020/3/17 10:45 下午
 */
public class PhaserUsage implements Runnable {
    private String threadName;
    private Phaser ph;

    PhaserUsage(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        ph.register();
    }

    @Override
    public void run() {
        ph.arriveAndAwaitAdvance();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndDeregister();
    }

}
