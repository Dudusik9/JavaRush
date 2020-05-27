package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Д1", 455);
        map.put("Д2", 556);
        map.put("Д3", 557);
        map.put("Д4", 558);
        map.put("Д5", 355);
        map.put("Д6", 559);
        map.put("Д7", 560);
        map.put("Д8", 455);
        map.put("Д9", 10);
        map.put("Д10", 561);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
//        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
////        while(iter.hasNext())
////        {
////            iter.next();
////            if (iter.next().getValue() < 500)
////                iter.remove();
////        }
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> maps = createMap();
        removeItemFromMap(maps);
//        System.out.println(maps);
    }
}