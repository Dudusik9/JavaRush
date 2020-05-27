package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution
{
    public static void main(String[] args)
    {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    // создание прокси объекта
    public static SomeInterfaceWithMethods getProxy()
    {
        SomeInterfaceWithMethods origin = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = origin.getClass().getClassLoader();
        Class[] interfaces = origin.getClass().getInterfaces();
        CustomInvocationHandler handler = new CustomInvocationHandler(origin);
        SomeInterfaceWithMethods proxy = (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, handler);
        return proxy;
    }
}