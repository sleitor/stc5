package market;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            statement.execute( "CREATE TABLE users(id serial, userName character varying(255), emailName character varying(255), firstName character varying(255), secondName character varying(255), lastName character varying(255), address character varying(255), CONSTRAINT pkey PRIMARY KEY(id) ); " );
            statement.execute( "CREATE TABLE products( id serial, name character varying(255), description character varying(255), quantity integer, CONSTRAINT pkey PRIMARY KEY(id) ); " );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable(){

        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "DROP TABLE users, products");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


}
