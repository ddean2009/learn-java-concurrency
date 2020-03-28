package com.flydean;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wayne
 * @version LinkedNode,  2020/3/28 8:27 下午
 */
public class LinkedNode<E> {
    public final E item;
    public final AtomicReference<LinkedNode<E>> next;

    public LinkedNode(E item, LinkedNode<E> next){
        this.item=item;
        this.next=new AtomicReference<>(next);
    }
}
