package com.flydean;

/**
 * @author wayne
 * @version LockCounter,  2020/3/4 10:58 上午
 */
public class LockCounter {

    private volatile int counter;

    public synchronized void increment() {
        counter++;
    }
}
