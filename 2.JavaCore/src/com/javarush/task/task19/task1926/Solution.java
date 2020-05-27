package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader (new FileReader(fileName));
        while (reader.ready())
        {
            StringBuilder s = new StringBuilder(reader.readLine());
            System.out.println(s.reverse());
        }
        reader.close();
    }
}
