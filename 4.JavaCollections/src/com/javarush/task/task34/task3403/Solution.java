package com.javarush.task.task34.task3403;

import java.util.ArrayList;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution
{

    public void recurse(int n)
    {
//         filling an array with primes
        ArrayList<Integer> array = new ArrayList<>();
        int prime = 0;
        for(int i = 2; i <= n; i++)
        {
            for(int j = i; j > 1; j--)
            {
                if(i % j == 0)
                    prime++;
            }
            if(prime == 1)
                array.add(i);
            prime = 0;
        }
       // recursion
        for(int i = 2; i <= n; i ++)
        {
            if(n % i == 0 && array.contains(i))
            {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }

    }

    // Additional code for self-test
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.recurse(132);
    }
}
