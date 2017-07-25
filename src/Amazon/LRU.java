package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by sumitachauhan on 7/24/17.
 */
public class LRU<K,V> {
    private class Node<K>{
        K data;
        Node next;
        Node prev;
        public Node(K key){
            this.data=key;
        }
        public int hashCode(){
            return Objects.hash(this.data);
        }
        public boolean equals(Object o){
            if(o==null || !(o instanceof Node))
                return false;
            return ((Node) o).data==this.data;
        }
    }
    private Map<K,V> map;
    private final int size;
    private Node head;
    private Node tail;
    public LRU(int size){
        this.size=size;
        map=new HashMap<K, V>(size);
    }
    public void set(K key, V val){
        if(map.size()==size){
            map.remove(tail.data);
        }
        map.put(key,val);
        setHead(key);
    }
    public V get(K key){
        if(!map.containsKey(key)){
            throw new NullPointerException("key doesn't exist");
        }
        setHead(key);
        return map.get(key);
    }
    private void setHead(K key){
      Node temp=head;
      while(!temp.data.equals(key)){
          temp=temp.next;
      }
      if(temp==null){
          Node n = new Node(key);
          n.next=head;
          head.prev=n;
          head=n;
      }
      else {
          temp.prev.next=temp.next;
          if(temp.next!=null) {
              temp.next.prev = temp.prev;
              tail=temp.prev;
          }else{
             temp.prev=null;
          }
          temp.next=head;
          head.prev=temp;
          head=temp;
      }
      if(tail==null){
         tail=head;
      }
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> obj = new LRU(4);
        obj.set(1,10);
        obj.set(2,20);
        obj.set(3,30);
        obj.set(4,40);

    }
}
