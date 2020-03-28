package com.flydean;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wayne
 * @version ConcurrentStack,  2020/3/28 8:04 下午
 */
public class ConcurrentStack<E> {

    AtomicReference<Node<E>> top= new AtomicReference<>();

    public void push(E item){
        Node<E> newNode= new Node<>(item);
        Node<E> oldNode;
        do{
            oldNode=top.get();
            newNode.next= oldNode;
        }while(!top.compareAndSet(oldNode, newNode));
    }

    public E pop(){
        Node<E> oldNode;
        Node<E> newNode;
        do {
            oldNode = top.get();
            if(oldNode == null){
                return null;
            }
            newNode=oldNode.next;
        }while(!top.compareAndSet(oldNode, newNode));
        return oldNode.item;
    }

}
