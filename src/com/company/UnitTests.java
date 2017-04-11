package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import com.company.Resource;

import static org.junit.gen5.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by Троицкий Дмитрий on 11.04.2017.
 */
public class UnitTests {

    @Test
    public void creationResourceFile() {

        Resource resource[] = new Resource[1];

        resource[0] = new Resource( "0", new File( "src\\com\\company\\Resources\\file0" ) );

        try {
            Field field0 = resource[0].getClass().getDeclaredField( "name" );
            Field field1 = resource[0].getClass().getDeclaredField( "data" );
            Field field2 = resource[0].getClass().getDeclaredField( "urldata" );

            field0.setAccessible( true );
            field1.setAccessible( true );
            field2.setAccessible( true );
            assertTrue( field0.get( resource[0] ).equals( "0" ) );
            assertTrue( field1.get( resource[0] ).equals( new File( "src\\com\\company\\Resources\\file0" ) ) );
            assertTrue( field2.get( resource[0] ) == null );
        } catch(NoSuchFieldException|IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void creationResourceURL() {

        try {
            Resource resource = new Resource( "0", new URL( "https://raw.githubusercontent.com/sleitor/stc5/Lab1(multi_reader)/src/com/company/Resources/file1" ) );


            Field field0 = resource.getClass().getDeclaredField( "name" );
            Field field1 = resource.getClass().getDeclaredField( "data" );
            Field field2 = resource.getClass().getDeclaredField( "urldata" );

            field0.setAccessible( true );
            field1.setAccessible( true );
            field2.setAccessible( true );
            assertTrue( field0.get( resource ).equals( "0" ) );
            assertTrue( field1.get( resource ) == null );
            assertTrue( field2.get( resource ).equals( new URL( "https://raw.githubusercontent.com/sleitor/stc5/Lab1(multi_reader)/src/com/company/Resources/file1" ) ) );
        } catch(IllegalAccessException|MalformedURLException|NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void workerTest() throws NoSuchFieldException {
/*
        ISInterface inputStream = (ISInterfaceImpl) Proxy.newProxyInstance(
                ISInterfaceImpl.class.getClassLoader(),
                ISInterface.class.getInterfaces(),
                new WorkerProxy()
        );

        System.out.println(inputStream.toString());;
*/

        Iterator scanner = mock( Iterator.class );
        when( scanner.next() ).thenReturn( "абракадабра" ).thenReturn( "World" );
        when( scanner.hasNext() ).thenReturn( true ).thenReturn( true ).thenReturn( false );

        assertTrue( scanner.hasNext() );

        Counter.count( scanner.next().toString() );
        assertTrue( !Counter.isStop() );
        Field sum = Counter.class.getDeclaredField("sum");
        sum.setAccessible( true );

        try {
            assertTrue(  sum.get( null ).equals( 1 ) );
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }

        assertTrue( scanner.hasNext() );

        Counter.count( scanner.next().toString() );
        assertTrue( Counter.isStop() );
/*        Field sum1 = Counter.class.getDeclaredField("sum");
        sum.setAccessible( true );
*/
        try {
            assertTrue(  sum.get( null ).equals( 1 ) );
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }

        assertTrue( !scanner.hasNext() );
    }
    //        Reader reader = new Reader(  )
}
