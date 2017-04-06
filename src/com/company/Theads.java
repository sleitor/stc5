package com.company;

/**
 * Created by Троицкий Дмитрий on 06.04.2017.
 */
public class Theads extends Thread {

    @Override
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
    }
}
