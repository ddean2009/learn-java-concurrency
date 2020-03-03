package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version BlockThread,  2020/3/3 10:22 上午
 */
@Slf4j
public class BlockThread implements Runnable {
    @Override
    public void run() {
        loopResource();
    }

    public static synchronized void loopResource() {
        while(true) {
            //无限循环
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new BlockThread());
        Thread t2 = new Thread(new BlockThread());

        t1.start();
        t2.start();

        Thread.sleep(1000);
        log.info(t1.getState().toString());
        log.info(t2.getState().toString());
        System.exit(0);
    }
}
