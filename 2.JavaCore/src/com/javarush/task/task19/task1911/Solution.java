package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleStream = System.out; // original
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // new output
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream); // set new output stream
        testString.printSomething();
        String s = outputStream.toString().toUpperCase();
        System.setOut(consoleStream);
        System.out.println(s);
    }

    public static class TestString
    {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
