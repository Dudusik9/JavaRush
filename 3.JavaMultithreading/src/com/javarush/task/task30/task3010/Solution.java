package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args)
    {
        Boolean flag = false;
            for (int i = 2; i < 37; i++)
            {
                try
                {
                    BigInteger bigInteger = new BigInteger(args[0], i);
                    flag = true;
                    System.out.println(i);
                    break;
                }
                catch (Exception e){}
            }
            if (!flag)
                System.out.println("incorrect");
    }
}