package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * @author wayne
 * @version ThreadFactoryUsage,  2020/2/24 11:44 下午
 */
@Slf4j
public class ThreadFactoryUsage implements ThreadFactory {
    private int threadId;
    private String name;

    public ThreadFactoryUsage(String name) {
        threadId = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + threadId);
        log.info("created new thread with id : " + threadId +
                " and name : " + t.getName());
        threadId++;
        return t;
    }
}
