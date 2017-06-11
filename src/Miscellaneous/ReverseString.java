package Miscellaneous;

/**
 * Created by sumitachauhan on 6/8/17.
 */
public class ReverseString {

    public void reverseString(char[] stringToReverse, int loc, int size){
        if(loc != size){
            reverseString(stringToReverse, loc+1, size);
            System.out.print(stringToReverse[loc]);
        }
    }

    public static void main(String[] args) {
        String name = "Sumita Chauhan";
        char[] nameArray = name.toCharArray();
        ReverseString obj = new ReverseString();
        obj.reverseString(nameArray, 0, nameArray.length);
    }
}
