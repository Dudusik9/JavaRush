package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        String[] digital = outputStream.toString().split("[^+\\-*0-9]");
        System.setOut(consoleOut);

        Integer a = Integer.parseInt(digital[0]);
        Integer b = Integer.parseInt(digital[2]);

        if(digital[1].toString().equals("+"))
            System.out.printf("%d + %d = %d", a, b, a + b);
        else if (digital[1].toString().equals("-"))
            System.out.printf("%d - %d = %d", a, b, a - b);
        else if (digital[1].toString().equals("*"))
            System.out.printf("%d * %d = %d", a, b, a * b);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

