package com.flydean;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author wayne
 * @version SemaphoreUsage,  2020/3/21 5:00 下午
 */
public class SemaphoreUsage<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public SemaphoreUsage(int bound){
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem= new Semaphore(bound);
    }

    public boolean add (T o) throws InterruptedException{
        sem.acquire();
        boolean wasAdded = false;
        try{
            wasAdded=set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded){
                sem.release();
            }
        }
    }

    public boolean remove(Object o){
        boolean wasRemoved = set.remove(o);
        if(wasRemoved){
            sem.release();
        }
        return wasRemoved;
    }

}
