package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String [] s1 = s.split("\\?", 2); // деление на две строки

        // деление итерация 2 по &
        int count = 0;
        s = s1[1];
        String [] s2 = s.split("\\&");

        //вычленяем "=" и выводим на печать
        ArrayList<String> list = new ArrayList<>();
        for (String str : s2)
        {
            if (str.contains("="))
                System.out.println(str.substring(0, str.indexOf("=")));
            else
                System.out.println(str);

            if(str.contains("obj") && str.contains("="))
                list.add(str);
            }
        // обработка obj
        int index;
        for(String str : list)
        {
            try
            {
                index = str.indexOf("=") + 1;
                s = str.substring(index);
                alert(Double.parseDouble(s));
            }
            catch(Exception e)
            {
                alert(s);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
