package com.flydean;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * @author wayne
 * @version VolatileUsageTest,  2020/2/28 8:31 上午
 */
public class VolatileUsageTest {

    @Test
    public void testWithoutVolatile() throws InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(3);
        VolatileWithoutUsage volatileWithoutUsage=new VolatileWithoutUsage();

        IntStream.range(0,1000).forEach(count ->service.submit(volatileWithoutUsage::incrementCount) );
        service.shutdown();
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000,volatileWithoutUsage.getCount() );
    }

    @Test
    public void testWithVolatileFalseUsage() throws InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(3);
        VolatileFalseUsage volatileFalseUsage=new VolatileFalseUsage();

        IntStream.range(0,1000).forEach(count ->service.submit(volatileFalseUsage::incrementCount) );
        service.shutdown();
        service.awaitTermination(5000, TimeUnit.MILLISECONDS);
        assertEquals(1000,volatileFalseUsage.getCount() );
    }

    @Test
    public void testWithVolatileTrueUsage() throws InterruptedException {
        VolatileTrueUsage volatileTrueUsage=new VolatileTrueUsage();
        Thread threadA = new Thread(()->volatileTrueUsage.setCount(10));
        threadA.start();
        Thread.sleep(100);

        Thread reader = new Thread(() -> {
            int valueReadByThread = volatileTrueUsage.getCount();
            assertEquals(10, valueReadByThread);
        });
        reader.start();
    }

}
