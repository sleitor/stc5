package com.company;

/*
Текст задачи
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    //    static ServerSocket serverSocket;
    //
    //    static {
    //        try {
    //            serverSocket = new ServerSocket( 5555 );
    //
    //        } catch(IOException e) {
    //            e.printStackTrace();
    //        }
    //    }


    public static void main(String[] args) {

        Thread Server = new Thread( new Runnable() {
            @Override
            public void run() {
               try {

                   ServerSocket serverSocket = new ServerSocket( 5555 );
                   Socket socket = serverSocket.accept();
    //               socket = serverSocket.accept();

                    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

                    while (true) {
                        String message = bufferedReader.readLine();
                        if ( message != null ) {
                            System.out.println( message );
                        }
                    }

                    //socket.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        } );

        Thread Client = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    //start Timer


                    //for (int i = 0; i < 5; i++) {
                    while (true){

                        Scanner in = new Scanner( System.in );

                        String msg = in.next();
                        //String msg = "Hello!";
//
                        if (msg != null) {

                            Socket socket = new Socket( "localhost", 5555 );
                            BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );

                            bufferedWriter.write( "Main: " + msg + "\r\n" );
                            bufferedWriter.flush();

                            socket.close();
                        }
                    }


                } catch(IOException e) {
                    e.printStackTrace();
                }

            }
        } );

        Client.start();
        Server.start();

    }
}
