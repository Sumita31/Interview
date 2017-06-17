package StringManupulation;

/**
 * Created by sumitachauhan on 6/16/17.
 */
public class ExtractWords{

    public void extractWords(String str){

        String inputString = str.trim();
        String[] splitStr = inputString.split (" ");
        for(String s: splitStr){
            System.out.println (s );
        }
    }

    public static void main(String[] args){
        ExtractWords obj = new ExtractWords ();
        obj.extractWords ("My name is sumita chauhan. what is your name? ");
    }
}
