package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class LinkedList<L> implements List<L> {

    private Node<L> head;
    private Node<L> tail;

    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<L> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(L l) {
        Node<L> node = new Node<>(l);
        if (size == 0) {
            this.head = node;
            this.tail = node;
        }
        else {
            Node<L> monitor = this.head;

            while (monitor.getNext() != null) {
                monitor = monitor.getNext();
            }
            monitor.setNext(node);
            node.setPrev(monitor);
            this.tail = node;
        }

        size++;


        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends L> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends L> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public L get(int index) {

        if (index < (Math.round(this.size()/2))) {
            Node<L> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node.getData();
        } else {
            Node<L> node = this.tail;
            for (int i = this.size()-1; i > index; i--) {
                node = node.getPrev();
            }
            return node.getData();

        }
    }

    @Override
    public L set(int index, L element) {
        return null;
    }

    @Override
    public void add(int index, L element) {

    }

    @Override
    public L remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<L> listIterator() {
        return null;
    }

    @Override
    public ListIterator<L> listIterator(int index) {
        return null;
    }

    @Override
    public List<L> subList(int fromIndex, int toIndex) {
        return null;
    }
}
