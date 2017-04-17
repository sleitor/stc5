package com.company;

import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Троицкий Дмитрий on 17.04.2017.
 */
public class Client {

    public static void main(String[] args) {

        Thread Server2 = new Thread( new Runnable() {
            @Override
            public void run() {

                try {
 //                   Socket socket = new Socket( "localhost", 5555 );
                    Socket socket = Main.serverSocket.accept();
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader( socket.getInputStream() )
                    );


                    while (true) {
                        String message = bufferedReader.readLine();
                        if (message != null) {
                            System.out.println( message );
                        }
                    }


                  //  socket.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }


            }
        }
        );

        Thread Client2 = new Thread( new Runnable() {
            @Override
            public void run() {

                try {
                    Socket socket = new Socket( "localhost", 5555 );
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter( socket.getOutputStream() )
                    );

                    //                    bufferedWriter.write( "Hello from client 2" );

                    Scanner in = new Scanner(System.in);


                    for(int i=0;i < 5; i++){
                        bufferedWriter.write( "Client: "+ in.next()+ "\n" );
                        bufferedWriter.flush();
                    }

                    socket.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            }
        } );

        Server2.start();
//        Client2.start();

    }

}
