package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wayne
 * @version RunnableUsage,  2020/3/2 8:13 上午
 */
@Slf4j
public class RunnableUsage {

    public void executeTask() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(()->log.info("in runnable!!!!"));
        executorService.shutdown();
    }
}
