package com.flydean;

/**
 * @author wayne
 * @version Node,  2020/3/28 7:52 下午
 */
public class Node<E> {
    public final E item;
    public Node<E> next;

    public Node(E item){
        this.item=item;
    }
}
