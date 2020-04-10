package com.flydean;

import java.util.concurrent.Exchanger;

/**
 * @author wayne
 * @version ExchangerUsage,  2020/4/10 10:07 下午
 */
public class ExchangerUsage {

    public static void main(String[] args) {
        Exchanger<CustBook> exchanger = new Exchanger<>();
        // Starting two threads
        new Thread(new ExchangerOne(exchanger)).start();
        new Thread(new ExchangerTwo(exchanger)).start();
    }
}
