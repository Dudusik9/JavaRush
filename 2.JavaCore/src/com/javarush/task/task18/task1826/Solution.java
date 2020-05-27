package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        byte[] buffer = new byte[1000];
        int tmp = 0;

        if (args[0].equals("-e"))
        {
            while(inputStream.available() > 0)
            {
                tmp = inputStream.read() + 10;
                outputStream.write(tmp);
            }
        }
        if (args[0].equals("-d"))
        {
            while (inputStream.available() > 0)
            {
                tmp = inputStream.read() - 10;
                outputStream.write(tmp);
            }

        }
        outputStream.close();
        inputStream.close();

    }

}
