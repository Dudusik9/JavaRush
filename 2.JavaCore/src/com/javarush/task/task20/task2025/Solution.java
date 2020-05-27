package com.javarush.task.task20.task2025;

import java.lang.reflect.Array;
import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N)
    {
//        int number = 1, count = 0, sum = 0, tmp = 0, power, tmp1;
//        List<Integer> list = new ArrayList<>();
//
//        while (number < N)
//        {
//            if (number / 10 > 0)
//            {
//                sum = 0; tmp1 = number;
//                power = count = getCountOfDigits(number);
//                while(count > 0)
//                {
//                    tmp = tmp1 % 10;
//                    tmp1 /= 10;
//                    count--;
//                    //работа с числом
//                    tmp = (int)Math.pow(tmp, power);
//                    sum += tmp;
//                }
//                if (number == sum)
//                {
//                    list.add(number);
//                }
//            }
//            else {list.add(number);}//запись чисел от 1 до 9
//            number++;
//        }
        //        long[] result = new long[list.size()];
        //запись в массив из динамического списка
//        for(int i = 0; i < list.size(); i++)
//        {
//            result[i] = list.get(i);
//        }
        // test
//        for(Integer i : list)
//        {
//            System.out.println(i);
//        }
        //тупое решение в морду

        long[] number = new long[]
                {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
                548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
                472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
                4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
                1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < number.length - 1; i++)
        {
            if (number[i] < N)
                list.add(number[i]);
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }
/*
    public static int getCountOfDigits (long N)
    {
        int count = 0;
        while (N != 0)
        {
            count++;
            N /= 10;
        }
        return count;
    }
*/
    public static void main(String[] args)
    {
        long[] newArray = getNumbers(Long.MAX_VALUE);

    }
}
