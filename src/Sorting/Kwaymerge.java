package Sorting;

import java.lang.Comparable;
import java.util.PriorityQueue;

public class Kwaymerge{
    private class QNode implements Comparable {
        int array;
        int index;
        int value;
        public QNode(int arr, int indx, int val){
            this.array=arr;
            this.index = indx;
            this.value=val;
        }

        public int compareTo(Object o) {
            QNode q = (QNode)o;
            if(this.value>q.value)
                return 1;
            if(this.value<q.value)
                return  -1;
            return 0;
        }
    }
    public int[] merge(int[][] arr){
        if(arr==null)
            return null;
        int size=0;
        PriorityQueue<QNode> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            size+=arr[i].length;
            if(arr[i].length>0){
                pq.add(new QNode(i, 0, arr[i][0]));
            }
        }

        int[] result = new int[size];

        for(int i=0; !pq.isEmpty(); i++){
            QNode node = pq.poll();
            result[i]=node.value;
            int newIndex = node.index+1;
            if(newIndex<arr[node.array].length){
                pq.add(new QNode(node.array, newIndex, arr[node.array][newIndex]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A ={
                {1,10,11},
                {2,5,8},
                {3,6,9}
        };
        Kwaymerge obj = new Kwaymerge();
        int[] res = obj.merge(A);
        for(int i:res){
            System.out.print(i+", ");
        }

    }
}