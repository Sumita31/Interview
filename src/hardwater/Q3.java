package hardwater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sumitachauhan on 5/10/17.
 */
public class Q3 {

    static String[] twins(String[] a, String[] b) {
        String output[] = new String[a.length];
        List<Character> aiEvenCharacters = new ArrayList<>();
        List<Character> aiOddCharacters = new ArrayList<>();

        List<Character> biEvenCharacters = new ArrayList<>();
        List<Character> biOddCharacters = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            String ai = a[i];
            String bi = b[i];
            if(ai.length() != bi.length()) {
                output[i] = "No";
            }
            else {
                aiEvenCharacters.clear();
                aiOddCharacters.clear();

                biEvenCharacters.clear();
                biOddCharacters.clear();
                for(int j = 0; j < ai.length(); j++) {
                    if(j % 2 == 0) {
                        aiEvenCharacters.add(ai.charAt(j));
                        biEvenCharacters.add(bi.charAt(j));
                    } else {
                        aiOddCharacters.add(ai.charAt(j));
                        biOddCharacters.add(bi.charAt(j));
                    }
                }
                // Sort the lists
                Collections.sort(aiEvenCharacters);
                Collections.sort(biEvenCharacters);

                Collections.sort(aiOddCharacters);
                Collections.sort(biOddCharacters);
                if(aiEvenCharacters.equals(biEvenCharacters) && aiOddCharacters.equals(biOddCharacters)) {
                    output[i] = "Yes";
                } else {
                    output[i] = "No";
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String a[] = {"cdab", "dcba"};
        String b[] = {"abcd", "abcd"};
        System.out.println(Arrays.toString(twins(a, b)));
    }

}
