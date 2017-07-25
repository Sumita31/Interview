package JavaConcepts;

/**
 * Created by sumitachauhan on 6/27/17.
 */
public class SwitchEx {
    public String foo(String str){
        char res[]=str.toCharArray();
        for(int i=0; i<str.length(); i++) {
            switch(str.charAt(i)){
                case 'a':
                    res[i]='A';
                    break;
                case 'e':
                    res[i]='E';
                    break;
                case 'i':
                    res[i]='I';
                    break;
                case 'o':
                    res[i]='O';
                    break;
                case 'u':
                    res[i]='U';
                    break;
                default:
            }
        }
        //return str;
        return String.copyValueOf(res);
    }

    public static void main(String[] args) {
        SwitchEx obj = new SwitchEx();
        String str="cut";
        System.out.println(obj.foo(str));
        System.out.println(str.equals(obj.foo(str)));
    }
}
