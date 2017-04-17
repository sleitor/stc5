package market.converter;

import market.importer.UserType;

import java.io.File;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * Created by Троицкий Дмитрий on 17.04.2017.
 */
public  class Object2XML {

    public static void Object2XML() {
        UserType customer = new UserType();
        customer.setUuid( UUID.randomUUID().toString() );
        customer.setUserName( "mkyong" );
        customer.setUserName( "email" );
        customer.setUserName( "firstName" );
        customer.setUserName( "secondName" );
        customer.setUserName( "lastName" );
        customer.setUserName( "address" );


        try {

            File file = new File( "UserType.xml" );
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
