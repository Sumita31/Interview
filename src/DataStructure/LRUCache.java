package DataStructure;

import java.util.HashMap;
import java.util.Map;


public class LRUCache<K,V> {

    private class trackNode{
        K value;
        trackNode next;
        trackNode previous;
        public trackNode(K val)
        {
            value = val;
            next=null;
            previous=null;
        }
    }

    int capacity;
    Map<K,V> cache;
    trackNode head;
    trackNode tail;

    LRUCache(int cap)
    {
        capacity = cap;
        cache = new HashMap<K, V>(capacity);
        head=null;
        tail=null;
    }

    public void put(K key, V val)
    {
        if(cache.containsKey(key))
        {
            remove(key);
        }
        else
        {
            if(cache.size() == capacity)
            {
                remove(tail.value);
                cache.remove(key);
            }
        }

        setHead(key);
        cache.put(key,val);

    }

    public V get(K key)
    {
        if(cache.containsKey(key))
        {
            setHead(key);
            remove(key);
            return cache.get(key);
        }
        return null;
    }


    //Update the linked list to maintain the least recently used key
    public void setHead(K key)
    {
        trackNode newHead = new trackNode(key);
        if(head!=null)
        {
            newHead.next=head;
            head.previous=newHead;
        }
        else head = newHead;

        if(tail==null)
        {
            tail=head;
        }
    }

    //
    public void remove(K key)
    {
        if(head!=null)
        {
            trackNode curr = head;
            while(curr!=null)
            {
                if(curr.value.equals(key))
                {
                    if(curr.previous!=null)
                    {
                        curr.previous.next=curr.next;
                    }
                    else head=curr.next;
                    if(curr.next!=null)
                    {
                        curr.next.previous=curr.previous;
                    }
                    else tail=curr.previous;
                    break;
                }
                curr=curr.next;
            }
        }
    }

    public static void main(String[] args) {

    }
}
