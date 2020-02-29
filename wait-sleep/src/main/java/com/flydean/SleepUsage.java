package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version SleepUsage,  2020/2/29 10:26 上午
 */
@Slf4j
public class SleepUsage {

    public static void sleepExample() throws InterruptedException {
        Thread.sleep(1000);
        Thread.currentThread().interrupt();
        log.info(
                "Thread '" + Thread.currentThread().getName() +
                        "' is woken after sleeping for 1 second");
    }
}
