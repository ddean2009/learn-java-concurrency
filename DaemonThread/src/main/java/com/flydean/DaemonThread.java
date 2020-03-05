package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version DaemonThread,  2020/3/5 9:33 上午
 */
@Slf4j
public class DaemonThread extends Thread{

    public void  run(){
        while(true){
            log.info("Thread A run");
            try {
                log.info("Thread A is daemon {}" ,Thread.currentThread().isDaemon());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDaemon() throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.start();
        Thread.sleep(2000);
    }


    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        Thread.sleep(2000);
    }
}
