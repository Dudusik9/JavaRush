package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.runtime.ECMAException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();
            reader.close();

            FileOutputStream outputStream = new FileOutputStream(file1);
            FileInputStream inputStream1 = new FileInputStream(file2);
            FileInputStream inputStream2 = new FileInputStream(file3);
            // Запись блоками из 2 в 1 файл
            byte[] buff = new byte[2000];
            int count;
            while (inputStream1.available() > 0)
            {
                count = inputStream1.read(buff);
                outputStream.write(buff, 0, count);
            }
            inputStream1.close();
            //запись из 3 в 1 файл
            while (inputStream2.available() > 0)
            {
                count = inputStream2.read(buff);
                outputStream.write(buff, 0, count);
            }
            inputStream2.close();
            outputStream.close();

        }
        catch (Exception e){e.printStackTrace();}
    }
}
