package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        //
        testString.printSomething();
        System.setOut(consoleOut);
        FileOutputStream writer = new FileOutputStream(fileName);
        writer.write(outputStream.toByteArray());
        System.out.println(outputStream.toString());
        writer.close();
    }

    public static class TestString
    {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

