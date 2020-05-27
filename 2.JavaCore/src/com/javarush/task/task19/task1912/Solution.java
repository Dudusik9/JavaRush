package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream streamNew = new PrintStream(outputStream);
        System.setOut(streamNew);
        testString.printSomething();
        String s = outputStream.toString().replaceAll("te", "??");
        System.setOut(consleOut);
        System.out.println(s);
    }

    public static class TestString
    {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
