package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);

    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> hashMap = new HashMap<String, Cat>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9", "name10"));
        for(String i : list)
        {
            hashMap.put(i, new Cat(i));
        }
        return hashMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<>();
        {
            for(Map.Entry<String, Cat> pair : map.entrySet()) {
                set.add(pair.getValue());
            }
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat " + this.name;
        }
    }


}
