package com.javarush.task.task36.task3605;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        Set<Character> characterSet = new TreeSet<>();
        int symbol = bufferedReader.read();

        while(symbol != -1)
        {
            if((symbol >= 65 && symbol <= 90))
                symbol = Character.toLowerCase((char)symbol);
            characterSet.add((char)symbol);
            symbol = bufferedReader.read();
        }

        Iterator<Character> iterator = characterSet.iterator();
        int count = 0;
        while(count < 5 && iterator.hasNext())
        {
            int tmp = iterator.next();
            if((tmp >= 97 && tmp <= 122))
            {
                System.out.print((char)tmp);
                count++;
            }
        }



    }
}
