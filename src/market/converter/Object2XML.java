package market.converter;

import market.DataBaseConnector;
import market.importer.ProductType;
import market.importer.UserType;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * Created by Троицкий Дмитрий on 17.04.2017.
 */
public  class Object2XML {

    public static void user2XML() {
        UserType customer = new UserType();
        customer.setUuid( UUID.randomUUID().toString() );
        customer.setUserName( "mkyong" );
        customer.setEmail( "email" );
        customer.setFirstName( "firstName" );
        customer.setSecondName( "secondName" );
        customer.setLastName( "lastName" );
        customer.setAddress( "address" );

        try {
            File file = new File( "dump/UserType.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( customer, file );
            jaxbMarshaller.marshal( customer, System.out );

        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void product2XML() {

        ArrayList<ProductType> product = DataBaseConnector.getProducts();

        try {
            File file = new File( "dump/UserType.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( product, file );
            jaxbMarshaller.marshal( product, System.out );

        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void order2XML() {
        UserType customer = new UserType();
        customer.setUuid( UUID.randomUUID().toString() );
        customer.setUserName( "mkyong" );
        customer.setEmail( "email" );
        customer.setFirstName( "firstName" );
        customer.setSecondName( "secondName" );
        customer.setLastName( "lastName" );
        customer.setAddress( "address" );

        try {
            File file = new File( "dump/UserType.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( customer, file );
            jaxbMarshaller.marshal( customer, System.out );

        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void orderInstance2XML() {
        UserType customer = new UserType();
        customer.setUuid( UUID.randomUUID().toString() );
        customer.setUserName( "mkyong" );
        customer.setEmail( "email" );
        customer.setFirstName( "firstName" );
        customer.setSecondName( "secondName" );
        customer.setLastName( "lastName" );
        customer.setAddress( "address" );

        try {
            File file = new File( "dump/UserType.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( customer, file );
            jaxbMarshaller.marshal( customer, System.out );

        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }
}
