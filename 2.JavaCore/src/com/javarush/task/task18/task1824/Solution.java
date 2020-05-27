package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        String s = null;

            while(true)
            {
                s = reader.readLine();
                try
                {
                    inputStream = new FileInputStream(s);
                    inputStream.close();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println(s);
                    break;
                }
            }
            reader.close();



    }
}
