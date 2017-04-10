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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        System.out.println ("Запуск основного потока.");
        System.out.println ();

        Resource resource[] = new Resource[5];
        Reader reader[] = new Reader[10];
        long time = System.currentTimeMillis ();

        for (Integer i = 0; i < resource.length; i++) {

            resource[i] = new Resource(i.toString () , new File("src\\com\\company\\Resources\\file" + i));
            reader[i] = new Reader (resource[i]);
            reader[i].start ();
        }

        for (Integer i = 5; i < reader.length; i++) {

            try {
                resource[i-5] = new Resource(i.toString () , new URL ("https://raw.githubusercontent.com/sleitor/stc5/Lab1(multi_reader)/src/com/company/Resources/file" + (i-5)));
            } catch (MalformedURLException e) {
                System.out.println ("Невозможно получить файл по ссылке!");
            }

            reader[i] = new Reader (resource[i-5]);
            reader[i].start ();
        }

        for (int i = 0; i < reader.length; i++) {
            try {
                reader[i].join ();
            } catch (InterruptedException e) {
                System.out.println ("Невозможно присоединить потоки.");
            }catch (NullPointerException e) {
                System.out.println ("Ай-яй-яй. Ошибочка случилась");
            }
        }

        System.out.println ("\n-------------------Время выполнения программы: " + (System.currentTimeMillis () - time)+ " -------------------");
    }
}
