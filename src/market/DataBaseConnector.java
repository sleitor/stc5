package market;


import market.db.Product;
import market.importer.ProductType;

import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.*;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class DataBaseConnector  {

    public static Connection initConnection(){

        Connection connection = null;

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection( "jdbc:mysql://sleitor.stc5.ru/demo", "demo","q1w2e3r4" );
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void createTable(){

        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
//            statement.execute( "CREATE TABLE users(id serial, uuid uuid, userName CHAR(255), email CHAR(255), firstName CHAR(255), secondName CHAR(255), lastName CHAR(255), address CHAR(255), CONSTRAINT pkey PRIMARY KEY(id) ); " );
//            statement.execute( "CREATE TABLE products( id serial, name CHAR(255), description CHAR(255), quantity integer, CONSTRAINT pkey PRIMARY KEY(id) ); " );


            statement.execute( "CREATE TABLE users( uuid CHAR(36) NOT NULL, userName CHAR(255), email CHAR(255), firstName CHAR(255), secondName CHAR(255), lastName CHAR(255), address CHAR(255), PRIMARY KEY(uuid) );" );
            statement.execute( "CREATE TABLE products( uuid CHAR(36) NOT NULL, name CHAR(255), description CHAR(255), quantity integer, PRIMARY KEY(uuid) );" );
            statement.execute( "CREATE TABLE orderProducts( uuid CHAR(36) NOT NULL, uuid_product CHAR(36) NOT NULL, count INTEGER, cost FLOAT, PRIMARY KEY(uuid), CONSTRAINT fk_orderProducts_products FOREIGN KEY (uuid_product) REFERENCES products(uuid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION );" );
            statement.execute( "CREATE TABLE orders (uuid CHAR(36) NOT NULL, uuid_user CHAR(36), date DATE, uuid_orderProducts CHAR(36), quantity FLOAT, cost FLOAT, PRIMARY KEY (uuid), FOREIGN KEY (uuid_user) REFERENCES users(uuid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY (uuid_orderProducts) REFERENCES orderProducts(uuid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION );" );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable(){

        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "DROP TABLE orders, orderProducts, users, products");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static  ArrayList<ProductType> getProducts(){

        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            ResultSet resultSet =statement.executeQuery( "SELECT * FROM products" );

            ArrayList<ProductType> data = new ArrayList<>();

            while (resultSet.next()){
                ProductType product = new ProductType();
                product.setUuid( resultSet.getString( 1 ) );
                product.setName( resultSet.getString( 2 ) );
                product.setDescription( resultSet.getString( 3 ) );
                product.setQuantity( resultSet.getInt( 4 ) );
                product.setCost( resultSet.getInt( 5 ) );
                data.add( product );
            }
            return data;

        } catch(SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


}
