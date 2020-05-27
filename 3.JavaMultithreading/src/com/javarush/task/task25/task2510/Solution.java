package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution()
    {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            public void uncaughtException(Thread t, Throwable e)
            {
                if(e.getClass().getSimpleName().contains("Throwable"))
                    System.out.println("Поживем - увидим");
                else if(e.getClass().getSimpleName().contains("Exception"))
                    System.out.println("Надо обработать");
                else
                    System.out.println("Нельзя дальше работать");
            }
        });

    }

    public static void main(String[] args)
    {
//        Solution sol = new Solution()
//        {
//            @Override
//            public void run() {
//                throw new Error();
//            }
//        };
//        sol.start();

    }
}
