package hardwater;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sumitachauhan on 5/10/17.
 */
public class Q5 {

    static int[] getMinimumDifference(String[] a, String[] b) {
        int output[] = new int[a.length];

        for(int i = 0; i < a.length; i++) {

            String ai = a[i];
            String bi = b[i];
            if(ai.length() != bi.length()) {
                output[i] = -1;
            }
            else {
               int achars[] = new int[26];
               int bchars[] = new int[26];

               for(char ch : ai.toCharArray()) {
                   achars[ch - 'a'] += 1;
               }
                for(char ch : bi.toCharArray()) {
                    bchars[ch - 'a'] += 1;
                }
               int count = 0;
               for(int j = 0 ; j < 26; j++) {
                   count += Math.abs(achars[j] - bchars[j]);
               }
                output[i] = count;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String a[] = {"dnqaurlp"};
        String b[] = {"lofnrtmh"};
        System.out.println(Arrays.toString(getMinimumDifference(a, b)));
    }
}
