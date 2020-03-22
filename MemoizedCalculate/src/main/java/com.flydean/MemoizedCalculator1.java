package com.flydean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wayne
 * @version MemoizedCalculator1,  2020/3/22 12:47 下午
 */
public class MemoizedCalculator1<A, V> implements Calculator<A, V> {

    private final Map<A, V> cache= new HashMap<A, V>();
    private final Calculator<A, V> calculator;

    public MemoizedCalculator1(Calculator<A, V> calculator){
        this.calculator=calculator;
    }
    @Override
    public synchronized V calculate(A arg) throws InterruptedException {
        V result= cache.get(arg);
        if( result ==null ){
            result= calculator.calculate(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
