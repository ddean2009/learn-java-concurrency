package com.flydean;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author wayne
 * @version AQSUsage,  2020/3/26 11:27 下午
 */
public class AQSUsage {

    private final Sync sync= new Sync();

    private class Sync extends AbstractQueuedSynchronizer{
        protected int tryAcquireShared(int ignored){
            return (getState() ==1 )? 1: -1;
        }
        protected boolean tryReleaseShared(int ignored){
            setState(1);
            return true;
        }
    }

    public void release() {
        sync.releaseShared(0);
    }
    public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }
}
