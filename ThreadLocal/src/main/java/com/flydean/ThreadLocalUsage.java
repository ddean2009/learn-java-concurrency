package com.flydean;

/**
 * @author wayne
 * @version ThreadLocalUsage,  2020/3/2 10:41 上午
 */
public class ThreadLocalUsage {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
        threadLocalValue.set(1);
        Integer result = threadLocalValue.get();

        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

        threadLocal.remove();


    }
}
