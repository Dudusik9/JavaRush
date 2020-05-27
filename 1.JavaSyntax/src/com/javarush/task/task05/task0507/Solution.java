package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int count = 0;
        double sum = 0, num;
        num = in.nextDouble();
        while(num != -1)
        {
            sum += num;
            count++;
            num = in.nextDouble();
        }
        System.out.println(sum / count);
    }

}

