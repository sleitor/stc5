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

public class Main {

    static Object shared = new Object ();

    static Integer x = 0;

    public static void main(String[] args) {
	// write your code here

        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 31; i++) {
                    System.out.println("Count(" + (x) +") Привет из первого потока! " + (System.currentTimeMillis()-start));
/* DOES NOT WORK!!!
                    synchronized (x) {
                        x.notifyAll ();
                    }
DOES NOT WORK!!! */
                    synchronized (shared) {
                        shared.notifyAll ();
                    }
                    try {
                        Thread.sleep ( 1000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                    x++;
                }
                System.out.println ("Первый поток завершен....");
            }
        });
        thread1.start();

        Thread thead2 = new Thread(new Runnable() {

            public void run() {

                while (true) {
                    if ((x%5)==0) {
                        System.out.println("ПРИВЕТ ИЗ ВТОРОГО ПОТОКА!");
                    }
/* DOES NOT WORK!!!
                    synchronized (x) {
                        try {
                            x.wait ();
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                    }
DOES NOT WORK!!! */
                    synchronized (shared) {
                        try {
                            shared.wait ();
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                    }

                    if (x==30) {
                        System.out.println ("ВТОРОЙ ПОТОК ЗАВЕРШЕН....");
                        return;
                    }
                }
            }
        });
        thead2.start();

// Такой синтаксис тоже допустим?
        Thread thread3 = new Thread (  ) {

            public void run () {

                for (int i = 0; i < 30; i++) {
                    if (x % 7 == 0){
                        System.out.println ("ПРИВЕТ ИЗ ТРЕТЬЕГО ПОТОКА!");
                    }
                    synchronized (shared){
                        try {
                            shared.wait ();
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                System.out.println ("ТРЕТИЙ ПОТОК ЗАВЕРШЕН!");
            }
        };
        thread3.start ();

        System.out.println("Главный поток завершён...");
    }
}
