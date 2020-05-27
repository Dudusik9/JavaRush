package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();

        int dat = 0, min = 9999999;
        FileInputStream inputStream = new FileInputStream(path);
        while (inputStream.available() > 0)
        {
            dat = inputStream.read();
            if(dat < min)
                min = dat;

        }
        System.out.println(min);
        inputStream.close();
    }
}
