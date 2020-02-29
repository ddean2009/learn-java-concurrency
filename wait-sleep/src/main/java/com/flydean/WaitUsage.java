package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version WaitUsage,  2020/2/29 8:53 上午
 */
@Slf4j
public class WaitUsage {

    private static Object LOCK = new Object();

    public static void WaitExample() throws InterruptedException {
        synchronized (LOCK) {
            LOCK.wait(1000);
            log.info("Object '" + LOCK + "' is woken after" +
                    " waiting for 1 second");
        }
    }
}
