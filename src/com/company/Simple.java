package com.company;

import sun.awt.windows.ThemeReader;

import static com.company.Main.consumer;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Simple extends Thread {
    long s;
    String name;

    public Simple(long s, String s1) {
        this.s = s;
        this.name=s1;
    }
/*
    @Override
    public void setName(String name) {
        this.name = s1;
    }
*/
    @Override
    public void run() {

        synchronized (Main.single) {

            try {
                Main.single.wait ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        long result = s;

        consumer.set(0,0,result); // Optimization
        System.out.println("Поток: " + name + Thread.currentThread().getId() + " Число на входе: " + s + " результат вычисления: " + result );
    }
}

