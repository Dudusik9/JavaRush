package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int a1 = in.nextInt(), a2 = in.nextInt(), a3 = in.nextInt();
        if (a1 > a2 && a1 < a3 || a1 > a3 && a1 < a2)
            System.out.println(a1);
        else if (a2 > a1 && a2 < a3 || a2 > a3 && a2 < a1)
            System.out.println(a2);
        else if (a3 > a1 && a3 < a2 || a3 > a2 && a3 < a1)
            System.out.println(a3);
    }
}
