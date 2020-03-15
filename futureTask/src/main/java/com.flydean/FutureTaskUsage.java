package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version FutureTaskUsage,  2020/3/15 9:14 下午
 */
@Slf4j
public class FutureTaskUsage {

    @Test
    public void convertRunnableToCallable() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
               log.info("inside callable future task ...");
                return 0;
            }
        });

        Thread thread= new Thread(futureTask);
        thread.start();
        log.info(futureTask.get().toString());
    }

    @Test
    public void workWithExecutorService() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("inside futureTask");
                return 1;
            }
        });
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(futureTask);
        executor.shutdown();
        log.info(futureTask.get().toString());
    }
}
