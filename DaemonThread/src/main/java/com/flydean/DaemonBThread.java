package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version DaemonThread,  2020/3/5 9:33 上午
 */
@Slf4j
public class DaemonBThread extends Thread{

    Thread worker = new Thread(()->{
        while(true){
            log.info("Thread B run");
            log.info("Thread B is daemon {}",Thread.currentThread().isDaemon());
        }
    });
    public void  run(){
            log.info("Thread A run");
            worker.start();
    }

    public static void main(String[] args) {
        DaemonBThread daemonThread = new DaemonBThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
