package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version NewThread,  2020/3/3 10:14 上午
 */
@Slf4j
public class NewThread implements Runnable{
    public static void main(String[] args) {
        Runnable runnable = new NewThread();
        Thread t = new Thread(runnable);
        log.info(t.getState().toString());
    }

    @Override
    public void run() {

    }
}
