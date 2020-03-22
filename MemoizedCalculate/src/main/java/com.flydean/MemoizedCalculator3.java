package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author wayne
 * @version MemoizedCalculator1,  2020/3/22 12:47 下午
 */
@Slf4j
public class MemoizedCalculator3<A, V> implements Calculator<A, V> {

    private final Map<A, Future<V>> cache= new ConcurrentHashMap<>();
    private final Calculator<A, V> calculator;

    public MemoizedCalculator3(Calculator<A, V> calculator){
        this.calculator=calculator;
    }
    @Override
    public V calculate(A arg) throws InterruptedException {
        Future<V> future= cache.get(arg);
        V result=null;
        if( future ==null ){
            Callable<V> callable= new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return calculator.calculate(arg);
                }
            };
            FutureTask<V> futureTask= new FutureTask<>(callable);
            future= futureTask;
            cache.put(arg, futureTask);
            futureTask.run();
        }
        try {
            result= future.get();
        } catch (ExecutionException e) {
           log.error(e.getMessage(),e);
        }
        return result;
    }
}
