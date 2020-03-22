package com.flydean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wayne
 * @version CompletionServiceUsage,  2020/3/22 10:22 下午
 */
public class CompletionServiceUsage {

    public void useExecutorService() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        List<Future<String>> futures = executor.invokeAll(callableTasks);

        executor.shutdown();

    }

    public void useCompletionService() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService=new ExecutorCompletionService<String>(executor);
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };
        for(int i=0; i< 5; i ++){
            completionService.submit(callableTask);
        }

        for(int i=0; i<5; i++){
            Future<String> result=completionService.take();
            System.out.println(result.get());
        }
    }
}
