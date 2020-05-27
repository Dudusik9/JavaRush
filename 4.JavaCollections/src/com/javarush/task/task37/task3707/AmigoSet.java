package com.javarush.task.task37.task3707;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable
{
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    // Создание конструкторов
    public AmigoSet()
    {
        map = new HashMap<>();
    }
    public AmigoSet(Collection <? extends E> collection)
    {
        map = new HashMap<>(Math.max(16, (int)Math.ceil(collection.size() / 0.75f)));
        this.addAll(collection);
    }
    //Своя реализация метода add
    @Override
    public boolean add(Object e)
    {
        return null == map.put((E) e, PRESENT);
    }

    @Override
    public Iterator<E> iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return null == map.remove(o);
    }

    @Override
    public Object clone()  {
        try
        {
            AmigoSet result = (AmigoSet)super.clone();
            result.map = (HashMap) map.clone();
            return result;
        }
        catch (Exception e)
        {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt(map.keySet().size());
        for(E e : map.keySet()) {
            out.writeObject(e);
        }
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap(capacity, loadFactor);
        int size = in.readInt();
        for(int i = 0; i<size; i++) {
            map.put((E)in.readObject(), PRESENT);
        }
    }




}
