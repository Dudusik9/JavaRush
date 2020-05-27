package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int x = 1, y = 1;
        while (y <= 10)
        {
            while(x <= 10)
            {
                System.out.print(x * y + " ");
                x++;
            }
            x = 1;
            y++;
            System.out.print("\n");
        }
    }
}
