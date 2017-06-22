package StringArray;


public class KMP {
    public int[] generatePrefixArray(String str){
        int[] prefix=new int[str.length()];
        char[] cArray = str.toCharArray();
        int i=1, j=0;
        while(i<cArray.length){
            if(cArray[i]==cArray[j]) {
                prefix[i] = j + 1;
                i++;
                j++;
            }
            else if(cArray[i]!=cArray[j]){
                if(i!=cArray.length-1) {
                    prefix[i] = 0;
                    i++;
                }
                else if(i==cArray.length-1 && j-1>=0){
                    j=prefix[j-1];
                }
                else break;
            }
        }
        return prefix;
    }

    public boolean doesMatch(String text, String pattern){
        if(text==null || pattern==null || text.isEmpty() || pattern.isEmpty())
            return false;
        int[] patternArray= generatePrefixArray(pattern);
        int i=0, j=0, k=0;
        while(i<text.length() && j<pattern.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j!=0){
                    j=patternArray[j-1];
                }
                else i++;
            }
        }
        if(j == pattern.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String text="abcxabcdabcdabcyslopoppoj";
        String pattern ="abcdabcyk";
        KMP obj = new KMP();
        System.out.println(obj.doesMatch(text, pattern));
    }

}
