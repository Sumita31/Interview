package Miscellaneous;

/**
 * Created by sumitachauhan on 6/24/17.
 */
public class FindRepeatTimes {
    public void findRepeat(int[] ar){
        if(ar==null)
            return;
        if(ar.length==1)
            System.out.println("just one element in the array"+ar[0]);

        for(int j=0; j<ar.length; j++){
            ar[ar[j]%ar.length]=ar[ar[j]%ar.length]+ar.length;
        }

        for(int i=0; i<ar.length; i++){
            System.out.println("element: "+i+" times: "+ ar[i]/7);
        }
    }

    public static void main(String[] args) {
        int[] ar = {2,4,2,2,6,0,2};
        FindRepeatTimes obj = new FindRepeatTimes();
        obj.findRepeat(ar);
    }
}
