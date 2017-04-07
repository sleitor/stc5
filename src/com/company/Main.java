package com.company;


public class Main {

    public static void main(String[] args) {
        // write your code here

        LinkedList linkedList = new LinkedList();
//        linkedList.add("dfsd");

        System.out.println(linkedList.size() );

        linkedList.add("dfsd1");
        linkedList.add("dfsd2");
        linkedList.add("dfsd3");
        linkedList.add("dfsd4");

        System.out.println(linkedList.size() );
        System.out.println(linkedList.get(0) );
        System.out.println(linkedList.get(1) );
        System.out.println(linkedList.get(2) );
        System.out.println(linkedList.get(3) );
    }
}
