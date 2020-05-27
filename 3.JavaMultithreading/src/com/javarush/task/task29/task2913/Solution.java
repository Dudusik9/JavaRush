package com.javarush.task.task29.task2913;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution
{
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b)
    {
        StringBuilder result = new StringBuilder();

        if (a < b)
        {
            for(int i = 0; i <= b - a; i++)
            {
                result.append(a + i + " ");

            }
        }
        else if (a == b)
        {
            return Integer.toString(a);
        }
        else
        {
            for (int i = 0; i <= a - b; i++ )
            {
                result.append(a - i + " ");

            }

        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}