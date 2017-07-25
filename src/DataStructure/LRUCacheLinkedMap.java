package DataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sumitachauhan on 7/24/17.
 */
public class LRUCacheLinkedMap<K, V> extends LinkedHashMap<K, V>{
    private int size;

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = LRUCacheLinkedMap.newInstance(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.put(3, 3);

        System.out.println(cache);
    }

    private LRUCacheLinkedMap(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K, V> LRUCache<K, V> newInstance(int size) {
        return new LRUCache<K, V>(size);
    }
}
