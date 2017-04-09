package com.company;

import static com.company.Main.consumer;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Kube extends Thread {
    long k;
    String name;

    public Kube(long k, String s1) {
        this.k = k;
        this.name=s1;
    }

    @Override
    public void run() {
        synchronized (Main.kubator) {
            try {
                Main.kubator.wait ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        long result = k*k*k;

        consumer.set(result,0,0); // Optimization
        System.out.println("Поток: " + name + Thread.currentThread().getId() + " Число на входе: " + k + " результат вычисления: " + result );
    }
}
