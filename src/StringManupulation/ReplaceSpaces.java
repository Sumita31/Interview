package StringManupulation;


public class ReplaceSpaces{
    /*
    count number of elements in array
    count number of white-spaces in array
    */
    public char[] replaceSpace(char[] arr, String str){
        int len = arr.length;
        int strlen = str.length ();
        int counter=0;
        for(int i=0; i<len; i++){
            if(arr[i]== ' ')
                counter++;
        }
        for(int i=0; i<len; i++){
            if(arr[i]== ' ')
                counter++;
        }
        int newlen= len+strlen*(counter-1)+1;
        if (newlen > len)
            return null;
        while(newlen>=0){
            if(arr[len-1]!=' '){
            arr[newlen-1]=arr[len-1];
            }
            else{
                for(int i=strlen-1; i>=0;i--){
                    arr[newlen-1]=str.charAt (i);
                }
            }
            newlen--;
            len--;
        }
    return arr;
    }

    public static void main(String[] args){
        String str= "%#@";
        char[] c = new char[15];
        c[0]='a';
        c[1]='b';
        c[3]='c';
        c[4]='d';
        c[6]='e';
        /*
        Program not working correctly for now
         */
        ReplaceSpaces obj = new ReplaceSpaces();
        c = obj.replaceSpace (c,str);
        for(int i=0; i<c.length;i++){
            System.out.println (c[i] );
        }
    }
}
