package com.flydean;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 * @version RandomUsage,  2020/3/14 9:16 上午
 */
public class RandomUsage {

    public void testRandom() throws InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        Random random = new Random();
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            callables.add(() -> {
                return random.nextInt();
            });
            }
        executorService.invokeAll(callables);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RandomUsage.class.getSimpleName())
                // 预热5轮
                .warmupIterations(5)
                // 度量10轮
                .measurementIterations(10)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
