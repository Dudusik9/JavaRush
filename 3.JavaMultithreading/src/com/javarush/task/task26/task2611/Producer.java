package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable
{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map)
    {
        this.map = map;
    }
    @Override
    public void run()
    {
        try
        {
            Integer i = 1;
            while(true)
            {

                map.put(i.toString(), "Some text for " + i);
                Thread.sleep(500);
                i++;
            }
        }
        catch (Exception e)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }
}
// try {
//         int i = 0;
//         while (true)
//         {
//         queue.put(String.valueOf(i++));
//         Thread.sleep(300);
//         }
//         } catch (InterruptedException e) {
//         System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
//         }