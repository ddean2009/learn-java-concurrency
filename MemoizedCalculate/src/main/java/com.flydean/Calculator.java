package com.flydean;

/**
 * @author wayne
 * @version calculator,  2020/3/22 12:44 下午
 */
public interface Calculator<A, V> {

    V calculate(A arg) throws InterruptedException;
}
