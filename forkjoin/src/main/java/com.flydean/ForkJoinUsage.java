package com.flydean;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

/**
 * @author wayne
 * @version ForkJoinUsage,  2020/3/7 2:08 下午
 */
public class ForkJoinUsage {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

//        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        CustomRecursiveAction customRecursiveAction= new CustomRecursiveAction("fork join action test!!!");
        int[] intArray= {12,12,13,14,15};
        CustomRecursiveTask customRecursiveTask= new CustomRecursiveTask(intArray);

        int result = forkJoinPool.invoke(customRecursiveTask);
        System.out.println(result);

        customRecursiveTask.fork();
        int result2= customRecursiveTask.join();
        System.out.println(result2);

        forkJoinPool.invoke(customRecursiveAction);

        customRecursiveAction.fork();
        customRecursiveAction.invoke();






    }
}
