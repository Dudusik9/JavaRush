package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
// import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception, NullPointerException 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> mapa = new HashMap<>();
       while(true)
       {
           String s = reader.readLine();
           if(s.isEmpty()) break;
           String s1 = reader.readLine();
           int id = Integer.parseInt(s);
           String name = s1;
           mapa.put(name, id);
       }
        
        for(HashMap.Entry<String, Integer> pair : mapa.entrySet())
        {
           
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}