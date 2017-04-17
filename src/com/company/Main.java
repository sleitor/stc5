package com.company;

/*
Зделать Интернет магазин продуктов
*/

import market.DataBaseConnector;
import market.converter.Object2XML;

import java.sql.Connection;
import java.sql.SQLException;

import static market.DataBaseConnector.*;

public class Main {

    public static void main(String[] args) {

        Object2XML.Object2XML();

/*
        Connection db = initConnection();

        dropTable();
        createTable();
*/
/*
        try {
            db.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
*/
    }

}
