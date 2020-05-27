package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args)
    {
        int deep = getStackTraceDepth();
    }

    public static int getStackTraceDepth() {
        int deep = 0;
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        System.out.println(deep = stack.length);
        return deep;
    }
}

