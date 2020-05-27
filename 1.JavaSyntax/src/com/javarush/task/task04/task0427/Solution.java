package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        if (1 <= a && a <= 999) {
            if (a % 2 == 0) {
                if (a / 10 != 0 && a / 100 != 0)
                    System.out.println("четное трехзначное число");
                else if (a / 10 != 0)
                    System.out.println("четное двузначное число");
                else
                    System.out.println("четное однозначное число");
            } else {
                if (a / 10 != 0 && a / 100 != 0)
                    System.out.println("нечетное трехзначное число");
                else if (a / 10 != 0)
                    System.out.println("нечетное двузначное число");
                else
                    System.out.println("нечетное однозначное число");
            }
        }

    }
}
