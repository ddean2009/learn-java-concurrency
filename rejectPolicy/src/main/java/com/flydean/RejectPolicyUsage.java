package com.flydean;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version RejectPolicyUsage,  2020/3/26 11:01 上午
 */
public class RejectPolicyUsage {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(20));
        threadPoolExecutor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
