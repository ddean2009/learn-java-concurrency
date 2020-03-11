package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author wayne
 * @version CountDownLatchUsage,  2020/3/10 11:47 下午
 */
@Slf4j
public class MainThreadWaitUsage implements Runnable {

    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public MainThreadWaitUsage(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}
