package com.javarush.task.task16.task1632;

import javax.swing.plaf.TableHeaderUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static
    {
        threads.add(new thread1());
        threads.add(new thread2());
        threads.add(new thread3());
        threads.add(new thread4());
        threads.add(new thread5());
    }

    public static void main(String[] args)
    {
        for(Thread thread : threads)
        {
            thread.start();
        }


//        thread3 threadTest = new thread3();
//        threadTest.start();
    }

    public static class thread1 extends Thread
    {
        public void run()
        {
            while (true){}
        }
    }

    public static class thread2 extends Thread
    {
        public void run()
        {
            try
            {
                while(true){Thread.currentThread().sleep(0);}
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class thread3 extends Thread
    {
        public void run()
        {
            try
            {
                while(true)
                {
                System.out.println("Ура");
                Thread.sleep(500);
                }
            }
            catch (Exception e) {}
        }
    }

    public static class thread4 extends Thread implements Message
    {
        public void run()
        {
            while(!this.isInterrupted()){}
        }
        public void showWarning()
        {
            if (this.isAlive())
                this.interrupt();
        }
    }

    public static class thread5 extends Thread
    {
        public void run()
        {
            try
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s = reader.readLine();
                int sum = 0;
                while(!s.equals("N"))
                {
                    sum += Integer.parseInt(s);
                    s = reader.readLine();
                }
                System.out.println(sum);
            }
            catch (Exception e ){}

        }
    }
}