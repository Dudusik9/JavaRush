package com.javarush.task.task30.task3001;

import sun.util.resources.th.CalendarData_th;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args)
    {
        Number number = new Number(NumberSystemType._2, "120");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem)
    {
        try
        {
        // Получаем число в исходной системе
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        // Получаем строковое представление числа в требуемой системе счисления
        String s = bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue());
        // Возвращаем новое число
        return new Number(expectedNumberSystem, s);
        }
        catch (Exception e)
        {
            throw new NumberFormatException();
        }
    }
}
