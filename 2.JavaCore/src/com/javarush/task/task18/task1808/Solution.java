package com.javarush.task.task18.task1808;

/* 
Разделение файла
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
            String source = reader.readLine();
            String path1 = reader.readLine();
            String path2 = reader.readLine();
            reader.close();

            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream1 = new FileOutputStream(path1);
            FileOutputStream outputStream2 = new FileOutputStream(path2);
            int half = inputStream.available() / 2;
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            if (buffer.length / 2 == 0)
            {
                outputStream1.write(buffer, 0, half);
                outputStream2.write(buffer, half, half);
            }
            else
            {
                outputStream1.write(buffer, 0, buffer.length - half);
                outputStream2.write(buffer, buffer.length - half, half);
            }

            outputStream1.close();
            outputStream2.close();

        }
        catch (Exception e){e.printStackTrace();}


    }
}
