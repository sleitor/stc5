package test;

import library.Library;
import library.models.Book;
import library.models.BookInstance;
import library.models.Reader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Троицкий Дмитрий on 10.04.2017.
 */
class MainTest {

    static Library library;

    @Test
    public void buyBookTestCatalog() {
        library.buyBook( "Intro to Java", "Schildt", "1241241ada", 5, 2017 );
        assertEquals( 1, library.getCatalog().size() );
        Book book = new Book( "Schildt", "Intro to Java", 2017, "1241241ada" );
        assertTrue( library.getCatalog().contains( book ) );
        Book bookFromCatalog = library.getCatalog().iterator().next();
        assertTrue( book.getTitle().equals( bookFromCatalog.getTitle() ) );
        assertTrue( book.getAuthor().equals( bookFromCatalog.getAuthor() ) );
        assertTrue( book.getIsbn().equals( bookFromCatalog.getIsbn() ) );
        assertTrue( book.getYear() == (bookFromCatalog.getYear()) );
    }

    @Test
    public void buyBookTestStore() {
        library.buyBook( "Intro to Java", "Schildt", "1241241ada", 5, 2017 );
        assertEquals( 5, library.getStore().size() );
        Book book = new Book( "Schildt", "Intro to Java", 2017, "1241241ada" );

        for (BookInstance instance :
                library.getStore()) {

            Book bookFromStore = instance.getBook();
            assertTrue( book.getTitle().equals( bookFromStore.getTitle() ) );
            assertTrue( book.getAuthor().equals( bookFromStore.getAuthor() ) );
            assertTrue( book.getIsbn().equals( bookFromStore.getIsbn() ) );
            assertTrue( book.getYear() == (bookFromStore.getYear()) );
        }
    }

    @Test
    public void loadBookTest() {
        library.loadBook( "Intro to Java", "Schildt", "1241241ada", 2017 );
        assertEquals( 1, library.getCatalog().size() );
        Book book = new Book( "Schildt", "Intro to Java", 2017, "1241241ada" );
        assertTrue( library.getCatalog().contains( book ) );
        Book bookFromCatalog = library.getCatalog().iterator().next();
        assertTrue( book.getTitle().equals( bookFromCatalog.getTitle() ) );
        assertTrue( book.getAuthor().equals( bookFromCatalog.getAuthor() ) );
        assertTrue( book.getIsbn().equals( bookFromCatalog.getIsbn() ) );
        assertTrue( book.getYear() == (bookFromCatalog.getYear()) );
    }

    @Test
    public void loadBookInstanseTest() {

        UUID number = UUID.randomUUID();
        Book book = new Book( "Schildt", "Intro to Java", 2017, "1241241ada" );
        BookInstance testBookInstance = new BookInstance(book, number);

        library.loadBookInstance( book, number );

        assertEquals( 1, library.getStore().size() );
        assertTrue( library.getStore().contains( testBookInstance ) );
        BookInstance bookInstanceFromStore = library.getStore().iterator().next();
        assertTrue( bookInstanceFromStore.getBook().equals( book ) );
        assertTrue( bookInstanceFromStore.getNumber() == number );
    }

    @Test
    public void loadBookReaders() {
/*
    public void loadReader(String firstName, String secondName, String lastName, long passportNumber) {
        Reader newReader = new Reader(firstName, secondName, lastName, passportNumber);
        readers.add(newReader);
    }

*/
    }

    @Test
    public void takeBook () {

        Reader john = new Reader("John", "Connor", "Androidovich", 12345678);
        library.buyBook("Intro to Java", "Schildt", "1241241ada", 5, 2017);

        library.takeBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");

        assertEquals( 1, library.getCatalog().size() );
        assertEquals( 4, library.getStore().size() );
        assertEquals( 1, library.getBookings().size() );
    }

    @Test
    public void returnBook () {

        Reader john = new Reader("John", "Connor", "Androidovich", 12345678);
        library.buyBook("Intro to Java", "Schildt", "1241241ada", 5, 2017);

        library.takeBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");
        library.returnBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");

        assertEquals( 1, library.getCatalog().size() );
        assertEquals( 5, library.getStore().size() );
        assertEquals( 0, library.getBookings().size() );
    }
/*
    @Test
    public static void showAllDataTest () {

        Reader john = new Reader("John", "Connor", "Androidovich", 12345678);
        library.buyBook("Intro to Java", "Schildt", "1241241ada", 5, 2017);

        library.takeBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");
        library.returnBook("John", "Connor", "Androidovich", 12345678, "Intro to Java");

    }
 */


/*
    @AfterEach
    public void clearAll() {
        library = new Library();
    }

    @BeforeAll
    public static void init() {

        library = new Library();

    }

/**/
    @BeforeEach
    public void init() {

        library = new Library();

    }
/**/
}