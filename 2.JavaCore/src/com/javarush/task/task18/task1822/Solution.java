package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            List<String[]> list = new ArrayList<>();
            String[] mass = null;
            while(fileReader.ready())
            {
                list.add(fileReader.readLine().split(" "));
            }
            fileReader.close();

            for (String[] i : list)
            {
                if(args[0].equals(i[0]))

                {
                    System.out.println(" Id " + " productName " +  "quantity "  + " price ");
                    for(int j = i.length; j >= 0; j--)
                        System.out.print(i[i.length - j] + " ");
                }
            }
        }catch (Exception e){}
    }
}