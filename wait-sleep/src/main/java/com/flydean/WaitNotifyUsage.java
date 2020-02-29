package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version WaitNotifyUsage,  2020/2/29 9:19 上午
 */
@Slf4j
public class WaitNotifyUsage {

    private int count =0;

    public void produceMessage() throws InterruptedException {

        while(true) {
            synchronized (this) {
                while (count == 5) {
                    log.info("count == 5 , wait ....");
                    wait();
                }
                count++;
                log.info("produce count {}", count);
                notify();
            }
        }
    }

    public void consumeMessage() throws InterruptedException {

        while (true) {
            synchronized (this) {
                while (count == 0) {
                    log.info("count == 0, wait ...");
                    wait();
                }
                log.info("consume count {}", count);
                count--;
                notify();
            }
        }
    }
}
