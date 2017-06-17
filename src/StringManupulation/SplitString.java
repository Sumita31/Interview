package StringManupulation;

/**
 * Created by sumitachauhan on 6/16/17.
 */
public class SplitString{
    public void splitString(String str){
        if(str==null|| str.length ()==0)
            throw new IllegalArgumentException ("String can't be null");
        StringBuffer charString = new StringBuffer ();
        StringBuffer numString = new StringBuffer ();
        StringBuffer scharString = new StringBuffer ();
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i)))
                numString.append (str.charAt(i));
            else if(Character.isAlphabetic (str.charAt(i)))
                charString.append (str.charAt(i));
            else scharString.append (str.charAt(i));
        }
        System.out.println (charString );
        System.out.println (numString );
        System.out.println (scharString );
    }

    public static void main(String[] args){
        String str ="shufmf63890>>snike9203-kmdmw-nds.;sjisjw93jm2";
        SplitString obj = new SplitString();
        obj.splitString (str);
    }
}
