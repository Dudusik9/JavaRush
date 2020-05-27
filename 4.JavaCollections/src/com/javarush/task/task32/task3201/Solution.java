package com.javarush.task.task32.task3201;

import java.io.*;
import java.nio.file.Paths;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws FileNotFoundException, IOException
    {
//        args[0] = "C:\\Users\\dimad\\Desktop\\Git\\a.txt";
//        args[1] = "0";
//        args[2] = "INSERT";
        String fileName = args[0];
        String text = args[2];
        int number = Integer.parseInt(args[1]);

        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(fileName), "rw");
//        System.out.println(randomAccessFile.length());
//        System.out.println(text.length());
        if (randomAccessFile.length() < number)
            randomAccessFile.seek(randomAccessFile.length());
        else
            randomAccessFile.seek(number);
        randomAccessFile.write(text.getBytes());
        randomAccessFile.close();
    }
}
