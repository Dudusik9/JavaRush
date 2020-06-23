package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

import java.io.ObjectInputStream;
import java.util.concurrent.RecursiveTask;

public class CachingProxyRetriever implements Retriever
{
    private OriginalRetriever originalRetriever;
    private LRUCache lruCache = new LRUCache(16);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);


    }

    @Override
    public Object retrieve(long id)
    {
        if(lruCache.find(id) != null)
            return lruCache.find(id);
        else
        {
            Object value = originalRetriever.retrieve(id);
            lruCache.set(id, value);
            return value;
        }

    }
}
