package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        while (reader.ready())
        {
            String line =reader.readLine().replaceAll("[\\.\\,\\!\\?]","");
            String tmp = line.replaceAll("(^|[\\s])([^0-9]+)([\\s]|$)"," ");
            writer.write(tmp);
            System.out.println(tmp);
        }

        reader.close();
        writer.close();
    }
}
