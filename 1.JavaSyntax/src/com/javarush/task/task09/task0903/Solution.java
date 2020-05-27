package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Solution {
    public static void main(String[] args)
    {
        method1();
    }

    public static int method1() {
        method2();
        StackTraceElement[] stacktraceelements1 = Thread.currentThread().getStackTrace();
        System.out.println(stacktraceelements1[2].getMethodName());
        System.out.println(stacktraceelements1[2].getLineNumber());
        return  stacktraceelements1[2].getLineNumber();
    }

    public static int method2() {
        method3();
        StackTraceElement[] stacktraceelements2 = Thread.currentThread().getStackTrace();
        return  stacktraceelements2[2].getLineNumber();
    }

    public static int method3() {
        method4();
        StackTraceElement[] stacktraceelements3 = Thread.currentThread().getStackTrace();
        return  stacktraceelements3[2].getLineNumber();
    }

    public static int method4() {
        method5();
        StackTraceElement[] stacktraceelements4 = Thread.currentThread().getStackTrace();
        return  stacktraceelements4[2].getLineNumber();
    }

    public static int method5() {
        StackTraceElement[] stacktraceelements5 = Thread.currentThread().getStackTrace();
        return  stacktraceelements5[2].getLineNumber();
    }
}
