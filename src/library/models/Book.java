package library.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by sergey on 05.04.17.
 */
public class Book implements Serializable {
    private String author;
    private String title;
    private int year;
    private String isbn;
    private static long serialVersionUID = 2L;

    public void print(){

        System.out.println(Book.class.getCanonicalName());
        for (Method met : this.getClass().getMethods()) {
            System.out.println(met.getName());
            System.out.println(met.getReturnType().getName());
            for (Parameter param:
                 met.getParameters()) {

                System.out.println(param.getName() + " " + param.getType().getName());
            }
            System.out.println(met.getModifiers());

        }
        try {
            for (Field field : Class.forName( "library.models.Book" ).getFields()) {
                System.out.println(field.getName());
                System.out.println(field.getType().getName());
                System.out.println(field.isAccessible());
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Book(String author, String title, int year, String isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Book))
            return false;

        if (!this.isbn.equals(((Book) obj).isbn))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return author + "@" + title + "@" + year + "@" + isbn;
    }
}
