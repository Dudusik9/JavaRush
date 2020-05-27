package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

//import sun.plugin.viewer.IExplorerPluginObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        //
        String s ="", tmp = "";
        String[] data = null;
        while(reader.ready())
        {
            s = reader.readLine();
            data = s.split("[\\W&&\\S]+");
            for (String i : data)
            {
                tmp = tmp + i;
            }
        }
        writer.write(tmp);
        writer.close();
        reader.close();
    }
}