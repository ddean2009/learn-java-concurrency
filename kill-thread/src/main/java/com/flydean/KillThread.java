package com.flydean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wayne
 * @version KillThread,  2020/3/4 7:15 上午
 */

@Data
@Slf4j
public class KillThread implements Runnable {
    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private int interval;

    public KillThread(int sleepInterval) {
        interval = sleepInterval;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    public void stop() {
        running.set(false);
    }

    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e){
                log.info("isInterrupted status {}", Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                log.info("Thread was interrupted, Failed to complete operation");
            }
            // do something here
        }
        log.info("finished");
    }

    public static void main(String[] args) {
        KillThread killThread= new KillThread(1000);
        killThread.start();
//        killThread.stop();
        killThread.interrupt();
    }
}
