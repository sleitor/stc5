package com.company;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Троицкий Дмитрий on 09.04.2017.
 */
public class Reader extends Thread {

    private Resource resource;

    public Reader(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run () {
        worker();
    }

    private void worker() { // вынести в отдельный метод

        long time = System.currentTimeMillis ();
        Scanner scanner;

        if ( resource.getData() != null ) {  // проверку по дате.   или урлу
            try {
                scanner = new Scanner (this.resource.getData ());
            } catch (FileNotFoundException e) {
                System.out.println ("Ошибка!!! Файл " + this.resource.getData () + " неудалось открыть.");
                return;
            }
        } else {
            try {
                scanner = new Scanner (this.resource.getUrldata ().openStream());
            } catch (IOException e1) {
                System.out.println ("Ошибка!!! Что вы пытаетесь мне скормить??? " + this.resource.getUrldata () + " неудалось открыть. Файл существует?");
                return;
            }
        }

        System.out.println ( Thread.currentThread ().getName () + " Выбранный ресурс: file" + this.resource.getName () );

        while (scanner.hasNext ()&& !Counter.isStop()){
            Counter.count( scanner.next ());
        }

        System.out.println ("Время выполнения потока " + Thread.currentThread ().getName () + ": " + (System.currentTimeMillis () - time));

    }
}
