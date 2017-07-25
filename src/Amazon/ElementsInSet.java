package Amazon;

import java.util.*;

public class ElementsInSet {

    public boolean isPresent(List<Set<Integer>> list, Set<Integer> el){
        int n = el.size();
        for(Set<Integer> currSet:list) {
            int c = 0;
            for(int number:currSet) {
                if(el.contains(number)) {
                    c++;
                }
            }
            if(c==n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Integer> find=new HashSet<>();
        find.add(1);
        find.add(2);
        Set<Integer> num1= new HashSet<>();
        num1.add(2);
        num1.add(9);
        num1.add(5);
        Set<Integer> num2= new HashSet<>();
        num2.add(3);
        num2.add(1);
        num2.add(2);
        LinkedList<Set<Integer>> list=new LinkedList<>();
        list.add(num1);
        list.add(num2);
        ElementsInSet obj=new ElementsInSet();
        System.out.println(obj.isPresent(list, find));
    }
}
