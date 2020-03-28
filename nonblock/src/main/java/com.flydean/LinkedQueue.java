package com.flydean;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wayne
 * @version LinkedQueue,  2020/3/28 8:29 下午
 */
public class LinkedQueue<E> {
    private final LinkedNode<E> nullNode= new LinkedNode<>(null, null);
    private final AtomicReference<LinkedNode<E>> head= new AtomicReference<>(nullNode);
    private final AtomicReference<LinkedNode<E>> tail= new AtomicReference<>(nullNode);

    public boolean put(E item){
    LinkedNode<E> newNode = new LinkedNode<>(item, null);
    while (true){
        LinkedNode<E> currentTail= tail.get();
        LinkedNode<E> tailNext= currentTail.next.get();
        if(currentTail == tail.get()){
            if (tailNext != null) {
                //有其他的线程已经插入了一个节点，但是还没有将tail指向最新的节点
                tail.compareAndSet(currentTail, tailNext);
            }else{
                //没有其他的线程插入节点，那么做两件事情：1. 插入新节点，2.将tail指向最新的节点
                if(currentTail.next.compareAndSet(null, newNode)){
                    tail.compareAndSet(currentTail, newNode);
                }
            }
        }
    }
    }
}
