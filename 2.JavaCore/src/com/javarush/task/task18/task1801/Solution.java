package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();

        int dat = 0, max = 0;
        FileInputStream inputStream = new FileInputStream(path);
        while (inputStream.available() > 0)
        {
            dat = inputStream.read();
            if(dat > max)
                max = dat;

        }
        System.out.println(max);
        inputStream.close();
    }
}
