package com.company;

/*
Текст задачи
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket( 5555 );

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public static void main(String[] args) {

//        ServerSocket serverSocket = new ServerSocket( 5555 );


        Thread Server = new Thread( new Runnable() {
            @Override
            public void run() {

                try {
                    Socket socket = serverSocket.accept();
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader( socket.getInputStream() )
                    );

                    while (true) {
                        String message = bufferedReader.readLine();
                        if (message != null) {
                            System.out.println( message );
                        }
                    }


                    //socket.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }


            }
        }
        );

        Thread Client = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket( "localhost", 5555 );
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter( socket.getOutputStream() )
                    );

                    Scanner in = new Scanner(System.in);

                    for(int i=0;i < 5; i++){
                        bufferedWriter.write( "Main: "+ in.next()+ "\n" );
                        bufferedWriter.flush();
                    }

                    socket.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            }
        } );

        Client.start();
//        Server.start();

    }
}
