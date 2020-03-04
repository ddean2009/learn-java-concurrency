package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version InterruptThread,  2020/3/4 11:46 上午
 */
@Slf4j
public class InterruptThread extends Thread {
    @Override
    public  void run() {
        for (int i = 0; i < 1000; i++) {
            log.info("i= {}", (i+1));
            log.info("call inside thread.interrupted()： {}", Thread.interrupted());
        }
    }

    @Test
    public void testInterrupt(){
        InterruptThread thread=new InterruptThread();
        thread.start();
        thread.interrupt();
        //test isInterrupted
        log.info("first call isInterrupted(): {}", thread.isInterrupted());
        log.info("second call isInterrupted(): {}", thread.isInterrupted());

        //test interrupted（)
        log.info("first call outside thread.interrupted()： {}", Thread.interrupted());
        log.info("second call outside thread.interrupted() {}：", Thread.interrupted());
        log.info("thread is alive : {}",thread.isAlive() );
    }
}
