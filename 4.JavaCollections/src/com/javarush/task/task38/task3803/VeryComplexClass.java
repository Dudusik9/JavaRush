package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.io.ByteArrayOutputStream;

public class VeryComplexClass {
    public void methodThrowsClassCastException()
    {
        Object character = new Character('F');
        System.out.println((Byte)character);
    }

    public void methodThrowsNullPointerException()
    {
        int[] array = new int[1];
        array = null;
        int i = array.length;
    }

    public static void main(String[] args) {

    }
}
