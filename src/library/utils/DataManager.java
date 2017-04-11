package library.utils;

import library.Library;
import library.models.*;
import library.models.Reader;
import sun.misc.IOUtils;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergey on 05.04.17.
 */
public class DataManager {

    public static void serializeToFile(Set<Book> books, Set<Reader> readers, Set<Booking> bookings, Set<BookInstance> bookInstances ) {

        try(FileOutputStream fos = new FileOutputStream("books.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(Book book : books)
                oos.writeObject(book);

        } catch(IOException ex) {
            ex.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("readers.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(Reader reader : readers )
                oos.writeObject(reader);

        } catch(IOException ex) {
            ex.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("bookings.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(Booking booking : bookings)
                oos.writeObject(booking);

        } catch(IOException ex) {
            ex.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("bookInstances.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(BookInstance bookInstance : bookInstances)
                oos.writeObject(bookInstance);

        } catch(IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void deserialize(Library library) {
       Set<Book> books = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Book book = null;
            while((book = (Book) ois.readObject()) != null) {
                books.add(book);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for(Book book : books)
                library.loadBook(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getYear());
        }

        Set<BookInstance> bookInstances = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("bookInstances.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            BookInstance bookInstance = null;
            while((bookInstance = (BookInstance) ois.readObject()) != null) {
                bookInstances.add(bookInstance);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for(BookInstance bookInstance : bookInstances)
                library.loadBookInstance(bookInstance.getBook(), bookInstance.getNumber());
        }

        Set<Reader> readers = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("readers.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Reader reader = null;
            while((reader = (Reader) ois.readObject()) != null) {
                readers.add(reader);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for(Reader reader : readers)
                library.loadReader(reader.getFirstName(), reader.getSecondName(),reader.getLastName(),reader.getPassportNumber());
        }

        Set<Booking> bookings = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("bookings.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Booking booking = null;
            while((booking = (Booking) ois.readObject()) != null) {
                bookings.add(booking);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for(Booking booking : bookings)
                library.loadbookings(booking.getBookInstance(),booking.getReader(),booking.getStartDate(), booking.getFinishDate());
        }
    }

    public static void deserializeBook(Library library) {
        Set<Book> books = new HashSet<>();
        try(FileInputStream fis = new FileInputStream( "books.txt" );
            ObjectInputStream ois = new ObjectInputStream( fis )) {

            Book book = null;
            while ((book = (Book) ois.readObject()) != null) {
                books.add( book );
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for (Book book : books)
                library.loadBook( book.getTitle(), book.getAuthor(), book.getIsbn(), book.getYear() );
        }
    }


/*
    public static void deserializeBookInstances(Set<BookInstance> bookInstances ) {

        Set<BookInstance> bookInstances = new HashSet<>();
        try(FileInputStream fis = new FileInputStream( "bookInstances.txt" ); ObjectInputStream ois = new ObjectInputStream( fis )) {

            BookInstance bookInstance = null;
            while ((bookInstance = (BookInstance) ois.readObject()) != null) {
                bookInstances.add( bookInstance );
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for (BookInstance bookInstance : bookInstances)
                library.loadBookInstance( bookInstance.getBook(), bookInstance.getNumber() );
        }
    }
    public static void deserializeReaders(Set<Reader> readers ) {

        Set<Reader> readers = new HashSet<>();
        try(FileInputStream fis = new FileInputStream( "readers.txt" ); ObjectInputStream ois = new ObjectInputStream( fis )) {

            Reader reader = null;
            while ((reader = (Reader) ois.readObject()) != null) {
                readers.add( reader );
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for (Reader reader : readers)
                library.loadReader( reader.getFirstName(), reader.getSecondName(), reader.getLastName(), reader.getPassportNumber() );
        }
    }
    public static void deserializeBookings(Set<Booking> bookings ) {

        Set<Booking> bookings = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("bookings.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Booking booking = null;
            while((booking = (Booking) ois.readObject()) != null) {
                bookings.add(booking);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            for(Booking booking : bookings)
                library.loadbookings(booking.getBookInstance(),booking.getReader(),booking.getStartDate(), booking.getFinishDate());
        }
    }
*/
    public Collection deserializeOne(String content)
    {
        Collection collection = new HashSet<>();

        try (InputStream is = new ByteArrayInputStream(content.getBytes());
             ObjectInputStream ois = new ObjectInputStream(is))
        {
            Object elem = null;

            int count = ois.readInt();

            for (int i = 0; i < count; i++)
            {
                elem = (Object) ois.readObject();
                if (elem != null)
                {
                    collection.add(elem);
                }
            }

            String sign = (String) ois.readUTF();
            System.out.print(sign);
            System.out.println();

            ois.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return collection;
        }

    }


}
