package com.javarush.task.task18.task1810;

/* 
DownloadException
*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file;
            FileInputStream inputStream;
            while (true)
            {
                file = reader.readLine();
                inputStream = new FileInputStream(file);
                if (inputStream.available() < 1000)
                {
                    reader.close();
                    inputStream.close();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        throw new DownloadException();
    }

    public static class DownloadException extends Exception
    {}
}
