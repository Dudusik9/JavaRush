package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        
        InputStream inputStream = new FileInputStream(s);
        BufferedInputStream reader1 = new BufferedInputStream(inputStream);
        while(reader1.available() > 0)
        {
            System.out.print((char) reader1.read());
        }
        inputStream.close();
        reader.close();
        
    }
}