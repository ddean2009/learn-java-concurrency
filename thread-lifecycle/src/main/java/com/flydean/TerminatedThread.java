package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version TerminatedThread,  2020/3/3 10:55 上午
 */
@Slf4j
public class TerminatedThread implements Runnable{
    @Override
    public void run() {

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TerminatedThread());
        t1.start();
        // The following sleep method will give enough time for
        // thread t1 to complete
        Thread.sleep(1000);
        log.info(t1.getState().toString());
    }
}
