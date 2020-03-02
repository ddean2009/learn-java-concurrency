package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wayne
 * @version CallableUsage,  2020/3/2 8:13 上午
 */
@Slf4j
public class CallableUsage {

    public void executeTask() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(()->{
            log.info("in callable!!!!");
            return "callable";
        });
        executorService.shutdown();
    }

    public void executeTaskWithException(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(()->{
            log.info("in callable!!!!");
            throw new CustomerException("a customer Exception");
        });
        try {
            Object object= future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            e.getCause();
        }
        executorService.shutdown();
    }
}
