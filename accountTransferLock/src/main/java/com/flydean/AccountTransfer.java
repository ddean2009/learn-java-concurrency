package com.flydean;

/**
 * @author wayne
 * @version AccountTransfer,  2020/3/26 11:29 上午
 */
public class AccountTransfer {

    private static final Object lock= new Object();

    public void transferMoneyDeadLock(Account from,Account to, int amount) throws InsufficientAmountException {
        synchronized (from){
            synchronized (to){
                transfer(from,to,amount);
            }
        }
    }

    private void transfer(Account from,Account to, int amount) throws InsufficientAmountException {
        if(from.getBalance() < amount){
            throw new InsufficientAmountException();
        }else{
            from.debit(amount);
            to.credit(amount);
        }
    }

    public void transferMoney(Account from,Account to, int amount) throws InsufficientAmountException {

       int fromHash= System.identityHashCode(from);
       int toHash = System.identityHashCode(to);

       if(fromHash < toHash){
           synchronized (from){
               synchronized (to){
                   transfer(from,to, amount);
               }
           }
       }else if(fromHash < toHash){
            synchronized (to){
                synchronized (from){
                    transfer(from,to, amount);
                }
            }
        }else{
           synchronized (lock){
           synchronized (from) {
               synchronized (to) {
                   transfer(from, to, amount);
               }
             }
           }
       }
    }
}
