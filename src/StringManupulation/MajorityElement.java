package StringManupulation;

/**
 * Created by sumitachauhan on 6/19/17.
 */
public class MajorityElement {
    public int findMajorityElement(int[] input){
        int index_majority=0;
        int count=1;
        for(int i=1; i<input.length; i++){
            if(input[index_majority]==input[i]){
                count = count+1;
            }
            else count=count-1;

            if(count==0){
                index_majority=i;
                count=1;
            }

        }

        int maj_element=input[index_majority];
        int count_element=0;
        for(int i=0; i<input.length; i++){
            if(maj_element==input[i]){
                count_element++;
            }
        }
        if(count_element>input.length/2){
            return input[index_majority];
        }
        else return Integer.MAX_VALUE;


    }

    public static void main(String[] args) {
        int[] a = {1,1,2,0,0};
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.findMajorityElement(a));
    }
}
