package market.converter;

import market.DataBaseConnector;
import market.importer.OrderProductType;
import market.importer.OrderType;
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
public class Object2XML {

    public static void user2XML() {

        ArrayList<UserType> users = DataBaseConnector.getUsers();

        if ( users.size() > 0 ) {

            try {
                File file = new File( "dump/UserType.xml" );
                JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                for (UserType user : users) {
                    // output pretty printed
                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( user, file );
                    jaxbMarshaller.marshal( user, System.out );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void product2XML() {

        ArrayList<ProductType> products = DataBaseConnector.getProducts();

        if ( products.size() > 0 ) {

            try {
                File file = new File( "dump/ProductType.xml" );
                JAXBContext jaxbContext = JAXBContext.newInstance( ProductType.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                for (ProductType product : products) {
                    // output pretty printed
                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( product, file );
                    jaxbMarshaller.marshal( product, System.out );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void order2XML() {

        ArrayList<OrderType> orders = DataBaseConnector.getOrders();

        if ( orders.size() > 0 ) {

            try {
                File file = new File( "dump/ProductType.xml" );
                JAXBContext jaxbContext = JAXBContext.newInstance( OrderType.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                for (OrderType order : orders) {
                    // output pretty printed
                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( order, file );
                    jaxbMarshaller.marshal( order, System.out );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void orderProduct2XML() {

        ArrayList<OrderProductType> orderProducts = DataBaseConnector.getOrderProducts();

        if ( orderProducts.size() > 0 ) {

            try {
                File file = new File( "dump/ProductType.xml" );
                JAXBContext jaxbContext = JAXBContext.newInstance( OrderType.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                for (OrderProductType orderProduct : orderProducts) {
                    // output pretty printed
                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( orderProduct, file );
                    jaxbMarshaller.marshal( orderProduct, System.out );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }
}
