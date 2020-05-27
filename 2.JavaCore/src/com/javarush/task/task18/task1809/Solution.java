package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String source = reader.readLine();
            String file = reader.readLine();
            reader.close();

            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            for (int i = buffer.length - 1; i >= 0; i--)
            {
                outputStream.write(buffer, i, 1);
            }
            outputStream.close();

        }
        catch (Exception e){e.printStackTrace();}

    }
}
