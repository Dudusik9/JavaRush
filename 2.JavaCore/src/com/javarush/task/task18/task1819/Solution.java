package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

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
            reader.close();

            FileInputStream inputStream = new FileInputStream(file1);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            FileInputStream inputStream1 = new FileInputStream(file2);
            FileOutputStream outputStream = new FileOutputStream(file1);
            byte[] buffer1 = new byte[2000]; int count;
            while(inputStream1.available() > 0)
            {
                count = inputStream1.read(buffer1);
                outputStream.write(buffer1, 0, count);
            }
            outputStream.write(buffer, 0, buffer.length);
            inputStream1.close();
            outputStream.close();
        }
        catch(Exception e){}

    }
}
