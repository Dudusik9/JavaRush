package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        HashMap<Integer, Integer> mapa = new HashMap<>();
        Integer tmp, count = null;
        // Запись байтов в мапу
        FileInputStream inputStream = new FileInputStream(path);
        while(inputStream.available() > 0 )
        {
            tmp = inputStream.read();
            count = mapa.get(tmp);
            mapa.put(tmp, count == null ? 1 : count + 1);
        }
        inputStream.close();

        // Запись ключей в массив
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> pair : mapa.entrySet())
        {
            list.add(pair.getKey());
        }

        // сортировка массива и вывод нв экран
        Collections.sort(list);
        for(Integer i : list)
        {
            System.out.print(i + " ");
        }

    }
}
