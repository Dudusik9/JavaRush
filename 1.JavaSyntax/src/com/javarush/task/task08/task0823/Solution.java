package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        StringTokenizer str = new StringTokenizer(string);
        String upString = "";
        while(str.hasMoreTokens())
        {
            String upCase = str.nextToken();
            upCase = upCase.substring(0, 1).toUpperCase() + upCase.substring(1);
            upString = upString + upCase + " ";
        }
      System.out.println(upString);
    }
}
