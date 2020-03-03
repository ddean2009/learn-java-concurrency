package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version RunnableThread,  2020/3/3 10:17 上午
 */
@Slf4j
public class RunnableThread implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Runnable runnable = new RunnableThread();
        Thread t = new Thread(runnable);
        t.start();
        log.info(t.getState().toString());
    }
}
