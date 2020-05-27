package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    Thread current;
    @Override
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
        {
            try
            {
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().sleep(100);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

    }

    @Override
    public void start(String threadName)
    {
        current = new Thread(this);
        current.setName(threadName);
        current.start();
    }

    @Override
    public void stop()
    {
        current.interrupt();
    }
}
