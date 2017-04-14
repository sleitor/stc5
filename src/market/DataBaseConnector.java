package market;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


}
