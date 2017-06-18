package StringManupulation;

/**
 * Created by sumitachauhan on 6/17/17.
 */
public class FirstLetter{
    public String createString(String str){
        String[] sArray = str.split("(\\s)+");
        StringBuilder sb = new StringBuilder ();
        for(String s: sArray){
            sb.append (s.charAt(0));
        }
        return String.valueOf (sb);
    }

    public static void main(String[] args){
        FirstLetter obj = new FirstLetter();
        String str = "My      Name Is Sumita      Chauhan";
        System.out.println (obj.createString (str));
    }
}
