package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            FileInputStream inputStream = new FileInputStream(args[0]);
            int countChar = 0, countSpace = 0, tmp;
            while (inputStream.available() > 0)
            {
                tmp = inputStream.read();
                if (tmp == 32)
                    countSpace++;
                countChar++;
            }
            inputStream.close();
            float res = (float)countSpace / countChar * 100;
            System.out.printf("%.2f", res);
        }
        catch (IOException e) {e.printStackTrace();}

    }
}
