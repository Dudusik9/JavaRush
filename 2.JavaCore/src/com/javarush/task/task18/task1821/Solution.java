package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            FileInputStream inputStream = new FileInputStream(args[0]);
            Map<Integer, Integer> list = new TreeMap<>();
            Integer count = null, tmp;
            while (inputStream.available() > 0)
            {
                tmp = inputStream.read();
                list.put(tmp, (count = list.get(tmp)) == null ? 1 : count + 1);
            }
            inputStream.close();

            for(Map.Entry<Integer, Integer> i : list.entrySet())
            {
                System.out.println((char)i.getKey().byteValue() + " " + i.getValue());
            }
        }catch (Exception e){}
    }
}
