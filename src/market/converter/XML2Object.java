package market.converter;


import market.importer.OrderProductType;
import market.importer.OrderType;
import market.importer.ProductType;
import market.importer.UserType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 17.04.2017.
 */
public class XML2Object {

    public static ArrayList<UserType> XML2User() {

        int i = 0;
        ArrayList<UserType> userTypes = new ArrayList();
        File dir = new File("dump/user/");
            for(File file : dir.listFiles()) {

                try {

                    JAXBContext jaxbContext = JAXBContext.newInstance( UserType.class );

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    UserType userType = (UserType) jaxbUnmarshaller.unmarshal( file );
                     userTypes.add( userType );

                } catch(JAXBException e) {
                    e.printStackTrace();
                }

            }
        return userTypes;
    }

    public static ArrayList<ProductType> XML2Product() {

        int i = 0;
        ArrayList<ProductType> productTypes = new ArrayList();
        File dir = new File("dump/product/");
            for(File file : dir.listFiles()) {

                try {

                    JAXBContext jaxbContext = JAXBContext.newInstance( ProductType.class );

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    ProductType productType = (ProductType) jaxbUnmarshaller.unmarshal( file );
                     productTypes.add( productType );

                } catch(JAXBException e) {
                    e.printStackTrace();
                }

            }
        return productTypes;
    }


    public static ArrayList<OrderProductType> XML2OrderProduct() {

        int i = 0;
        ArrayList<OrderProductType> orderProductTypes = new ArrayList();

        File dir = new File("dump/orderProduct/");
        for(File file : dir.listFiles()) {

            try {

                JAXBContext jaxbContext = JAXBContext.newInstance( OrderProductType.class );

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                OrderProductType orderProductType = (OrderProductType) jaxbUnmarshaller.unmarshal( file );
                orderProductTypes.add( orderProductType );

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
        return orderProductTypes;
    }

    public static ArrayList<OrderType> XML2Order() {

        int i = 0;
        ArrayList<OrderType> orderTypes = new ArrayList();

        File dir = new File("dump/order/");
        for(File file : dir.listFiles()) {

            try {

                JAXBContext jaxbContext = JAXBContext.newInstance( OrderType.class );

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                OrderType orderType = (OrderType) jaxbUnmarshaller.unmarshal( file );
                orderTypes.add( orderType );

            } catch(JAXBException e) {
                e.printStackTrace();
            }

        }
        return orderTypes;
    }
}
