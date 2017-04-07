package com.company;


/*
*/

import static java.lang.Thread.sleep;

public class Main {

    private final static Object one=new Object(), two=new Object();

    public static void main(String[] args) {
	// write your code here
    Thread t1 = new Thread(){
        @Override
        public void run() {
            synchronized (one){
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (two){
                    System.out.println(Thread.currentThread().getName() +" Success!");
                }
            }
        }
    };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (two){
                    Thread.yield();
                    synchronized (one){
                        System.out.println(Thread.currentThread().getName() +" Success!");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
