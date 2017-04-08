package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.List;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class LinkedList<L> implements List {

    private Node<L> head;
    private Node<L> tail;

    private int size = 0;

    // DONE
    public int size () {
        return this.size;
    }

    // DONE
    public boolean isEmpty () {
        if ( size == 0 ) {
            return true;
        } else
            return false;
    }

    // DONE
    public Node<L> get (int index) {
        if ( index < (Math.round ( this.size () / 2 )) ) {
            Node<L> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext ();
            }
            return node;
        } else {
            Node<L> node = this.tail;
            for (int i = this.size () - 1; i > index; i--) {
                node = node.getPrev ();
            }
            return node;

        }

    }

    // DONE
    public void remove (Node node) {

        boolean flagPrev = false ;
        boolean flagNext = false ;

        if (node.hasPrev () ) {
            node.getPrev ().setNext ( node.getNext () );
            flagPrev = true;
        }
        else
            flagPrev = removeHead ();
        if (node.hasNext ()) {
            node.getNext ().setPrev ( node.getPrev () );
            flagNext = true;
        }
        else
            flagNext = removeTail ();
        if (flagNext&&flagPrev)
            this.size -- ;
    }

    // DONE internal UTILITY
    private boolean removeHead() {
        if ( head.hasNext () ) {
            this.head = head.getNext ();
            return true;
        } else return false;
    }

    // DONE internal UTILITY
    private boolean removeTail() {
        if ( tail.hasPrev () ) {
            this.tail = tail.getPrev ();
            return true;
        } else return false;
    }

    // NOT COMPLETE!!! We make for a Node but required for Object
    @Override
    public boolean remove (Object o) {
        return false;
    }

    // DONE
    public void removeOf (int index) {

        Node monitor = this.get ( index );

        if (monitor.hasPrev () )
            monitor.getPrev ().setNext ( monitor.getNext () );
        if (monitor.hasNext ())
            monitor.getNext ().setPrev ( monitor.getPrev () );
        this.size = this.size - 1;
    }

    // DONE
    public boolean add (Node node) {
        if ( size == 0 ) {
            this.head = node;
            this.tail = node;
        } else {
            Node<L> monitor = this.head;

            while (monitor.getNext () != null) {
                monitor = monitor.getNext ();
            }
            monitor.setNext ( node );
            node.setPrev ( monitor );
            this.tail = node;
        }

        size++;
        return true;
    }

                // NOT COMPLETE!!! We make for a Node but required for Object
                @Override
                public boolean add (Object o) {
        return false;
    }

    // DONE
    public void add (int index, Node element) {
        Node monitor = this.get ( index );

        if ( size == 0 ) {
            this.head = element;
            this.tail = element;
        } else {
            if /* Initial version: (monitor.hasPrev ())
                Tuned version: */ (index > 0) {
                element.setPrev ( monitor.getPrev () );
                monitor.getPrev ().setNext ( element );
            }else {
                addHead ( element );
            }
            element.setNext ( monitor );
            monitor.setPrev ( element );

        }
        size++;
    }

    // DONE internal UTILITY
    private void addHead(Node node) {
        this.head.setPrev ( node );
        node.setNext ( head );
        this.head = node;
    }

                // NOT COMPLETE!!! We make for a Node but required for Object
                @Override
                public void add (int index, Object element) {
                }

                // NOT COMPLETE!!! We make for a LikedList but required for Collections
                @Override
                public boolean addAll (Collection c) {
                    return false;
                }

    // DONE 2.0
    public boolean addAll (LinkedList c) {

/* Initial version: this is O(i!) realy? i.e. factorial(i)
        for (int i = 0; i < c.size (); i++) {

            this.add ( c.get ( i ) );
        }
*/
// Tuning version: this is O(4) realy? Or 0(1) ?
        if (c.size > 0) {
            this.tail.setNext ( c.head );
            c.head.setPrev ( this.tail );
            this.tail = c.tail;
            this.size += c.size;
        }
        return true;
    }

    // DONE
    public boolean addAll (int index, LinkedList c) {
        if (index == 0) {
            addAllHead(c);
        } else {
            Node monitor = get ( index );
            c.head.setPrev ( monitor.getPrev () );
            monitor.getPrev ().setNext ( c.head );

            c.tail.setNext ( monitor );
            monitor.setPrev ( c.tail );
        }
        this.size += c.size ;
        return true;
    }

    // DONE internal UTILITY
    private void addAllHead (LinkedList c) {

        this.head.setPrev ( c.tail );
        c.tail.setNext ( this.head );
        this.head = c.head;

    }

                // NOT COMPLETE!!! We make for a LikedList but required for Collections
                @Override
                public boolean addAll (int index, Collection c) {
                    return false;
                }

    // DONE
    @Override
    public void clear () {
        this.size = 0;
    }

    // DONE NEW FUNCTIONAL. Add Node by data. ( This is a Boxing? )
    public boolean addData (L l) {

        Node<L> node = new Node<> ( l );
        add ( node );
        return true;
    }

    // DONE ADD UTILITY :)
    public void printList (LinkedList list) {

        System.out.println ( "--Printing current state Linked list: --" );
        System.out.println ( "Current size LinkedList: "+ this.size );

        for (int i = 0; i < list.size (); i++) {
            System.out.println ( "Get node " + i + " data: " + list.get ( i ).getData () );
        }

        System.out.println ( "-----------Printing complete!-----------" );
        System.out.println (  );

    }


    private boolean checkIndex (int index) {
        return index >= 0 && index<=this.size  ;
    }

    @Override
    public List subList (int fromIndex, int toIndex) {
        return null;
    }

    public Iterator<Node> descendingIterator() {
        return new DescendingIterator();
    }

    private class DescendingIterator implements Iterator<Node> {
        private final ListItr itr = new ListItr(size());
        public boolean hasNext() {
            return itr.hasPrevious();
        }
        public Node next() {
            return itr.previous();
        }
        public void remove() {
//            LinkedList.this.remove ( Node  );
        }
    }

    @Override
    public boolean retainAll (Collection c) {
        return false;
    }

    @Override
    public boolean removeAll (Collection c) {
        return false;
    }

    @Override
    public boolean containsAll (Collection c) {
        return false;
    }

    @Override
    public Object[] toArray (Object[] a) {
        return new Object[0];
    }

    @Override
    public Object set (int index, Object element) {
        return null;
    }


    @Override
    public Object remove (int index) {
        return null;
    }

    @Override
    public int indexOf (Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf (Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator () {
        return null;
    }

    @Override
    public ListIterator<Node> listIterator(int index) {
//        checkPositionIndex(index);
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<Node> {
        private Node<L> lastReturned = null;
        private Node<L> next;
        private int nextIndex;
//        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : get (index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public Node next() {
//            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException ();

            lastReturned = next;
            next = next.getNext ();
            nextIndex++;
            return lastReturned;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public Node previous() {
//            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? tail : next.getPrev ();
            nextIndex--;
            return lastReturned;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
//            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<L> lastNext = lastReturned.getNext ();
            LinkedList.this.remove (lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
//            expectedModCount++;
        }

        public void set(Node e) {
            if (lastReturned == null)
                throw new IllegalStateException();
//            checkForComodification();
            lastReturned = e;
        }

        public void add(Node node) {
//            checkForComodification();
            lastReturned = null;
            if (next == null)
                add (node);
            else
                linkBefore(node, next);
            nextIndex++;
//            expectedModCount++;
        }

        private void linkBefore (Node node, Node<L> next) {

        }
/*
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
*/    }

    @Override
    public boolean contains (Object o) {
        return false;
    }

    @Override
    public Iterator iterator () {
        return null;
    }

    @Override
    public Object[] toArray () {
        return new Object[0];
    }





/*
    @Override
    public Iterator<Node> iterator () {
        return new Iterator<Node> () {
            private Node<L> current = ;

            @Override
            public boolean hasNext () {
                return (current.hasNext () != null);
            }

            @Override
            public L next () throws IndexOutOfBoundsException {
                L result = current.getData ();
                if ( !current.hasNext () ) throw new IndexOutOfBoundsException ( "End of list." );
                current = current.next;
                return result;
            }

            @Override
            public void remove () {

            }
        };

        return null;
    }
*/


}
