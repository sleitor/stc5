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

    static boolean isStop() {
        return stop;
    }

    static void count(String next) {

        int value = 0;

// разносим по разным методам проерку и подсчет.
        next = check(next);
        checkStop(next);
        if (next.length () == 0) return;

// синхронайз здесь.
        synchronized(dictionary) {

           if (stop) return;
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

    private static void checkStop(String next){

        if (next.matches( "[a-zA-Z]+" ) ) {

            stop = true;
            System.out.println( "\n-------------------Внимание поток " + Thread.currentThread().getName() + " нашел латиницу в слове: \"" + next + "\". Стоп машина!!!!!! -------------------\n" );
        }
    }
}
