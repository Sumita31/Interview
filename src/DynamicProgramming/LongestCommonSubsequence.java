package DynamicProgramming;

/**
 * Created by sumitachauhan on 6/18/17.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String one = "abcd";
        String two = "acbd";
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.lcsDynamic(one.toCharArray(), two.toCharArray()));
        System.out.println(obj.lcs(one.toCharArray(), two.toCharArray(), 0,0));
    }
    public int longestSubsequence(String a, String b){
        int lenA=a.length();
        int lenB=b.length();
        int[][] longest = new int[lenA+1][lenB+1];
        int max=0;
        for(int i=1; i<=lenA; i++){
            for(int j=1; j<=lenB; j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    longest[i][j]=1+longest[i-1][j-1];
                    System.out.print(a.charAt(i-1));
                }
                else{
                    longest[i][j]=Math.max(longest[i-1][j], longest[i][j-1]);
                }
                if(longest[i][j] > max){
                    max = longest[i][j];
                }
            }
        }
        System.out.print("\n");
        return max;
    }
    /**
     http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
     */

    public int lcsDynamic(char str1[],char str2[]){

        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;

    }

    public int lcs(char str1[],char str2[],int len1, int len2){

        if(len1 == str1.length || len2 == str2.length){
            return 0;
        }
        if(str1[len1] == str2[len2]){
            return 1 + lcs(str1,str2,len1+1,len2+1);
        }
        else{
            return Math.max(lcs(str1,str2,len1+1,len2),lcs(str1,str2,len1,len2+1));
        }
    }

}
