package com.flydean;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author wayne
 * @version RCU,  2020/5/11 1:37 下午
 */
public class RCU {
    final static long NOT_READING = Long.MAX_VALUE;
    final static int MAX_THREADS = 128;
    final AtomicLong reclaimerVersion = new AtomicLong(0);
    final AtomicLongArray readersVersion = new AtomicLongArray(MAX_THREADS);

    public RCU() {
        for (int i=0; i < MAX_THREADS; i++) readersVersion.set(i, NOT_READING);
    }

    public static int getTID() {
        return (int)(Thread.currentThread().getId() % MAX_THREADS);
    }

    public void read_lock(final int tid) {  // rcu_read_lock()
        final long rv = reclaimerVersion.get();
        readersVersion.set(tid, rv);
        final long nrv = reclaimerVersion.get();
        if (rv != nrv) readersVersion.lazySet(tid, nrv);
    }

    public void read_unlock(final int tid) { // rcu_read_unlock()
        readersVersion.set(tid, NOT_READING);
    }

    public void synchronize_rcu() {
        final long waitForVersion = reclaimerVersion.incrementAndGet();
        for (int i=0; i < MAX_THREADS; i++) {
            while (readersVersion.get(i) < waitForVersion) { } // spin
        }
    }
}
