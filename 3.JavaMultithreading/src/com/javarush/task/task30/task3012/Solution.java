package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number)
    {
        StringBuilder result = new StringBuilder(number + " =");
        List<String> list = new ArrayList<>();
        int tmp;

        // Расстановка - 0 1 в троичной сист. исчисления
        while(number != 0)
        {
            tmp = number % 3;
            number /= 3;
            if (tmp == 2)
            {
                number++;
                list.add("-");
            }
            else if (tmp == 0)
                list.add("0");
            else
                list.add("1");
        }

        // Формирование результирующий строки
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).equals("-"))
                result.append(" - " + (int) Math.pow(3, i));
            else if (list.get(i).equals("1"))
                result.append(" + "  + (int) Math.pow(3, i));
        }
        System.out.println(result);
    }
}