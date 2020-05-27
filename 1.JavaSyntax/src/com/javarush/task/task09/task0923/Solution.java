package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> vowels = new ArrayList<>();
        ArrayList<String> consonants = new ArrayList<>();
        String s = in.readLine();
        char[] sToArray = s.toCharArray(); // преобразует строку в массив символов
       // Сортировка и запись в разные списки
        for(int i = 0; i < sToArray.length; i++)
        {
            if (isVowel(sToArray[i]))
            {
                vowels.add(sToArray[i] + " ");
            }
            else if(sToArray[i] != ' ')
            {
                consonants.add(sToArray[i] + " ");
            }
        }
        // Вывод на печать
        for(String i : vowels)
        {
            System.out.print(i);
        }
        System.out.println();
        for(String i : consonants)
        {
            System.out.print(i);
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d)
            {
                return true;
            }
        }
        return false;
    }
}