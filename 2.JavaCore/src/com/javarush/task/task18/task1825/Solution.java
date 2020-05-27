package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        String s = reader.readLine();
        String fileName = s.substring(0, s.lastIndexOf(".")); // запись имени файла
        while (!s.equals("end"))
        {
            treeMap.put(Integer.parseInt(s.substring(s.lastIndexOf("t") + 1)), s);
            s = reader.readLine();
        }
        reader.close();

//        создание файла
        FileOutputStream outputStream = new FileOutputStream(fileName);
        byte[] buffer = new byte[1000];
        int count;
        for (Map.Entry<Integer, String> i : treeMap.entrySet())
        {
           FileInputStream inputStream = new FileInputStream(i.getValue());
           while (inputStream.available() > 0)
           {
               count = inputStream.read(buffer);
               outputStream.write(buffer, 0 , count);
           }
           inputStream.close();
        }
        outputStream.close();
    }
}
