package library.models;

import library.Library;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Троицкий Дмитрий on 11.04.2017.
 */
public class FieldsToXML {

    public static void BockToXML(Set<Book> catalog) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();

            // root Element
            Element books = doc.createElement( "Books" );
            doc.appendChild( books );

            for (Book book : catalog ) {

                // Book Element
                Element bookEl = doc.createElement( "Book" );
                books.appendChild( bookEl );

                // Fields Element
                Element fields = doc.createElement( "Fields" );
                books.appendChild( fields );


                for (Field field : book.getClass().getDeclaredFields()) {

                    // field Element
                    Element fieldEl = doc.createElement( field.getName() );
                    fields.appendChild( fieldEl );

                    fieldEl.setAttribute( "type",field.getType().getName() );

                    fieldEl.appendChild(
                    doc.createTextNode("value"));
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource( doc );
            StreamResult result = new StreamResult( new File( "store.xml" ) );
            StreamResult consoleResult = new StreamResult( System.out );
            transformer.transform( source, consoleResult );
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
