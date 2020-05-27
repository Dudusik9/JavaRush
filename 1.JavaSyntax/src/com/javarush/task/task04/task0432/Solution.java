package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String text = read.readLine();
        String n1 = read.readLine();
        int n = Integer.parseInt(n1);
        int i = 1;
        while (i <= n)
        {
            System.out.println(text);
            i++;
        }
    }
}
