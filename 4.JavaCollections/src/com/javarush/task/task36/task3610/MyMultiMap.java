package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;


    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size()
    {
        int size = 0;
        for(Map.Entry<K, List<V>> pair : map.entrySet())
        {
            size += pair.getValue().size();
        }
        return size;
    }

    @Override
    public V put(K key, V value)
    {
        // if key doesn't exist
        if(!map.containsKey(key))
        {
            List<V> list = new ArrayList<V>();
            list.add(value);
            map.put(key, list);
            return null;
        }
        //if key exists
        List<V> tmpList = map.get(key);
        V lastAddedValue = tmpList.get(tmpList.size() - 1);
            // we can add collection
            if(map.get(key).size() < repeatCount)
            {
                map.get(key).add(value);
                return lastAddedValue;
            }
            // repeatCount is filled
            else if(map.get(key).size() == repeatCount)
            {
                tmpList.remove(0);
                tmpList.add(value);
                map.put(key, tmpList);
                return lastAddedValue;
            }
            return null;
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)){
            return null;
        }
        List<V> ls = map.get(key);
        Object o = ls.get(0);
        ls.remove(0);
        if (ls.size() == 0) {
            map.remove(key);
        } else {
            map.put((K) key, ls);
        }
        return (V) o;
    }

    @Override
    public Set<K> keySet()
    {
        Set<K> hashSet = new HashSet<K>();
        for(Map.Entry<K, List<V>> pair : map.entrySet())
        {
            hashSet.add(pair.getKey());
        }
        return hashSet;
    }

    @Override
    public Collection<V> values()
    {
        Collection<V> allValues = new ArrayList<>();
        for(Map.Entry <K, List<V>> pair : map.entrySet())
        {
            allValues.addAll(pair.getValue());
        }
        return allValues;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        boolean exist = false;
        for(Map.Entry <K, List<V>> pair : map.entrySet())
        {
            if(pair.getValue().contains(value))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}