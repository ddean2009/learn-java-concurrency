package com.flydean;

/**
 * @author wayne
 * @version Account,  2020/3/26 11:30 上午
 */
public class Account {
    private int amount;

    public int getBalance(){
        return amount;
    }

    public void debit(int count){
        amount= amount - count;
    }

    public void credit(int count){
        amount= amount+ count;
    }
}
