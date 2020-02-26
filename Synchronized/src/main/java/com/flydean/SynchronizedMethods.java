package com.flydean;

import lombok.Data;

/**
 * @author wayne
 * @version SynchronizedMethods,  2020/2/25 10:10 下午
 */
@Data
public class SynchronizedMethods {

    private int sum = 0;

    public static int staticSum=0;

    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void synchronisedCalculate() {
        setSum(getSum() + 1);
    }

    public static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    public void performSynchronizedTask() {
        synchronized (this) {
            setSum(getSum() + 1);
        }
    }

    public static void performStaticSyncTask(){
        synchronized (SynchronizedMethods.class) {
            staticSum = staticSum + 1;
        }
    }
}
