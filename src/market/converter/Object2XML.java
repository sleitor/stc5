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
            int i = 0;

            try {

                for (UserType user : users) {

                    File file = new File( "dump/user/UserType"+(i++)+".xml" );
                    JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( user, file );
//                    jaxbMarshaller.marshal( user, System.out );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void product2XML() {

        ArrayList<ProductType> products = DataBaseConnector.getProducts();

        if ( products.size() > 0 ) {
            int i = 0;
            try {

                for (ProductType product : products) {
                    File file = new File( "dump/product/ProductType"+(i++)+".xml" );
                    JAXBContext jaxbContext = JAXBContext.newInstance( ProductType.class );
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( product, file );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void orderProduct2XML() {

        ArrayList<OrderProductType> orderProducts = DataBaseConnector.getOrderProducts();

        if ( orderProducts.size() > 0 ) {
            int i = 0;
            try {
                File file = new File( "dump/orderProduct/OrderProductType"+(i++)+".xml" );
                JAXBContext jaxbContext = JAXBContext.newInstance( OrderProductType.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                for (OrderProductType orderProduct : orderProducts) {

                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( orderProduct, file );

                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void order2XML() {

        ArrayList<OrderType> orders = DataBaseConnector.getOrders();

        if ( orders.size() > 0 ) {
            int i = 0;
            try {
                File file = new File( "dump/order/OrderType"+(i++)+".xml" );
                JAXBContext jaxbContext = JAXBContext.newInstance( OrderType.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                for (OrderType orderProduct : orders) {

                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    jaxbMarshaller.marshal( orderProduct, file );
                }

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
    }
}
