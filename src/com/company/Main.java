package com.company;

/*
Зделать Интернет магазин продуктов
*/

import market.DataBaseConnector;
import market.converter.Object2XML;
import market.converter.XML2Object;
import market.importer.OrderProductType;
import market.importer.OrderType;
import market.importer.ProductType;
import market.importer.UserType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static market.DataBaseConnector.*;

public class Main {

    public static void main(String[] args) {



//        Object2XML.user2XML();

//        Object2XML.product2XML();
//
//        Object2XML.user2XML();
//
//        Object2XML.order2XML();
//
//        Object2XML.orderProduct2XML();

/**/
//        ArrayList<UserType> userTypes = XML2Object.XML2User();
//        System.out.println(userTypes.size());

//        ArrayList<ProductType> productTypes = XML2Object.XML2Product();
//        System.out.println(productTypes.size());
//
//        ArrayList<OrderProductType> orderProductTypes = XML2Object.XML2OrderProduct();
//        System.out.println(orderProductTypes.size());
//
//        ArrayList<OrderType> orderTypes = XML2Object.XML2Order();
//        System.out.println(orderTypes.size());

//        DataBaseConnector.setProducts( XML2Object.XML2Product() );
        DataBaseConnector.setUsers( XML2Object.XML2User() );

/*
        dropTable();
        createTable();
/**/
    }

}
