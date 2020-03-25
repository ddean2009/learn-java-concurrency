package com.flydean;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version ThreadPoolDeadlock,  2020/3/25 9:02 下午
 */
public class ThreadPoolDeadlock {

    ExecutorService executorService= Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String> {
        public String call() throws Exception{
            Future<String> header, footer;
            header= executorService.submit(()->{
                return "header";
            });
            footer= executorService.submit(()->{
                return "footer";
            });
            return header.get()+ footer.get();
        }
    }

    public void submitTask(){
        executorService.submit(new RenderPageTask());
    }
}
