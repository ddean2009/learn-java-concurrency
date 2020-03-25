package com.flydean;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version TrackingExecutor,  2020/3/25 7:57 下午
 */
public class TrackingExecutor extends AbstractExecutorService {
    private final ExecutorService executorService;
    private final Set<Runnable> taskCancelledAtShutdown= Collections.synchronizedSet(new HashSet<Runnable>());

    public TrackingExecutor(ExecutorService executorService){
         this.executorService=executorService;
    }
    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout,unit);
    }

    @Override
    public void execute(Runnable command) {
        executorService.execute(() -> {
            try {
                command.run();
            }finally {
                if(isShutdown() && Thread.currentThread().isInterrupted()){
                    taskCancelledAtShutdown.add(command);
                }
            }
        });
    }

    public List<Runnable> getCancelledTask(){
        if(! executorService.isTerminated()){
            throw new IllegalStateException("executorService is not terminated");
        }
        return new ArrayList<>(taskCancelledAtShutdown);
    }
}
