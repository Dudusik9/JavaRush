package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String longs, shorts;
        int longi, shorti;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // считывание строк с клавиатуры
        for (int i = 0; i < 10; i++)
        {
            list.add(in.readLine());
        }
        //определение самой короткой строки и ее номер
        shorts = list.get(0);
        shorti = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (shorts.length() > list.get(i).length())
            {
                shorts = list.get(i);
                shorti = i;
            }
        }
        //определение самой длиной строки
        longs = list.get(0);
        longi = 0;
        for(int i = 0; i < list.size(); i++)
        {
            if(longs.length() < list.get(i).length())
            {
                longs = list.get(i);
                longi = i;
            }
        }
        //определение которая строка появляется раньше
        if (shorti > longi)
            System.out.println(longs);
        else
            System.out.println(shorts);
    }
}
