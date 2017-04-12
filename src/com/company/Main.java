package com.company;

/*
Вариант 1:
Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует случайное число в
интервале [0;99]. Второй поток раз в пять секунд выводит количество уникальных чисел, сгенерированных
первым потоком. После того, как будет сгенерировано все 100 чисел, оба потока должны остановить свое выполнение.
*/

import sun.awt.windows.ThemeReader;

import java.util.HashSet;

public class Main {

    public static volatile  int sum = 0;
    public static HashSet<Integer> dic = new HashSet<Integer>( );
    volatile static boolean flag = false;
    public static Object shared = new Object();

    public static void main(String[] args) {

        Generator runnable = new Generator();
        Thread generator = new Thread(runnable);
        generator.start();


        Counter runable1 = new Counter();
        Thread counter = new Thread(runable1);
        counter.start();




    }
}
