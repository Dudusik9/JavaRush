package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        int a1 = read.nextInt(), a2 = read.nextInt(), a3 = read.nextInt();
        int positive = 0, negative = 0;

        if (a1 > 0)
            positive++;
        else if (a1 != 0)
            negative++;
        if (a2 > 0)
            positive++;
        else if (a2 != 0)
            negative++;
        if (a3 > 0)
            positive++;
        else if (a3 != 0)
            negative++;
        System.out.println("количество отрицательных чисел: " + negative);
        System.out.println("количество положительных чисел: " + positive);


    }
}
