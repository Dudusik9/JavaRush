package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            FileInputStream inputStream = new FileInputStream(args[0]);
            int count = 0, tmp = 0;
             while (inputStream.available() > 0)
            {
                tmp = inputStream.read();
                if ((tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122))
                    count++;
            }
            inputStream.close();
            System.out.println(count);
        }
        catch (IOException e) {e.printStackTrace();}




    }
}
