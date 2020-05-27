package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        //создаем общую строку со всеми элементами list
        String s = "";
        for(String i : list){s += i;}
        char[] arr = s.toCharArray(); // переводим строку в символьный массив

        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        for(Character alp : alphabet)
        {
            for(Character ch : arr)
            {
                if (alp.equals(ch)) {
                    count++;
                }
            }
            result.add(alp + " " + count);
            count = 0;
        }

        for(String i : result)
        {
            System.out.println(i);
        }
    }
}
