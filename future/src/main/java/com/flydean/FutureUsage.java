package com.flydean;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version FutureUsage,  2020/3/1 10:22 下午
 */
public class FutureUsage {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("Calculating..."+ input);
            Thread.sleep(1000);
            return input * input;
        });
    }

    public void shutDown(){
        executor.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureUsage futureUsage=new FutureUsage();
        Future<Integer> futureOne = futureUsage.calculate(20);
        while(!futureOne.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }
        Integer result = futureOne.get();
//        Integer result = futureOne.get(500, TimeUnit.MILLISECONDS);

        Future<Integer> futureTwo = futureUsage.calculate(4);

        boolean canceled = futureTwo.cancel(true);


        Future<Integer> future1 = futureUsage.calculate(10);
        Future<Integer> future2 = futureUsage.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        futureUsage.shutDown();

    }
}
