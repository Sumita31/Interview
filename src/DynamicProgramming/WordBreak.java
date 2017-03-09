package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        Set<String> dictionary = new HashSet<>();
        dictionary.add("Sumita");
        dictionary.add("Chauhan");
        String str = "SumitaChauhan";
        System.out.println("result is: "+obj.wordBreak(str, dictionary));
    }
}
