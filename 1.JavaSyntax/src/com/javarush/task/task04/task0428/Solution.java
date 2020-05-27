package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        int a1 = read.nextInt(), a2 = read.nextInt(), a3 = read.nextInt();
        int count = 0;
        if (a1 > 0)
            count++;
        if (a2 > 0)
            count++;
        if(a3 > 0)
            count++;
        System.out.println(count);


    }
}
