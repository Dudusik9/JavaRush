package com.javarush.task.task22.task2209;

import javax.jnlp.ClipboardService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList();

        //чтение из файла и запись в ArrayList
        while(reader.ready())
        {
            String[] tmp = reader.readLine().split("\\s");
            //удаление всех лишних символов в массиве
            for (int i = 0; i  < tmp.length; i++) {
                tmp[i] = tmp[i].replaceAll("[^a-zA-Zа-яА-Я\\-]","");
            }
            //запись слов в ArrayList
            for(String i : tmp) {
                list.add(i);
            }
        }
        reader.close();
        Collections.sort(list);
        String[] word = list.toArray(new String[list.size()]);
        StringBuilder result = getLine(word);
//        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        List<String> tmp = Arrays.asList(words);
        StringBuilder stringBuilder = new StringBuilder();

        for(int j = 0; j < tmp.size(); j++)
        {
            for(int i = j + 1; i < tmp.size(); i++)
            {
                if (tmp.get(j).charAt(tmp.get(j).length() - 1) == tmp.get(i).toLowerCase().charAt(0))
                {
                    System.out.println( tmp.get(j) + " - " + tmp.get(i));
                    result.add(tmp.get(j));
                    result.add(tmp.get(i));
                    j = tmp.size();
                    break;
                }
            }
        }
        tmp.remove(result.get(0));



        for(String word : result)
        {
            System.out.println(word);
        }

        return null;
    }
}