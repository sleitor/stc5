package com.company;

/*
Зделать Интернет магазин продуктов
*/

import market.DataBaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Connection db = DataBaseConnector.initConnection();
        try {
            System.out.println(db.isClosed());
        } catch(SQLException e) {
            e.printStackTrace();
        }


        try {
            db.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
