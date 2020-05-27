package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = null;

        String result = "";
        // Пока не выполнится условия требования к паролю
        while (!(result.matches(".*[0-9]+.*") && result.matches(".*[A-Z]+.*") && result.matches(".*[a-z]+.*")))
        {
            // Запись в выходной поток 8 символов
            int count = 0;
            byteArrayOutputStream = new ByteArrayOutputStream();

            while (count < 8)
            {
                int tmp = rand();
                if(tmp <= 57 || (65 <= tmp && tmp <= 90) || 97 <= tmp)
                {
                    byteArrayOutputStream.write(tmp);
                    count++;
                }
            }
            result = byteArrayOutputStream.toString();
        }
        return byteArrayOutputStream;
    }

    // Метод генерирует рандомное число в диапозоне от 48 до 122
    public static int rand ()
    {
        return (int)(Math.random() * 75) + 48;
    }
}