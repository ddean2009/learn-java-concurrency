package com.flydean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wayne
 * @version MemoizedCalculator1,  2020/3/22 12:47 下午
 */
public class MemoizedCalculator2<A, V> implements Calculator<A, V> {

    private final Map<A, V> cache= new ConcurrentHashMap<>();
    private final Calculator<A, V> calculator;

    public MemoizedCalculator2(Calculator<A, V> calculator){
        this.calculator=calculator;
    }
    @Override
    public V calculate(A arg) throws InterruptedException {
        V result= cache.get(arg);
        if( result ==null ){
            result= calculator.calculate(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
