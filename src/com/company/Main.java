package com.company;

/*
Зделать Интернет магазин продуктов
*/

import market.DataBaseConnector;
import market.converter.Object2XML;
import market.converter.XML2Object;
import java.util.Scanner;

import static market.DataBaseConnector.*;

public class Main {

    public static void main(String[] args) {


        String x = "0";
        while (x != "5") {
            x = "0";

            System.out.println( "What do You want?" );
            System.out.println( "" );
            System.out.println( "1: Make a backup" );
            System.out.println( "2: Drop All Table" );
            System.out.println( "3: Create Table" );
            System.out.println( "4: Restore Backup" );
            System.out.println( "5: Exit" );
            System.out.print( ":->" );
            Scanner scanner = new Scanner( System.in );
            String res = scanner.next();

            switch(res) {
                case "1":

                    Object2XML.user2XML();
                    Object2XML.product2XML();
                    Object2XML.order2XML();
                    Object2XML.orderProduct2XML();
                    System.out.println( "Done!" );
                    break;
                case "2":
                    dropTable();
                    System.out.println( "Done!" );
                    break;
                case "3":
                    createTable();
                    System.out.println( "Done!" );
                    break;
                case "4":
                    DataBaseConnector.setProducts( XML2Object.XML2Product() );
                    DataBaseConnector.setUsers( XML2Object.XML2User() );
                    DataBaseConnector.setOrders( XML2Object.XML2Order() );
                    DataBaseConnector.setOrderProducts( XML2Object.XML2OrderProduct() );
                    System.out.println( "Done!" );
                    break;
                case "5":
                    System.out.println("Auf Wiedersehen!!");
                    return;
                default:
                    System.out.println( "Incorrect. Try again!" );
            }
        }
    }

}
