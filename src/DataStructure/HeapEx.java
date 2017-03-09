package DataStructure;

import java.util.ArrayList;

/**
 * Created by sumitachauhan on 2/17/17.
 */
public class HeapEx<T extends Comparable>{

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
    }

    private ArrayList<T> elements;

    public HeapEx()
    {
        elements = new ArrayList<T>();
    }

    public void add(T item)
    {
        elements.add(item);
        siftUp();
    }

    public void siftUp()
    {
        int c=elements.size()-1;

        while(c>0)
        {
            int p = (c-1)/2;
            T childElement = elements.get(c);
            T parentElement = elements.get(p);
            if(childElement.compareTo(parentElement)>0)
            {
                elements.set(p,childElement);
                elements.set(c, parentElement);
                c=p;
            }
            else break;
        }
    }

    public T delete()
    {
        if(elements.isEmpty())
            return null;
        if(elements.size()==1)
            return elements.remove(0);
        T hold = elements.get(0);
        elements.set(0,elements.remove(elements.size()-1));
        siftDown();
        return hold;
    }

    public void siftDown()
    {
        int p =0;
        int left = 2*p+1;
        while(left<elements.size())
        {
            int right = left+1;
            int max = left;
            if(right<elements.size()) {
                if (elements.get(max).compareTo(elements.get(right)) < 0) {
                    max = right;
                }
            }

            if(elements.get(max).compareTo(elements.get(p))>0)
            {
                T parentElement = elements.get(p);
                T childElemnt = elements.get(max);
                elements.set(p,childElemnt);
                elements.set(max, parentElement);
                p=max;
                left=2*p+1;
            }
            else break;
        }
    }
}
