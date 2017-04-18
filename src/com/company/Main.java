package com.company;

/*
Зделать Интернет магазин продуктов
*/

import market.DataBaseConnector;
import market.converter.Object2XML;
import market.converter.XML2Object;
import market.importer.UserType;

import java.sql.Connection;
import java.sql.SQLException;

import static market.DataBaseConnector.*;

public class Main {

    public static void main(String[] args) {



//        Object2XML.user2XML();

        Object2XML.product2XML();

        Object2XML.user2XML();

//        UserType customer = XML2Object.XML2Object();

//        System.out.println(customer.getAddress());



/*
        Connection db = initConnection();

        dropTable();
        createTable();
*/
    }

}
