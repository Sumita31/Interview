package StringManupulation;

import java.util.LinkedList;
import java.util.List;


public class FindSubString{
    public List<String> subString(String str){
        List<String> strL = new LinkedList<> ();
        for(int i=0; i<str.length()-1;i++){
            for(int j=i+1; j<str.length ();j++){
                strL.add(str.substring(i,j+1));
            }
        }
        return strL;
    }

    public static void main(String[] args){
        String str = "sumitachauhan";
        FindSubString obj = new FindSubString ();
        List<String> ltr = obj.subString (str);
        for(String s: ltr){
            System.out.println (s );
        }
    }

}
