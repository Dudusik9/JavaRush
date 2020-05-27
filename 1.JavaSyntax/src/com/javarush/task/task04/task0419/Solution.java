package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int x1 = scan.nextInt(), x2 = scan.nextInt(), x3 = scan.nextInt(), x4 = scan.nextInt();
        if(comp(x1, x2) >= comp(x3, x4))
            System.out.println(comp(x1, x2));
        else
            System.out.println(comp(x3, x4));
    }

    public static int comp(int a1, int a2)
    {
        int max;
        if(a1 <= a2)
           return max = a2;
        return max = a1;
    }
}
