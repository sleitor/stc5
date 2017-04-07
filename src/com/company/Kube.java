package com.company;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Kube extends Thread {
    int k;
    String name;

    public Kube(int k, String s1) {
        this.k = k;
        this.name=s1;
    }

    @Override
    public void run() {
        System.out.println(name+ Thread.currentThread().getId() + " " + Consumer.sum(k*k*k,0,0) );
    }
}
