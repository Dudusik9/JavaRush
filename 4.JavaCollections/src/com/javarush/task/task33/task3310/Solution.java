package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static Set<Long> getIds (Shortener shortener, Set<String> strings)
    {
        Set<Long> keys = new HashSet<>();
        for(String i : strings)
        {
            keys.add(shortener.getId(i));
        }
        return keys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> strings = new HashSet<>();
        for(Long i : keys)
        {
            strings.add(shortener.getString(i));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementNumber)
    {
        //6.2.3.1
        System.out.println(strategy.getClass().getSimpleName());
        //6.2.3.2
        Set<String> testSet = new HashSet<String>();
        for(int i = 0; i < elementNumber; i++)
            testSet.add(Helper.generateRandomString());
        //6.2.3.3
        Shortener currentShortener = new Shortener(strategy);
        // 6.2.3.4
        Date currentTime = new Date();
        Set<Long> ids = getIds(currentShortener, testSet);
        Date newTime = new Date();
        System.out.println(newTime.getTime() - currentTime.getTime());
        //6.2.3.5
        Date currentTime1 = new Date();
        Set<String> strings = getStrings(currentShortener, ids);
        Date newTime1 = new Date();
        System.out.println(newTime1.getTime() - currentTime1.getTime());

        if(testSet.size() == strings.size())
            System.out.println("Тест пройден.");
        else
            System.out.println("Тест не пройден.");

    }

    public static void main(String[] args)
    {
        testStrategy(new HashMapStorageStrategy(), 1000);
        testStrategy(new OurHashMapStorageStrategy(), 1000);
        testStrategy(new FileStorageStrategy(), 1000);
        testStrategy(new OurHashBiMapStorageStrategy(), 1000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }
}
