package com.company;

import java.util.HashMap;
import java.util.regex.Matcher;

/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
public class Counter {

    private static HashMap<String, Integer> dictionary = new HashMap<> ();
    private static int sum = 0;
    private volatile static boolean stop = false;


    public static boolean isStop() {
        return stop;
    }

    static synchronized void count(String next) {

        int value = 0;

// разносим по разным методам проерку и подсчет.
        next = check(next);

// синхронайз здесь.
        synchronized(dictionary) {

            next = checkStop(next);
            if (next.length () == 0) return;

            if ( dictionary.containsKey( next ) ) {

                value = dictionary.get( next );
                value++;

            } else
                value = 1;

            dictionary.put( next, value );

            sum++;

            System.out.printf( "%s %10s  %25s  %4s %s %4s %s", "Поток:", Thread.currentThread ().getName (), next, value, "Обработано слов (", sum, ")" );
            System.out.println();
        }
    }

    private static String check(String next) {

        return next.replaceAll( "[\\d.,!?:/()_]+", "" );
    }

    private static String checkStop(String next){

        if (next.matches( "[a-zA-Z]+" ) && !Counter.isStop()) {

            synchronized(dictionary) {stop = true; }
            System.out.println("Внимание поток " + Thread.currentThread().getName() + " нашел латиницу в слове: "+ next +" Стоп машина!!!!!! ");
            return "";
        } else return next;

    }
}
