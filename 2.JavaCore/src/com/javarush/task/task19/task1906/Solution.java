package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        int count = 1;
        int tmp;
        while (fileReader.ready())
        {
            tmp = fileReader.read();
            if (count++ % 2 == 0)
                fileWriter.write(tmp);
        }
        fileWriter.close();
        fileReader.close();
    }
}
