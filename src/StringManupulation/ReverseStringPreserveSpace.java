package StringManupulation;

/**
 * Created by sumitachauhan on 6/17/17.
 */
public class ReverseStringPreserveSpace{
    public String reverse(String str){
        char[] a = new char[str.length ()];
        for(int i=0; i<str.length ();i++){
            if(str.charAt(i)==' '){
                a[i]=' ';
            }
        }
        int j=a.length-1;
        for(int i=0; i<str.length ();i++){
            if(str.charAt (i)!=' '){
                if(a[j]!=' '){
                    a[j]=str.charAt (i);
                    j--;
                }else{
                    j--;
                    a[j]=str.charAt (i);
                    j--;
                }
            }
        }
        return String.valueOf(a);
    }

    public static void main(String[] args){
        String str = "internship at geeks for geeks";
        String check="skeegrofsk ee gtapi hsn retni";
        ReverseStringPreserveSpace obj = new ReverseStringPreserveSpace();
        System.out.println (obj.reverse (str));
        System.out.println (check.equals (obj.reverse (str)));
    }
}
