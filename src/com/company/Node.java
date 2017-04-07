package com.company;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Node<N> {
    private Node next;
    private Node prev;
    private N data;

    public Node() {
        this.next = null;
        this.prev = null;
    }

    public Node(Node prev){
        this.next = null;
        this.prev = prev;
    }

    public Node(N l) {
        data = l;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public N getData() {
        return data;
    }

    public void setData(N data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj){
        return data.equals(obj);
    }
}
