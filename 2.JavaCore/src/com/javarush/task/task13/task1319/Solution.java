package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
//        DataOutputStream out = new DataOutputStream(new FileOutputStream(s));
//        BufferedWriter out = new BufferedWriter(new FileWriter(s));
        FileWriter file1 = new FileWriter(s);
        BufferedWriter out = new BufferedWriter(file1);
        while (!s.equals("exit"))
        {
            s = reader.readLine();
            out.write(s + "\n");
        }
        out.close();
        reader.close();
    }
}
