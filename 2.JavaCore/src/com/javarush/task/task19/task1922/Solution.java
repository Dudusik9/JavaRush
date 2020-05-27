package com.javarush.task.task19.task1922;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(s));
        int count;
        String[] array;
        while (reader.ready())
        {
            s = reader.readLine();
            array = s.split(" ");
            count = 0;
            for(String iArray : array)
            {
                for(String iWords : words)
                {
                    if (iArray.equals(iWords))
                    {
                        count++;
                    }
                }
            }
            if (count == 2)
                System.out.println(s);
        }
        reader.close();

    }
}
