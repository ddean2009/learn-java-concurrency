package com.flydean;

import java.util.List;
import java.util.concurrent.Phaser;

/**
 * @author wayne
 * @version PhaserTask,  2020/3/18 9:01 上午
 */
public class PhaserTask {

    void runTasks(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1); // "1" to register self
        // create and start threads
        for (final Runnable task : tasks) {
            phaser.register();
            new Thread() {
                public void run() {
                    phaser.arriveAndAwaitAdvance(); // await all creation
                    task.run();
                }
            }.start();
        }

        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }

    void startTasks(List<Runnable> tasks, final int iterations) {
        final Phaser phaser = new Phaser() {
            protected boolean onAdvance(int phase, int registeredParties) {
                return phase >= iterations || registeredParties == 0;
            }
        };
        phaser.register();
        for (final Runnable task : tasks) {
            phaser.register();
            new Thread() {
                public void run() {
                    do {
                        task.run();
                        phaser.arriveAndAwaitAdvance();
                    } while (!phaser.isTerminated());
                }
            }.start();
        }
        phaser.arriveAndDeregister(); // deregister self, don't wait
    }


    void awaitPhase(Phaser phaser, int phase) {
        int p = phaser.register(); // assumes caller not already registered
        while (p < phase) {
            if (phaser.isTerminated()) {
                // ... deal with unexpected termination
            }
     else {
                p = phaser.arriveAndAwaitAdvance();
            }
        }
        phaser.arriveAndDeregister();
    }

}
