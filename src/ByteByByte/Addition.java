package ByteByByte;

/**
 * Created by sumitachauhan on 7/20/17.
 */
public class Addition {
    public int add(int a, int b){
        if(b==0) return a;
        int preSum=a^b;
        int carry=(a&b) << 1;
        return add(preSum, carry);
    }

    public static void main(String[] args) {
        Addition obj = new Addition();
        System.out.println(obj.add(100, 500));
    }
}
