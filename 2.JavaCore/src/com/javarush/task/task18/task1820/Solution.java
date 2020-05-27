package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            BufferedReader inputReader = new BufferedReader(new FileReader(file1));
            FileOutputStream outputStream = new FileOutputStream(file2);

            //чтение первого и запись в стринговый массив
            String[] numb = null;
            while(inputReader.ready())
            {
              numb = inputReader.readLine().split(" ");
            }
            inputReader.close();
            //округления массива стринг и запись
            int tmp;
            String s;
            for (String i : numb)
            {
                tmp = (int)Math.round(Double.parseDouble(i)); // округление до целого
                s = tmp + " ";
                outputStream.write(s.getBytes());
            }
            outputStream.close();
        }
        catch(Exception e){}

    }
}
