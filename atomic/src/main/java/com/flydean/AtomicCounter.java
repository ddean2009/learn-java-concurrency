package com.flydean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version AtomicCounter,  2020/3/4 10:59 上午
 */
public class AtomicCounter {

    private final AtomicInteger counter = new AtomicInteger(0);

    public int getValue() {
        return counter.get();
    }
    public void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }
}
