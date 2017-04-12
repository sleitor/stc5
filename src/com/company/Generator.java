package com.company;


import java.util.Random;

import static com.company.Main.shared;

/**
 * Created by Троицкий Дмитрий on 12.04.2017.
 */
public class Generator implements Runnable {

    @Override
    public void run() {
        generator();
    }

    private void generator() {

        while (Main.dic.size() < 100) {
            try {
                Thread.sleep( 10 );
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            Random rnd = new Random();
            int digit = rnd.nextInt( 100 );
            System.out.println( digit );
            Main.dic.add( digit );
            synchronized(shared){
                shared.notifyAll();
            }

            Main.sum++;

//            if (Main.dic.size() > 100)
//                Main.flag = true;
//            Main.flag = (Main.dic.size() > 100);
        }


    }
}
