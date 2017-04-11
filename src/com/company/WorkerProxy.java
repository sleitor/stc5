package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Троицкий Дмитрий on 11.04.2017.
 */
public class WorkerProxy implements InvocationHandler {
    @Override
    public String invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        switch(method.getName()) {
//            case("hasNext"):
//        }
        return method.getName();
    }
}
