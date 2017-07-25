package ByteByByte;

import java.util.*;

/**
 * Created by sumitachauhan on 7/19/17.
 */
public class MostFrequentString {
    public String kthMostFrequent(String[] strings, int k){
        if(k<1)
            throw new IllegalArgumentException();
        Map<String, Integer> map = new HashMap<>();
        for(String s: strings){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else {
                map.put(s, 1);
            }
        }
        List<Map.Entry> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new mapSorter());
        /*
        int t=0;
        while(t<list.size()){
        System.out.print((String)(list.get(t)).getKey()+" ");
        System.out.print((Integer) (list.get(t)).getValue());
        System.out.println();
        t++;
        }
        */
        if(list.size()>=k) return (String)(list.get(k-1)).getKey();
        return null;
    }

    public class mapSorter implements Comparator{
        public int compare(Object o1, Object o2){
            Integer first=(Integer)((Map.Entry)o1).getValue();
            Integer second=(Integer)((Map.Entry)o2).getValue();
            return -first.compareTo(second);
        }
    }

    public static void main(String[] args) {
        String[] strings={"Sumita","Sumita","is","is","is","is","my","name","Sumita","Sumita","Sumita"};
        MostFrequentString obj = new MostFrequentString();
        System.out.println(obj.kthMostFrequent(strings, 1));
    }
}
