package StringArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class KthLargestElement {

    public int method1(int[] ar, int k)
    {
        Arrays.sort(ar);
        return ar[ar.length-k];
    }

    public int method2(int[] ar, int k, boolean minHeap)
    {
        /*
        PriorityQueue<Integer> PQ= new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int i:ar)
        {
            PQ.offer(i);
            if(PQ.size()>k)
                PQ.poll();
        }
        System.out.println("using max heap "+PQ.peek());
        */

        Comparator<Integer> normal = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> reverse = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, minHeap ? normal : reverse);
        for(int i:ar)
        {
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] ar ={2,7,11,8,9,20};
        KthLargestElement obj = new KthLargestElement();
        System.out.println(obj.method2(ar,3, true));
    }
}
