package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution
{

    public static void main(String[] args)
    {
//        Integer[] array = {13, 8, 15, 5, 17};
//        for(Integer i : array)
//        {
//            System.out.print(i + " ");
//        }
//        sort(array);
//        System.out.println();
//        for(Integer i : array)
//        {
//            System.out.print(i + " ");
//        }
    }

    public static Integer[] sort(Integer[] array)
    {
        Arrays.sort(array);
        double mediana;
        if (array.length % 2 == 0)
            mediana = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else
            mediana = array[array.length / 2];
        //Реализация компаратора
        Comparator<Integer> compareByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int)(Math.abs(mediana - o1) - Math.abs(mediana - o2));
            }
        };
        //Сортировка с компаратором
        Arrays.sort(array, compareByMediana);
        return array;
    }
}
