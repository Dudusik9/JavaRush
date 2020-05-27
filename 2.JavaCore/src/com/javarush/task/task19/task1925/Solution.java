package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String tmp = "";
        while(reader.ready())
        {
            String s = reader.readLine();
            String[] array = s.split(" ");
            for (String i : array)
            {
                if (i.length() > 6)
                    tmp = tmp + i + ",";
            }
        }
        tmp = tmp.substring(0, tmp.lastIndexOf(","));
        writer.write(tmp);
        reader.close();
        writer.close();
    }
}
