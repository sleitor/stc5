package com.company;

/*
1. Напишите программу, которая каждую секунду отображает на экране данные о времени,
прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд.
Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение,
потоком, отсчитывающим время.
2. Не внося изменений в код потока-"хронометра" , добавьте еще один поток,
который выводит на экран другое сообщение каждые 7 секунд. Предполагается
использование методов wait(), notifyAll().
*/

import static java.lang.Thread.sleep;

public class Main {
    Object shared = new Object();

    static int x = 1;

    public static void main(String[] args) {
	// write your code here
/*
        Theads thead1 = new Theads();
        Thread Thread1 = new Thread(thead1);
        Thread1.start();
        try {
            thead1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        //Создание потока
        Thread thread1 = new Thread(new Runnable()
        {
            public synchronized void run() //Этот метод будет выполняться в побочном потоке
            {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 30; i++) {

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    x++;
                    System.out.println("Count(" + (x-1) +") Привет из первого потока! " + (System.currentTimeMillis()-start));
                    thead2.notifyAll();

                    //msgQueue.hasMessages();

                }

            }

        });
        thread1.start();	//Запуск потока

        //Создание потока
        final Thread thead2 = new Thread(new Runnable()
        {
            public synchronized void run() //Этот метод будет выполняться в побочном потоке
            {
                while (true) {
/*
                    try {
                        if ((x%5)==0) {
                            Thread.yield();
                        }
                        else

                        if (x==30) return;

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
*/                  if (/*(x%5)==0*/true) {
                        System.out.println("Привет из второго потока!");
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (x==30) return;
                }
            }
        });
        thead2.start();	//Запуск потока
        //Создание потока
/*
        Thread thead3 = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                System.out.println("Привет из побочного потока!");
            }
        });
        thead3.start();	//Запуск потока
/**/
        System.out.println("Главный поток завершён...");

}
}
