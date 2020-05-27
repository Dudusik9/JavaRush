package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> newList = new ArrayList<>();
//        int[] numbers1 = {1, 2, 3, 4, 5};
        newList.add(new int[5]);
        newList.add(new int[2]);
        newList.add(new int[4]);
        newList.add(new int[7]);
        newList.add(new int[0]);

        for(int[] i : newList)
        {
            for(int j = 0; j < i.length; j++)
                i[j] = (int) (Math.random() * 10);
        }
        return newList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
