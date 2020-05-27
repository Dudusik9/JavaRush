package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)
    {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String path = reader.readLine();
            reader.close();
            FileInputStream input = new FileInputStream(path);
            int count = 0;
            while (input.available() > 0)
            {
                if (input.read() == 44)
                    count++;
            }
            input.close();
            System.out.println(count);
        }
        catch (Exception e ){}


    }
}
