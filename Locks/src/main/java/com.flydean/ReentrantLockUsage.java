package com.flydean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wayne
 * @version ReentrantLockUsage,  2020/3/10 8:51 上午
 */
public class ReentrantLockUsage {
    ReentrantLock lock = new ReentrantLock();
    int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockUsage reentrantLockUsage=new ReentrantLockUsage();
        reentrantLockUsage.perform();
        reentrantLockUsage.performTryLock();
        }

    public void perform() {

        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public void performTryLock() throws InterruptedException {
        boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);

        if(isLockAcquired) {
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }
    }
}
