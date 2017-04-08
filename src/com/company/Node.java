package com.company;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Node<N> extends Object {

    private Node next = null;
    private Node prev = null;
    private N data;

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
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public boolean hasPrev() throws NullPointerException{
        if ( this.getPrev () != null )
            return true;
        else
            return false;
    }

    public boolean hasNext() throws NullPointerException{
        if ( this.getNext () != null )
            return true;
        else
            return false;
    }




    public N getData() {
        return data;
    }

    public void setData(N data) {
        this.data = data;
    }

    // Скорее всего не пригодится.

    public boolean equals(Node<N> node){
        if (this.getData() == node.getData() && this.getNext() == node.getNext() && this.getPrev() == node.getPrev())
            return true;
        else
            return false;
    }



}
