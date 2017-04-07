package com.company;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Kvadro extends Thread {
    int d;
    String name;

    public Kvadro(int d, String s1) {
        this.d = d;
        this.name=s1;
    }

    @Override
    public void run() {
        System.out.println(name+ Thread.currentThread().getId() + " " + Consumer.sum(0,d*d,0) );
    }
}
