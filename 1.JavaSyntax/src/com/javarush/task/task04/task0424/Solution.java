package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt(), a2 = scan.nextInt(), a3 = scan.nextInt();
        if(a1 == a2)
            System.out.println(3);
        else if(a2 == a3)
            System.out.println(1);
        else if (a1 == a3)
            System.out.println(2);

    }
}
