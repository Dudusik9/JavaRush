package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
        {
            list.add(Integer.parseInt(in.readLine()));
        }

        int count = 0, tmp = 1;

        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).equals(list.get(i + 1)))
            {
                tmp++;
            }
            else
                tmp = 1;

            if (tmp > count)
            {
                count = tmp;
            }
        }
        System.out.println(count);
    }
}