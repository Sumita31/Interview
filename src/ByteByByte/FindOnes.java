package ByteByByte;

/**
 * Created by sumitachauhan on 7/14/17.
 */
public class FindOnes {
    public int ones(int num){
        int sum=0;
        while(num>0){
            sum=sum+(num&1);
            num=num>>1;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindOnes obj = new FindOnes();
        System.out.println(obj.ones(7));
    }
}
