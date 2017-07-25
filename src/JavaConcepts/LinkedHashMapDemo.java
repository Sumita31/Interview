package JavaConcepts;

import java.util.*;
public class LinkedHashMapDemo {
    public static void main(String args[]) {
        LinkedHashMapDemo obj = new LinkedHashMapDemo();
        obj.linkedMapMapEx();
        System.out.println();
        //obj.treeMapEx();
    }
    public void treeMapEx(){
        // HashMap Declaration
        TreeMap<Integer, String> lhmap =
                new TreeMap<Integer, String>();

        //Adding elements to LinkedHashMap
        lhmap.put(22, "Abey");
        lhmap.put(33, "Dawn");
        lhmap.put(1, "Sherry");
        lhmap.put(2, "Karon");
        lhmap.put(100, "Jim");

        // Generating a Set of entries
        Set set = lhmap.entrySet();

        // Displaying elements of LinkedHashMap
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print("Key: "+ me.getKey() + "\t\t" +
                    " Value: "+me.getValue()+"\n");
        }
    }
    public void linkedMapMapEx(){
        LinkedHashMap<Integer, String> lhmap =
                new LinkedHashMap<Integer, String>();

        //Adding elements to LinkedHashMap
        lhmap.put(22, "Abey");
        lhmap.put(33, "Dawn");
        lhmap.put(1, "Sherry");
        lhmap.put(2, "Karon");
        lhmap.put(100, "Jim");

        // Generating a Set of entries
        Set set = lhmap.entrySet();

        // Displaying elements of LinkedHashMap
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print("Key: "+ me.getKey() + "\t\t" +
                    " Value: "+me.getValue()+"\n");
        }

        lhmap.get(33);
        // Displaying elements of LinkedHashMap
        Iterator iterator2 = set.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me = (Map.Entry)iterator2.next();
            System.out.print("Key: "+ me.getKey() + "\t\t" +
                    " Value: "+me.getValue()+"\n");
        }
    }
}
