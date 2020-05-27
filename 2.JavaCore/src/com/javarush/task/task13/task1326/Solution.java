package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        // чтение значений из файла и запись в ArrayList
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        ArrayList<Integer> list = new ArrayList<>();
        s = input.readLine();
        while(s != null)
        {
            int i = Integer.parseInt(s);
            list.add(i);
            s = input.readLine();
        }
        input.close();
        // Удаление всех нечетных значений из ArrayList
        ArrayList<Integer> copyList = new ArrayList<>(list);
        for (Integer i : copyList)
        {
            if ( i % 2 != 0)
            {
//                System.out.println(i);
                list.remove(i);
            }
        }
        // сортировка ArrayList по возрастанию
        Collections.sort(list);
        for(Integer i : list)
        {
            System.out.println(i);
        }

    }
}
