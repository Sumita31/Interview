package StringArray;

import java.lang.String;
/**
 * Created by sumitachauhan on 2/23/17.
 */
public class strstr {

    public void needleHaystack(String text, String pattern)
    {
        if(text == null || pattern == null || text.length()<pattern.length() || text.length()<=0 || pattern.length()<=0)
        {
            System.out.println("Wrong input values");
            System.exit(1);
        }
        char[] textA = text.toCharArray();
        char[] patternA = pattern.toCharArray();

        int i=0, j=0, k=0;
        while(i<textA.length && j<patternA.length)
        {
            if(textA[i] == patternA[j])
            {
                i++;
                j++;
            }
            else
            {
                j=0;
                k++;
                i=k;
            }
        }
        if(j==patternA.length)
        {
            System.out.println("pattern exists in the text");
        }
        else System.out.println("pattern doesn't exist in the text");
    }

    public static void main(String[] args) {
        strstr obj = new strstr();
        String text = "ankjhueyrubjndfklorigh";
        String pattern ="right";
        obj.needleHaystack(text, pattern);
    }
}
