package com.javarush.task.task30.task3009;

/* 
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number)
    {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int i = 2; i < 37; i++) {
            try {

                String num = Integer.toString( Integer.parseInt(number ), i );
                if (num.equals(new StringBuilder(num).reverse().toString())){
                    hashSet.add( i );
                }
            } catch (NumberFormatException e) {

            }

        }

//        Перевод из 10-й в любую систему счисления - Integer.toString(number, radix);
//        Простое правило определение палиндрома - сравнение строки со своим реверсом: (num.equals(new StringBuilder(num).reverse().toString()))
        return hashSet;
    }
}