package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt(), a2 = scan.nextInt();
        if(a1 <= a2)
            System.out.println(a1);
        else
            System.out.println(a2);
    }
}