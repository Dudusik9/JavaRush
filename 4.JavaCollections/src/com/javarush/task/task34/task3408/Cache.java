package com.javarush.task.task34.task3408;

import java.lang.ref.PhantomReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V>
{
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V object = cache.get(key);
        if(object == null)
        {
            try {
                //
                Constructor constructor = clazz.getConstructor(key.getClass());
                object = (V) constructor.newInstance(key);
                cache.put(key, object);
            } catch (Exception e ){}

        }

        return object;
    }

    public boolean put(V obj)
    {
        try {
            Class cls = obj.getClass();
            Method method = cls.getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K)method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (Exception e ){
            return false;
        }

    }

    public int size() {
        return cache.size();
    }
}
