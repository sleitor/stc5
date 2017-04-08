package com.company;


import java.util.List;

import static java.lang.System.gc;

public class Main {

    public static void main(String[] args) {
        // write your code here





        LinkedList linkedList = new LinkedList();
//        linkedList.add("dfsd");

        System.out.println("Size before add data - " + linkedList.size() );

        for (int i = 0; i <4 ; i++) {
            linkedList.addData ("dfsd" + (i+1) );
        }

        System.out.println("Size after add data - " + linkedList.size() );
        System.out.println();

        linkedList.printList(linkedList);

        System.out.println("Try delete the 2-nd Node( index 1 ):");
        System.out.println();

        linkedList.removeOf(1);
        linkedList.printList(linkedList);

        System.out.println("Try delete the 1-st Node( index 0 ) by link on Node:");
        System.out.println();

        linkedList.remove ( linkedList.get ( 0 ) );
        linkedList.printList(linkedList);

        System.out.println("Try add Node by Node:");
        System.out.println();

        Node addNode = new Node ( "Added node" );
        linkedList.add (addNode );
        linkedList.printList(linkedList);

        System.out.println("Try clearing the Linked List:");
        System.out.println();

        linkedList.clear ();
        linkedList.printList(linkedList);

        System.out.println("Try add Node by Node after clearing:");
        System.out.println();

        Node addNode1 = new Node ( "Added node1" );
        linkedList.add (addNode1 );
        linkedList.printList(linkedList);

        gc();

        System.out.println("Try add Creating new LinkedList and add new to current:");
        System.out.println();

        LinkedList newLinkedList = new LinkedList();
        for (int i = 0; i <3 ; i++) {
            newLinkedList.addData ("new data" + (i+1) );
        }
        linkedList.addAll (newLinkedList);
        linkedList.printList (linkedList);

        System.out.println("Try add Node by Node  to LinkedList in center:");
        System.out.println();

        Node addNode2 = new Node ( "Added node1 to center" );
        linkedList.add (2,addNode2 );
        linkedList.printList(linkedList);

        List sd = new java.util.LinkedList (  );

        System.out.println("Try add Creating new new LinkedList and add new to current in center:");
        System.out.println();

        LinkedList newNewLinkedList = new LinkedList();
        for (int i = 0; i <3 ; i++) {
            newNewLinkedList.addData (" new new data" + (i+1) );
        }
        linkedList.addAll (2,newNewLinkedList);
        linkedList.printList (linkedList);

    }
}
