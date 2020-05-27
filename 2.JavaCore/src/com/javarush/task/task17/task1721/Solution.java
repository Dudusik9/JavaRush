package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            //Запись в первый файл
            BufferedReader readerFile = new BufferedReader(new FileReader(s));
            while (readerFile.ready())
            {
                allLines.add(readerFile.readLine());
            }
            readerFile.close();
            // Запись во второй файл
            s = reader.readLine();
            BufferedReader readerFile1 = new BufferedReader(new FileReader(s));
            while (readerFile1.ready())
            {
                forRemoveLines.add(readerFile1.readLine());
            }
            readerFile1.close();
            reader.close();
            //создание объекта класса для вызовы метода join()
            Solution sol = new Solution();
            sol.joinData();
        }
        catch (Exception e){}



    }

    public void joinData() throws CorruptedDataException
    {
        boolean flag = true;

        for (String s : forRemoveLines)
        {
            if (!allLines.contains(s))
                flag = false;
        }

        if(flag)
            allLines.removeAll(forRemoveLines);
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
