package StringManupulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by sumitachauhan on 6/17/17.
 */
public class UncommonCharacters{
    public void findUncommonNaive(String one, String two){
        /*
        O(n^m)
        n-length of first string
        m-length of second string
         */
        char[] cOne = one.toCharArray ();
        char[] cTwo = two.toCharArray ();
        boolean common=true;
        for(int i=0; i< cOne.length;i++){
            for(int j=0; j<cTwo.length; j++){
                if(cOne[i]==cTwo[j]) {
                    cTwo[j]=' ';
                    common=true;
                    break;
                }
                else common=false;
            }
            if(!common){
                System.out.print (cOne[i]);
            }
        }
        for(int k=0; k<cTwo.length; k++){
            if(cTwo[k]!=' ')
                System.out.print (cTwo[k] );
        }

    }

    public void findUncommonUsingMap(String one, String two){
        Map<Character, Integer> map = new HashMap<> ();
        for(int i=0; i<one.length ();i++){
            if(map.containsKey(one.charAt(i))){

            }
            else map.put(one.charAt(i),1);
        }
        for(int i=0; i<two.length ();i++){
            if(map.containsKey(two.charAt(i)) && (map.get(two.charAt(i)) != 3)){
                map.put(two.charAt(i), map.get(two.charAt(i))+2);
            }
            else if(map.containsKey(two.charAt(i)) && (map.get(two.charAt(i)) == 3))
            {
                //map.put(two.charAt(i),2);
            }
            else map.put(two.charAt(i),2);
        }
        Set<Character> keySet2 = map.keySet ();
        for(char c:keySet2){
            if(map.get(c) != 3) {
                System.out.println (c+", "+map.get (c));
            }
        }
    }

    public static void main(String[] args){
        UncommonCharacters obj = new UncommonCharacters();
        String str1 = "suiiiim";
        String str2 = "ssmiuuuuzzzzzzzzz";
        obj.findUncommonUsingMap (str1,str2);
    }
}
