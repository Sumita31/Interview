package ByteByByte;

import java.util.*;

/**
 * Created by sumitachauhan on 7/19/17.
 */
public class StringCompression {
    public void compress(String str){
        char[] charA=str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: charA){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else map.put(c, 1);
        }
        StringBuilder res=new StringBuilder();
        Set<Character> characters = map.keySet();
        for(char c: characters){
            res.append(c);
            res.append(map.get(c));
        }
        System.out.println(res.toString());
    }

    public void compress2(String str) {
        char[] charA = str.toCharArray();
        StringBuilder res=new StringBuilder();
        int counter=1;
        char curr=charA[0];
        for(int i=1; i<charA.length; i++){
            if(charA[i]==curr){
                counter++;
            }
            else{
                res.append(curr);
                res.append(counter);
                curr=charA[i];
                counter=1;
            }
        }
        res.append(curr);
        res.append(counter);
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        obj.compress("aaabbcccc");
        obj.compress2("aaabbcccc");
    }
}
