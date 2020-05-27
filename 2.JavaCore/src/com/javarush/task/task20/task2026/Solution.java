package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args)
    {
        byte[][] a1 = new byte[][]
                {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]
                {
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a)
    {
        int count = 0, tmp = -1, itmp = a[0].length;
        boolean findRect = false;
        while (tmp != count)
        {
            tmp = count;
            findRect = false;
            itmp = a[0].length;

            outerLoop:
            for(int j = 0; j < a.length; j++)
                for(int i = 0; i < a[0].length; i++)
                {
                    if(a[j][i] == 1 && !findRect) //первый элемент прямоугольного
                    {
                        count++;
                        findRect = true;
                        itmp = i;
                        a[j][i] = 0;
                    }
                    else if (a[j][i] == 1 && findRect) // второй и последующие элементы прямоугольника
                        a[j][i] = 0;
                    else if (a[j][i] == 0 && findRect && i == itmp) // определение горизонтального диапазона прямоугольника
                    {
                        break outerLoop;
                    }
                    else if (a[j][i] == 0 && i > itmp) // определение вертикального диапазона прямоугольника
                    {
                        break;
                    }
                }
        }

        return count;
    }
}
