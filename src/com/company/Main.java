package com.company;

/*
Необходимо разработать программу, которая получает на вход список ресурсов, содержащих набор
чисел и считает сумму всех положительных четных. Каждый ресурс должен быть обработан в
отдельном потоке, набор должен содержать лишь числа, унарный оператор "-" и пробелы.
Общая сумма должна отображаться на экране и изменяться в режиме реального времени.
Запуск потоков реализовать через ссылки на методы, итоговый подсчет суммы через stream API
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        System.out.println ("Запуск основного потока.");
        System.out.println ();

        List<Integer> numbers1 = Arrays.asList(-1, 2, -3, 4, -5, 6);
        List<Integer> numbers2 = Arrays.asList(-4, 5, -6, -7, -8, 6);
        List<Integer> numbers3 = Arrays.asList(-4, 5, -6, -7,  8, 6);


//        numbers1.forEach((Integer value) -> System.out.println(value));
//        numbers2.forEach((Integer value) -> System.out.println(value));

        Interfc interfc = (sum, n) -> { if (n>0 && n%2 == 0) {
            return (sum+n);}
        else {
            return sum;} };

// Вариант 1
        RunLambda runLambda = new RunLambda(interfc, numbers1);
        Thread a =  new Thread(runLambda);
        a.start();

// Вариант 2
        Thread b = new Thread( new RunLambda(interfc, numbers2));
        b.start();


// Вариант 3
 /** /
        final Integer[] sum = new Integer[1];
        numbers3.forEach(sum, num  -> {

                sum[0] =+ num;
                System.out.printf("%s: число: %4d    сумма: %4d \n", Thread.currentThread().getName(), num, sum[0]);
                Thread.yield();
        });
/**/

//Stream Api
/**/
        numbers3.parallelStream().filter((num) -> (num > 0)&&(num%2==0)).reduce((x, y)-> {
            x += y;
            System.out.printf("%s: число: %4d    сумма: %4d \n", Thread.currentThread().getName(), y, x );
            return x;
        });
/**/

        System.out.println ("Завершение основного потока.");

    }
}
