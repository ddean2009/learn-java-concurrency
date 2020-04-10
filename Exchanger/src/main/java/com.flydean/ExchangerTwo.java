package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;

/**
 * @author wayne
 * @version ExchangerTwo,  2020/4/10 10:08 下午
 */
@Slf4j
public class ExchangerTwo implements Runnable{

    Exchanger<CustBook> ex;

    ExchangerTwo(Exchanger<CustBook> ex){
      this.ex=ex;
    }

    @Override
    public void run() {
    CustBook custBook= new CustBook();
        custBook.setName("book two");

        try {
            CustBook exhangeCustBook=ex.exchange(custBook);
            log.info(exhangeCustBook.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
