package com.javarush.task.task30.task3008;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String s = null;
        try
        {
            s = bufferedReader.readLine();
        }
        catch(IOException e)
        {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            s = readString();
        }
        return s;
    }

    public static int readInt()
    {
        Integer i = null;
        try
        {
            i = Integer.parseInt(readString());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            i = readInt();
        }
        return i;
    }
}
