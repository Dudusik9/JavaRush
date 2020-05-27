package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        int count = 0;
        String s = "";
        //создание регулярного выражения для поиска слова world
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher;

        while (reader.ready())
        {
            s = reader.readLine();
            matcher = pattern.matcher(s);
            while(matcher.find())
            {
                count++;
            }
        }
        reader.close();
        System.out.println(count);
    }
}
