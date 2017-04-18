package market.converter;


import market.importer.UserType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 17.04.2017.
 */
public class XML2Object {

    public static UserType XML2Object() {

//        UserType customer = new UserType();
//        customer.setUuid( UUID.randomUUID().toString() );
//        customer.setUserName( "mkyong" );
//        customer.setEmail( "email" );
//        customer.setFirstName( "firstName" );
//        customer.setSecondName( "secondName" );
//        customer.setLastName( "lastName" );
//        customer.setAddress( "address" );



        try {

            File file = new File( "dump/UserType.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            UserType customer = (UserType) jaxbUnmarshaller.unmarshal( file );
            System.out.println( customer );
            return customer;

        } catch(JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
