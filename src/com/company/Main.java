package com.company;

/*
Зделать Интернет магазин продуктов
*/

import market.DataBaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

import static market.DataBaseConnector.*;

public class Main {

    public static void main(String[] args) {

        Connection db = initConnection();

        dropTable();
        createTable();

        try {
            db.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
