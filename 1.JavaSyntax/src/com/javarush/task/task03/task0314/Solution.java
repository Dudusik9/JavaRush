package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int x, y = 1;
        while (y <= 10){
            x = 1;
            while(x <= 10){
                System.out.print(x * y + " ");
                x++;
            }
            System.out.println("");
            y++;
        }
    }
}
