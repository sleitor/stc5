package com.company.library;

import library.Library;
import library.models.Book;
import library.models.FieldsToXML;
import library.models.Reader;
import library.utils.DataDaseManager;
import library.utils.DataManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

////    private static final Logger logger = Logger.getLogger( Main.class );
    //    static Logger logger = Logger.getLogger(CustomLog.class);
    //
    //
    //    static {
    //        DOMConfigurator.configure( "customlog.xml" );
    // //       PropertyConfigurator.configure( "log4j.properties" );
    // //       PropertyConfigurator.configure( "log4j.properties" );
    //
    //    }

    public static void main(String[] args) {
//        logger.debug( "Hello, World!" );
//        Book book = new Book( "Schildt","Intro to Java" , 2017,"1241241ada" );
//        book.print();

	// write your code here
        Library library = new Library();

//        logger.info(1);
//        logger.error(2);


//
//        DataDaseManager connect = new DataDaseManager();
//        connect.initConnection();
//
////        connect.insert();
//        connect.select();
//
        DataManager.deserialize(library);


//        DataManager.deserializeBook(library);
/*        DataManager.deserializeBook(library);
        DataManager.deserializeBook(library);
/*
        Reader john = new Reader("John", "Connor", "Androidovich", 12345678);
        Reader sara = new Reader("Sara", "Connor", "Human", 12345679);

        library.buyBook("Intro to Java", "Schildt", "1241241ada", 5, 2017);
        library.buyBook("How to hack Pentagon", "Snowden", "54524dfh", 5, 2015);

        library.takeBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");
        library.takeBook("Sara", "Connor", "Human", 12345679, "How to hack Pentagon");

        library.returnBook("John", "Connor", "Androidovich", 12345678,
                "Intro to Java");
/**/
        library.showAllData();

//        FieldsToXML.BockToXML(library.getCatalog());
//        DataManager.serializeToFile(library.getCatalog(), library.getReaders(), library.getBookings(), library.getStore());


    }
}
