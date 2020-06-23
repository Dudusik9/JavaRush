package com.javarush.task;

import java.util.*;
class Solution
{
    public Solution() {
    }

    public static void main(String[] args)
    {

       Queue<Integer> queue = new PriorityQueue<Integer>(5, new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2)
           {
               if((o1 % 2 == 0 && o2 % 2 == 0) || (o1 % 2 != 0 && o2 % 2!= 0))
                   return o1 - o2 > 0 ? 1: ((o1 - o2 == 0) ? 0 : -1);
               else if (o1 % 2 == 0 && o2 % 2 != 0)
                   return -1;
               else
                   return 1;
           }
       });

        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);

       while (!queue.isEmpty())
       {
           System.out.println(queue.poll());
       }

    }

}