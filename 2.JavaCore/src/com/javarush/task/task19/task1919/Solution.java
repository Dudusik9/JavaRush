package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> mapa = new TreeMap<>();
        String s = "", name;
        String[] line;
        Double count = 0.0;
        while((s = reader.readLine()) != null)
        {
            line = s.split(" ");
            name = line[0].toString();
            if (mapa.get(name) != null)
            {
                count = mapa.get(name) + Double.parseDouble(line[1]);
                mapa.put(name, count);
            }
            else
                mapa.put(name, Double.parseDouble(line[1]));
        }
        reader.close();

        for(Map.Entry<String, Double> pair : mapa.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
