package com.company;

import sun.awt.windows.ThemeReader;

/**
 * Created by Троицкий Дмитрий on 07.04.2017.
 */
public class Simple extends Thread {
    int s;
    String name;

    public Simple(int s, String s1) {
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
        System.out.println(Thread.currentThread().getName() + name+ Thread.currentThread().getId() + " " + Consumer.sum(0,0,s) );
    }
}

