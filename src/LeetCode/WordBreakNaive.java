package LeetCode;

import java.util.*;

/**
 * Created by sumitachauhan on 3/4/17.
 */
public class WordBreakNaive {
    public boolean wordBreak(String s, Set<String> dict) {

        return wordBreakHelper(s, dict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            //end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }

    public boolean wordBreak2(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                        break;
                    }
                }
            }
        }
        for(int x=0; x<=s.length();x++)
        {
            System.out.println(pos[x] +", ");
        }

        return pos[s.length()]!=-1;
    }

    public static void main(String[] args) {
        WordBreakNaive obj = new WordBreakNaive();
        Set<String> dictionary = new HashSet<>();
        dictionary.add("Sumita");
        dictionary.add("Chauhan");
        String str = "SumitaChauhan";
        System.out.println("result is: "+obj.wordBreak2(str, dictionary));
    }
}
