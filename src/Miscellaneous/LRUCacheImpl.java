package Miscellaneous;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sumitachauhan on 2/22/17.
 */
public class LRUCacheImpl<K,V> extends LinkedHashMap<K,V>{

    private int capacity = 5;

    public LRUCacheImpl(int cap)
    {
        super(cap, 0.75f, true);
        capacity = cap;
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
    {
        return size() > capacity;
    }

}
