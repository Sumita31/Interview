package DynamicProgramming;

/**
 * Created by sumitachauhan on 6/20/17.
 */
public class EditDistance {
    public int getDistance(String first, String second){
        int[][] distance = new int[first.length()+1][second.length()+1];
        int val=0;
        for(int i=0; i<first.length()+1; i++){
            distance[i][0]=val;
            val=val+1;
        }
        val=0;
        for(int i=0; i<second.length()+1; i++){
            distance[0][i]=val;
            val=val+1;
        }
        for(int i=1; i<=first.length(); i++){
            for(int j=1; j<=second.length(); j++) {
               if(first.charAt(i-1)==second.charAt(j-1)){
                   distance[i][j]=distance[i-1][j-1];
               }
               else{
                   distance[i][j]=Math.min(Math.min(distance[i-1][j-1], distance[i-1][j]), distance[i][j-1] )+1;
               }
            }
        }

        for(int i=0; i<first.length()+1; i++){
            for(int j=0; j<second.length()+1; j++) {
                System.out.print(distance[i][j]);
            }
            System.out.println();
        }
        return distance[first.length()][second.length()];
    }

    public static void main(String[] args) {
        String s1="abcdef";
        String s2="azced";
        EditDistance obj = new EditDistance();
        System.out.println(obj.getDistance(s2,s1));
    }
}
