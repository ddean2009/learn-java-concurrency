package com.flydean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version Reorder,  2020/3/29 11:24 上午
 */
@Slf4j
public class Reorder {

    int x=0, y=0;
    int a=0, b=0;

    private  void reorderMethod() throws InterruptedException {

        Thread one = new Thread(()->{
            a=1;
            x=b;
        });

        Thread two = new Thread(()->{
            b=1;
            y=a;
        });
        one.start();
        two.start();
        one.join();
        two.join();
        log.info("{},{}", x, y);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i=0; i< 100; i++){
            new Reorder().reorderMethod();
        }
    }
}
