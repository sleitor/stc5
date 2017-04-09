package com.company;

import static com.company.Main.consumer;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Kvadro extends Thread {
    long d;
    String name;

    public Kvadro(long d, String s1) {
        this.d = d;
        this.name=s1;
    }

    @Override
    public void run() {

        synchronized (Main.kvadrator) {
            try {
                Main.kvadrator.wait ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        long result = d*d;

        consumer.set(0,result,0); // Optimization
        System.out.println("Поток: " + name + Thread.currentThread().getId() + " Число на входе: " + d + " результат вычисления: " + result );
    }
}
