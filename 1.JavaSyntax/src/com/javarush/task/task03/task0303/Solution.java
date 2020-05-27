package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10, 2));
        System.out.println(convertEurToUsd(1, 5.5));
    }

    public static double convertEurToUsd(int eur, double course) {
        double doll;
        return doll = eur * course;

    }
}
