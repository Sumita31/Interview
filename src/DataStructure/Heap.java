package DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by sumitachauhan on 5/24/17.
 */
public class Heap<T extends Comparable> {
    private List<T> heapList;

    public Heap(){
        heapList = new ArrayList<T>();
    }

    private void siftUP(){
        int child = heapList.size()-1;
        int parent = (child-1)/2;
        while(child<0){
            T childVal = heapList.get(child);
            T parentVal = heapList.get(parent);
            if(childVal.compareTo(parentVal)>0){
                heapList.set(parent, childVal);
                heapList.set(child, parentVal);
                child=parent;
            }
        }
    }

    private void siftDown(){
        heapList.set(0,heapList.remove(heapList.size()-1));
        int parent =0;
        int leftChild = parent*2+1;

        while(leftChild < heapList.size()){
            int rightChild = leftChild+1;
            int max = leftChild;
            if(rightChild < heapList.size()){
                if(heapList.get(leftChild).compareTo(heapList.get(rightChild))>0){

                }
                else max=rightChild;
            }
            if(heapList.get(max).compareTo(heapList.get(parent))>0){
                T item = heapList.get(parent);
                heapList.set(parent, heapList.get(max));
                heapList.set(max, item);
                parent = max;
                leftChild=2*parent+1;
            }
        }
    }
    public void insert(T item){
        heapList.add(item);
        siftUP();
    }
    public T delete() throws NoSuchElementException{
        if(heapList.isEmpty())
             throw new NoSuchElementException();
        if(heapList.size()==1)
            return heapList.remove(0);
        T hold = heapList.get(0);
        siftDown();
        return hold;

    }

    public static void main(String[] args) {
        HeapEx obj = new HeapEx();
        obj.add(10);
        obj.add(15);
        obj.add(1);
        obj.add(17);
        obj.add(19);
        System.out.println(obj.delete());
        System.out.println(obj.delete());
        System.out.println(obj.delete());
        System.out.println(obj.delete());
        obj.add(190);
        obj.add(0);
        System.out.println(obj.delete());
    }
}
