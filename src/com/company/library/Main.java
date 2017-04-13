package com.company.library;

import library.Library;
import library.models.Book;
import library.models.FieldsToXML;
import library.models.Reader;
import library.utils.DataDaseManager;
import library.utils.DataManager;

public class Main {

    public static void main(String[] args) {

//        Book book = new Book( "Schildt","Intro to Java" , 2017,"1241241ada" );
//        book.print();

	// write your code here
        Library library = new Library();


        DataDaseManager connect = new DataDaseManager();
        connect.initConnection();

//        connect.insert();
        connect.select();

//        DataManager.deserialize(library);


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
 //       library.showAllData();

//        FieldsToXML.BockToXML(library.getCatalog());
//        DataManager.serializeToFile(library.getCatalog(), library.getReaders(), library.getBookings(), library.getStore());


    }
}
