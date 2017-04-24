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

public class Main {

    public static void main(String[] args) {

        System.out.println ("Запуск основного потока.");
        System.out.println ();

        List<Integer> numbers1 = Arrays.asList(-1, 2, -3, 4, -5, 6);
        List<Integer> numbers2 = Arrays.asList(-4, 5, -6, -7, -8, 9);


//        numbers1.forEach((Integer value) -> System.out.println(value));
//        numbers2.forEach((Integer value) -> System.out.println(value));

        Integer sumOdd = numbers1.stream().filter(o -> o > 0).reduce((s1, s2) -> s1 + s2).orElse(0);



        Integer sumOd2 = numbers2.stream().filter(o -> o > 0).reduce((s1, s2) -> s1 + s2).orElse(0);

        System.out.println ("Завершение основного потока.");

    }
}
