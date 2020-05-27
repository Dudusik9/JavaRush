package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            List<String> list = new  ArrayList<>();
            String s = reader.readLine();
            //
            while(!s.equals("exit"))
            {

                list.add(s);
                s = reader.readLine();
            }
            reader.close();
            //
            for(String string : list)
            {
                ReadThread thread = new ReadThread(string);
                thread.start();
                thread.join();
            }
        }
        catch (Exception e){}

    }

    public static class ReadThread extends Thread
    {
        private static String fileName;
        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream inputStream = new FileInputStream(fileName);
                Map<Integer, Integer> mapa = new HashMap<>();

                Integer count = null, tmp, max = null, key = null;
                while(inputStream.available() > 0)
                {
                    tmp = inputStream.read();
                    count = mapa.get(tmp);
                    mapa.put(tmp, count == null ? 1 : count + 1);
                }
                inputStream.close();
                for (Map.Entry<Integer, Integer> pair : mapa.entrySet())
                {
                    if (max == null || pair.getValue() > max)
                    {
                        max = pair.getValue();
                        key = pair.getKey();
                    }
                }
                resultMap.put(fileName, key);
            }
            catch(Exception e){}
        }
    }
}
