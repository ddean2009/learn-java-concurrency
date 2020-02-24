package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;

/**
 * @author wayne
 * @version Invoker,  2020/2/24 9:12 下午
 */
@Slf4j
public class Invoker implements Executor {

    public void execute(Runnable r) {
        r.run();
    }

    public void execute() {
        Executor executor = new Invoker();
        executor.execute( () -> {
            log.info("{}", Thread.currentThread().toString());
        });
    }

    public static void main(String[] args) {
        log.info("{}",Thread.currentThread().toString());

        Invoker invoker=new Invoker();
        invoker.execute();
    }
}

