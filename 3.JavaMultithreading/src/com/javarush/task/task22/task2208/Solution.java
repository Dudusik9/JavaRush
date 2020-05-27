package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution
{
    public static void main(String[] args)
    {
        Map <String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getQuery(params));
    }
    public static String getQuery(Map<String, String> params)
    {
        StringBuilder tmp = new StringBuilder();
        for(Map.Entry pair : params.entrySet())
        {
            if (pair.getKey() != null && pair.getValue() != null)
            {
                if (!tmp.toString().equals(""))
                    tmp.append(" and ");
                tmp.append(pair.getKey() + " = '" + pair.getValue() + "'");
            }
            else
                tmp.append("");
        }
        return tmp.toString();
    }
}
