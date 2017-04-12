package com.company;

import static com.company.Main.shared;

/**
 * Created by Троицкий Дмитрий on 12.04.2017.
 */
public class Counter implements Runnable {

    @Override
    public void run() {
        count();
    }

    private void count() {

        while (Main.dic.size() < 100) {
            synchronized(shared) {
                try {
                    shared.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }

//            System.out.println("sdljgs" + Main.sum%5);

            if (Main.sum%5 == 0 )
                System.out.println("Количество сгенерированных чисел: " + Main.sum + ". Количество уникалльных:"  +Main.dic.size());
        }


    }
}
