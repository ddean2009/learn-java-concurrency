package com.flydean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wayne
 * @version CyclicBarrierUsage,  2020/3/11 10:27 上午
 */
public class CyclicBarrierUsage implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private List<List<Integer>> partialResults;
    private Random random = new Random();

    public CyclicBarrierUsage(CyclicBarrier cyclicBarrier,List<List<Integer>> partialResults){
        this.cyclicBarrier=cyclicBarrier;
        this.partialResults=partialResults;
    }

    @Override
    public void run() {
        String thisThreadName = Thread.currentThread().getName();
        List<Integer> partialResult = new ArrayList<>();

        // Crunch some numbers and store the partial result
        for (int i = 0; i < 10; i++) {
            Integer num = random.nextInt(10);
            System.out.println(thisThreadName
                    + ": Crunching some numbers! Final result - " + num);
            partialResult.add(num);
        }

        partialResults.add(partialResult);
        try {
            System.out.println(thisThreadName
                    + " waiting for others to reach barrier.");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            // ...
        } catch (BrokenBarrierException e) {
            // ...
        }
    }

}
