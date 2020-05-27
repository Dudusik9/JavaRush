package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

import org.omg.PortableServer.THREAD_POLICY_ID;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread test = new TestThread();
        test.start();
        test.interrupt();
    }
    public static class TestThread extends Thread
    {

    }
}