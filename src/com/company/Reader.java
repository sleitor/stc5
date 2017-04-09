package com.company;


import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
public class Reader extends Thread {

    Resource resource;
    Scanner scanner;

    public Reader(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run () {

        try {
            scanner = new Scanner (this.resource.getData ());
        } catch (FileNotFoundException e) {
            System.out.println ("Ошибка!!! Файл " + this.resource.getData () + " неудалось открыть.");
            return;
        }

        System.out.println ( Thread.currentThread ().getName () + " Выбранный ресурс: file" + this.resource.getName () );
        while (scanner.hasNext ()){
            Counter.check (scanner.next ());
        }

    }
}
