package library.utils;


import java.sql.*;

/**
 * Created by Троицкий Дмитрий on 13.04.2017.
 */
public class DataDaseManager {

    public Connection initConnection() {
        Connection connection = null;

        try {
            Class.forName( "org.postgresql.Driver" );
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection( "jdbc:postgresql://localhost/library", "demo","q1w2e3r4" );
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void insert(){
        Connection connection = initConnection();
        try {
            PreparedStatement statement = connection.prepareStatement( "INSERT  INTO book(" +
                    "book_author, book_title,book_isbn,book_year)" +
                    "VALUES (?,?,?,?)" );
            statement.setString( 1,"NeShildt" );
            statement.setString( 2,"PHP" );
            statement.setString( 3,"2342342342df" );
            statement.setInt( 4,2017 );
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(){

        Connection connection = initConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM  public.book" );

            while (result.next()) {
                System.out.println(result.getInt( 1 ));
                System.out.println(result.getString( 2 ));
                System.out.println(result.getString( 3 ));
                System.out.println(result.getString( 4 ));
                System.out.println(result.getString( "book_year" ));


            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

//    public void insert(){}
//    public void insert(){}

    public void createTable(){

        Connection connection = initConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery( "CREATE TABLE book(\n" + "    book_id serial NOT NULL,\n" + "    book_author character varying(255),\n" + "    book_title character varying(255),\n" + "    book_isbn character varying(255),\n" + "    book_year integer,\n" + "    CONSTRAINT book_pkey PRIMARY KEY\n" + "    (book_id)\n" + ")\n" + "WITH (\n" + "\tOIDS=FALSE\n" + ");  \n" + "\n" + "CREATE TABLE reader(\n" + "    rdr_id serial NOT NULL,\n" + "    rdr_first_name character varying(255),\n" + "    rdr_second_name character varying(255),\n" + "    rdr_last_name character varying(255),\n" + "    rdr_passport_number character varying(255),\n" + "    CONSTRAINT rdr_pkey PRIMARY KEY\n" + "    (rdr_id)\n" + ")\n" + "WITH (\n" + "\tOIDS=FALSE\n" + ");\n" + "\n" + "CREATE TABLE book_instance(\n" + "  bin_id serial NOT NULL,\n" + "  bin_uuid uuid,\n" + "  book_book_id integer NOT NULL,\n" + "  CONSTRAINT bin_pkey PRIMARY KEY (bin_id),\n" + "  CONSTRAINT fk_book_instance__book FOREIGN KEY (book_book_id)\n" + "      REFERENCES book (book_id) MATCH SIMPLE\n" + "      ON UPDATE NO ACTION ON DELETE NO ACTION\n" + ")\n" + "WITH (\n" + "  OIDS=FALSE\n" + ");\n" + "\n" + "CREATE TABLE booking(\n" + "    bkg_id serial NOT NULL,\n" + "    rdr_reader_id integer NOT NULL,\n" + "    book_book_id integer NOT NULL,\n" + "    bkg_start_date date,\n" + "    bkg_finish_date date,\n" + "    bkg_return_date date,\n" + "    CONSTRAINT bkg_pkey PRIMARY KEY (bkg_id),\n" + "    \n" + "    CONSTRAINT fk_booking_reader FOREIGN KEY (rdr_reader_id)\n" + "      REFERENCES reader(rdr_id) MATCH SIMPLE\n" + "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + "    \n" + "    CONSTRAINT fk_booking__bin FOREIGN KEY (book_book_id)\n" + "      REFERENCES book_instance (bin_id) MATCH SIMPLE\n" + "      ON UPDATE NO ACTION ON DELETE NO ACTION\n" + ")\n" + "WITH (\n" + "\tOIDS=FALSE\n" + ");" );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
