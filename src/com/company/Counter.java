package com.company;

import java.util.HashMap;

/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
public class Counter {

    private static HashMap<String, Integer> dictionary = new HashMap<> ();
    private static int sum = 0;
    synchronized static void check (String next) {

        int value = 0;
        next = next.replaceAll ( "[\\d.,!?a-zA-Z:/()_]+","" );
        if (next.length () == 0) return;
        if (dictionary.containsKey ( next )) {

            value = dictionary.get ( next );
            value++;

        } else value =1;

            dictionary.put ( next, value );

        sum++;

        System.out.printf ("%25s  %4s %s %4s %s",next, value , "Обработано слов (", sum ,")");
        System.out.println ();
    }
}
