package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws FileNotFoundException, IOException
    {
        String fileName = args[0];
        String text = args[2];
        int number = Integer.parseInt(args[1]);
        //
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(number);
        byte[] buffer = new byte[text.length()];
        randomAccessFile.read(buffer, 0, text.length());
        //
        randomAccessFile.seek(randomAccessFile.length());
        //
        if (new String(buffer).equals(text))
            randomAccessFile.write("true".getBytes());
        else
            randomAccessFile.write("false".getBytes());
    }
}
