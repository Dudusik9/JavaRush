package com.javarush.task;
import java.io.*;
import java.util.*;


public class Dud {
    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException
    {
//        System.out.println(binarySearch(new int[] {1, 2, 3, 4, 5, 6, 100}, 6));
        int[] array = new int[] {1, 2, 3, 4};
        System.out.println(binaryRecurse( array, 2, 0, array.length - 1));

    }

//    public static int binarySearch(int[] array, int key)
//    {
//        int low = 0;
//        int high = array.length - 1;
//        while(low <= high)
//        {
//            int middle = low + (high - low)/2;
//            if(key < array[middle])
//                high = middle - 1 ;
//            else if (key > array[middle])
//                low = middle  + 1;
//            else
//                return middle;
//        }
//        return -1;
//    }

    public static int binaryRecurse (int [] array, int key, int low, int high)
    {
        int middle = 0;
        if (low <= high)
            middle = low + (high - low) / 2;
        else
            return -222;
        if(key < array[middle])
        {
            return binaryRecurse(array, key, low, middle - 1);
        }
        else if (key > array[middle])
        {
             return binaryRecurse(array, key, middle + 1, high);
        }
        else if (array.length == 0)
            return -1;
        else if (key == array[middle])
            return middle;

        return -111;
    }

}
