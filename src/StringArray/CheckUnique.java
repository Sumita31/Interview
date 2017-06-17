package StringArray;

/**
 * Created by sumitachauhan on 3/6/17.
 */
public class CheckUnique {

    //Check if all characters in the string are unique.
    public boolean isUnique(String str)
    {
        boolean[] char_set = new boolean[256];
        for(int i=0; i<str.length(); i++)
        {
            int val = str.charAt(i);
            if(char_set[val])
                return false;
            else char_set[val]=true;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckUnique obj = new CheckUnique();
        System.out.println(obj.isUnique("sumitas"));
    }
}
