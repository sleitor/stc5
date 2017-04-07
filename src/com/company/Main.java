package com.company;

import static java.lang.Thread.sleep;

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
    private final static Object shared = new Object();

    volatile static Integer x = 0;

    public static void main(String[] args) {
	// write your code here

        System.out.println("Главный поток завершён...");
        int sim[] = new int[5];
        sim[0] = 36;
        sim[1] = 338;
        sim[2] = 65;
        sim[3] = 56;
        sim[4] = 35;

        for (int i = 0; i < sim.length; i++) {
            Simple simple = new Simple(sim[i], "Simple-");
            simple.start();
        }
        int doub[] = new int[3];
        doub[0] = 36;
        doub[1] = 45;
        doub[2] = 65;

        for (int i = 0; i < doub.length; i++) {
            Kvadro kvadro = new Kvadro(doub[i], "Double-");
            kvadro.start();
        }
        int kub[] = new int[3];
        kub[0] = 1;
        kub[1] = 2;
        kub[2] = 3;

        for (int i = 0; i < kub.length; i++) {
            Kube kube = new Kube(doub[i], "Kube-");
            kube.start();
        }
    }
}
