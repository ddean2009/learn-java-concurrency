package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version Task,  2020/2/24 10:11 下午
 */
@Slf4j
public class Task implements Runnable {
    @Override
    public void run() {
        // task details
        log.info(Thread.currentThread().getName()+"run task");
    }
}
