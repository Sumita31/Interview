package StringManupulation;

/**
 * Created by sumitachauhan on 6/17/17.
 */
public class PatternMatchingNaive{
    public boolean doesMatch(String str, String pattern){
        if(str==null || pattern==null || str.length ()<pattern.length ())
            return false;
        int i=0; int j=0;
        while(i<str.length () && j<pattern.length ()){
            if(str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else {
                i++;
                j=0;
            }
        }
        if(j == pattern.length ())
            return true;
        else return false;
    }

    public static void main(String[] args){
        String mainString = "SumitaChauhan";
        String pat = "chan";
        PatternMatchingNaive obj = new PatternMatchingNaive();
        System.out.println (obj.doesMatch (mainString, pat));
    }
}
