package com.company;

/*
Написать программу для вычисления многочлена с использованием собственного семафора.
 1) Вид многочлена- а^3 + b^2 + c
 2) Использовать для вычисления куба, квадрата и c- отдельные классы
 3) Результат выводить в режиме реального времени в класс потребитель (Consumer). Использовать его функцию с
 3мя аргументами met(int kube, int kvadro, int simple)
 3.1) Если функцию Consumer-а вызывает Кубатор- то он передает в нее такие аргументы (число, 0, 0)
 3.2) Если функцию Consumer-а вызывает Квадратор- то он передает в нее такие аргументы (0, число, 0)
 3.3) Если функцию Consumer-а вызывает Простатор- то он передает в нее такие аргументы (0, 0, число)
 4) Условие семафора- допускается одновременный вызов метода Consumer-а РАЗНЫМИ классами
 4.1) Пример: Кубатор, Квадратор параллельно- можно
 4.2) Пример: Кубатор, Кубатор- нельзя
 5) На вход в каждый вычислитель- идет массив числе
 5.1) ЧИсла можно забить самим*/

public class Main {

    final static Object kubator = new Object(), kvadrator = new Object(), single = new Object ();
    public static Consumer consumer = new Consumer ();
    volatile static Integer x = 0;

    public static void main(String[] args) {
	// write your code here


        //Количество потоков для Кубатора, Квадратора, Сингла
        int s = 5;
        int d = 7;
        int k = 10;



        long sim[] = new long[s];
        for (int i = 0; i < s; i++) {
            sim[i] = Math.round (1 +(Math.random () + Math.random ()+ Math.random () + Math.random ())*10 + Math.random ()*7+ Math.random ()*4);
            Simple simple = new Simple(sim[i], "Simple-");
            simple.start();
        }

        long doub[] = new long[d];
        for (int i = 0; i < d; i++) {
            doub[i] = Math.round (1 + (Math.random () + Math.random ()+ Math.random () + Math.random ())*5 + Math.random ()*7+ Math.random ()*4 );
            Kvadro kvadro = new Kvadro(doub[i], "Double-");
            kvadro.start();
        }

        long kub[] = new long[k];
        for (int i = 0; i < k; i++) {
            kub[i] = Math.round (1 + (Math.random () + Math.random ()+ Math.random () + Math.random ())*5 + Math.random ()*7+ Math.random ()*4 );
            Kube kube = new Kube(kub[i], "Kube-");
            kube.start();
        }

        long sum = 0;

        while (true) {
            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
//            synchronized (Consumer.consumer) {
            synchronized (single) {
                single.notify ();

            }
/* NOT Working
            yield ();
NOT Working */
            try {
                Thread.sleep ( 0,1 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }


            synchronized (kvadrator) {
                kvadrator.notify ();

            }
/* NOT Working
            yield ();
NOT Working */
            try {
                Thread.sleep (0,1);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            synchronized (kubator) {
                kubator.notify ();

            }
/* NOT Working
            yield ();
NOT Working */
            try {
                Thread.sleep ( 0,1 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

            sum = consumer.sum ();
            System.out.println ("Сумма симафора = " + consumer.sum ());
            System.out.println ();
            consumer.clear ();

            if (sum == 0 ) {
                System.out.println ("Похоже, больше нечего считать. Завершаем вычисления");
                break;
            }

            sum = 0;
        }

        System.out.println("Главный поток завершён...");
    }
}
