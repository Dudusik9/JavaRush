package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Дудукино", "Дима");
        map.put("Дудукина", "Мария");
        map.put("Кинг", "Стивен");
        map.put("Сми", "Кроль");
        map.put("Смирнова", "Кроль");
        map.put("Смирнов", "Кроль");
        map.put("Смирно", "Кроль");
        map.put("Смирн", "Кроль");
        map.put("Смир", "Кроль");
        map.put("Дудукин", "Иван");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
//        for (Map.Entry<String, String> i : map.entrySet())
//        {
//            removeItemFromMapByValue(map, i.getValue());
//            System.out.println(i.getValue());
//        }
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, String> iter : map.entrySet())
        {
            list.add(iter.getValue());
        }

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)))
                {
                    removeItemFromMapByValue(map, list.get(i));
                }
            }
        }
     }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
//        System.out.println(map);
        removeTheFirstNameDuplicates(map);
//        System.out.println(map);

    }
}
