package library.models;

import library.Library;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by Троицкий Дмитрий on 11.04.2017.
 */
public class FieldsToXML {

    private static Book book;

    public static void BockToXML(Set<Book> catalog) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();
            Document doc2 = dbBuilder.newDocument();

            // root Element
            Element books = doc.createElement( "Books" );
            doc.appendChild( books );

            for (Book book : catalog ) {

                // Book Element
                Element bookEl = doc.createElement( "Book" );
                books.appendChild( bookEl );

                // Fields Element
                Element fields = doc.createElement( "Fields" );
                bookEl.appendChild( fields );


                for (Field field : book.getClass().getDeclaredFields()) {

                    field.setAccessible( true );
                    Element fieldEl = doc.createElement( "field" );
                    fields.appendChild( fieldEl );

                    fieldEl.setAttribute( "name",field.getName() );
                    fieldEl.setAttribute( "type",field.getType().getName() );
                    fieldEl.setAttribute( "value",field.get(book).toString() );
/*
                    fieldEl.appendChild(
                        doc.createTextNode( field.get(book).toString() )
                    );
*/
                }
            }

//            // root Element
//            Element methhods = doc.createElement( "Methods" );
//            doc.appendChild( methhods );

            Element methods = doc.createElement( "Methods" );
            books.appendChild( methods );

            for (Method met : catalog.getClass().getMethods()) {

                // Method Element
                Element method = doc.createElement( "Method" );
                methods.appendChild( method );

//                    field.setAccessible( true );
                Element metEl = doc.createElement( "field" );
                method.appendChild( metEl );

                metEl.setAttribute( "name",met.getName() );
//                metEl.setAttribute( "type",met.getAnnotatedReturnType().toString() );
//                    metEl.setAttribute( "value",field.get(book).toString() );
/*
                fieldEl.appendChild(
                    doc.createTextNode( field.get(book).toString() )
                );
*/



            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty( OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource( doc );
            StreamResult result = new StreamResult( new File( "catalog.xml" ) );
            transformer.transform(source, result);
            StreamResult consoleResult = new StreamResult( System.out );

            transformer.transform( source, consoleResult );

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
