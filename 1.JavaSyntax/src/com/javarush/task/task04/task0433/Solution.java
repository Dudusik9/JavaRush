package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        int x = 0, y = 0;
        while(y < 10)
        {
            while (x < 10)
            {
                System.out.print("S");
                x++;
            }
            x = 0;
            y++;
            System.out.print("\n");

        }

    }
}
