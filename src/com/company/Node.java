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

    // DONE
    public Node getNext() {
        return next;
    }

    // DONE
    public void setNext(Node next) {
        this.next = next;
    }

    // DONE
    public Node getPrev() {
        return this.prev;
    }

    // DONE
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // DONE
    public boolean hasPrev() throws NullPointerException{
        if ( this.getPrev () != null )
            return true;
        else
            return false;
    }

    // DONE
    public boolean hasNext() throws NullPointerException{
        if ( this.getNext () != null )
            return true;
        else
            return false;
    }

    // DONE
    public N getData() {
        return data;
    }

    // DONE
    public void setData(N data) {
        this.data = data;
    }

    // DONE
    public Node copyNode () {
        Node result = new Node ( this.data );
        return result;
    }

    // Скорее всего не пригодится.

    // DONE
    public boolean equals(Node<N> node){
        if (this.getData() == node.getData() && this.getNext() == node.getNext() && this.getPrev() == node.getPrev())
            return true;
        else
            return false;
    }



}
