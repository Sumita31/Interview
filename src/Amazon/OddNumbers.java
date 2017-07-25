package Amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sumitachauhan on 7/24/17.
 */
public class OddNumbers {
    public void printOdd(){
        for(int i=1; i<100; i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        OddNumbers obj = new OddNumbers();
        //obj.printOdd();

        //Iterator use for collection
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        for(int i: list){
            System.out.print(i+"\t");
        }
        System.out.println();
        System.out.println(list.size());

        Iterator i=list.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+"\t");
            i.remove();
        }
        System.out.println();
        System.out.println(list.size());
    }
}
