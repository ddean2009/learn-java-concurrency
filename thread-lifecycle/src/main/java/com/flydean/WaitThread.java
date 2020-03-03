package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version WaitThread,  2020/3/3 10:29 上午
 */
@Slf4j
public class WaitThread implements  Runnable{

    public static Thread t1;
    @Override
    public void run() {
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
            log.info("t1 "+t1.getState().toString());
        });
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted", e);
        }
        log.info("t2 "+t2.getState().toString());
    }

    public static void main(String[] args) {
        t1 = new Thread(new WaitThread());
        t1.start();

    }
}
