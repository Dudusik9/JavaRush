package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
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

        // обход коллекции и нахождение максимального значения
        Map.Entry<Integer, Integer> minValue = null; // поле для хранения максимального значения
        for (Map.Entry<Integer, Integer> pair : mapa.entrySet())
        {
            if (minValue == null || pair.getValue().compareTo(minValue.getValue()) < 0)
                minValue = pair;
        }

        // вывод на экран максимальных значений
        for (Map.Entry<Integer, Integer> pair : mapa.entrySet())
        {
            if(pair.getValue().compareTo(minValue.getValue()) == 0)
                System.out.print(pair.getKey() + " ");
        }
    }
}
