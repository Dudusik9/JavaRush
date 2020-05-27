package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/*
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args)
    {
        readData();
    }

    public static void readData() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        try
        {
            while(true)
            {
                list.add(Integer.parseInt(in.readLine()));
            }
        }
        catch (Exception e)
        {
            for(Integer i : list)
                System.out.println(i);
        }
    }
}
