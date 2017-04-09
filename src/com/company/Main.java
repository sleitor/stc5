package com.company;

/*
Вариант 1

Необходимо разработать программу, которая получает на вход список ресурсов,
содержащих текст, и считает общее количество вхождений (для всех ресурсов)
каждого слова. Каждый ресурс должен быть обработан в отдельном потоке, текст
не должен содержать инностранных символов, только кириллица, знаки препинания
и цифры. Отчет должен строиться в режиме реального времени, знаки препинания
и цифры в отчет не входят. Все ошибки должны быть корректно обработаны,
все API покрыто модульными тестами
*/

import com.sun.istack.internal.NotNull;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        System.out.println ("Запуск основного потока.");
        System.out.println ();

        Resource resource[] = new Resource[3];

        for (Integer i = 0; i < resource.length; i++) {

            resource[i] = new Resource(i.toString () , new File("src\\com\\company\\Resources\\file" + i));
            Reader reader = new Reader (resource[i]);
            reader.start ();
        }





        System.out.println ("Завершение основного потока.");

    }
}
