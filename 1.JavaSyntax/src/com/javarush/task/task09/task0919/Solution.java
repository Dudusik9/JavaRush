package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

import java.sql.SQLOutput;

public class Solution {

    public static void main(String[] args)
    {
        try
        {
            divideByZero();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void divideByZero()
    {
        int a = 150 / 0;
        System.out.println(a);
    }
}
