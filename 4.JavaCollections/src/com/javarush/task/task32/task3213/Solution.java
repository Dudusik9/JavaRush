package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0

    }

    public static String decode(StringReader reader, int key) throws IOException
    {
        if (reader == null)
            return "";
        // Вариант со StringBuilder
//        StringBuilder result = new StringBuilder();
//        int c1 = 0;
//        while((c1 = reader.read()) != -1)
//        {
//            result.append((char)(c1 + key));
//        }
//        return result.toString();

        // Вариант с StringWriter
        StringWriter result = new StringWriter();
        int oneByte = 0;
        while((oneByte = reader.read()) != -1)
        {
            result.write(oneByte + key);
        }
        return result.toString();
    }
}
