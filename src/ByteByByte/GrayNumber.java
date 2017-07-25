package ByteByByte;

/**
 * Created by sumitachauhan on 7/20/17.
 */
public class GrayNumber {
    public boolean isGray(int a, int b){
        int n=a^b;
        while(n>0){
            if(n%2==1 && n>>1>0) return false;
            n=n>>1;
        }
        return true;
    }
    public boolean isGrayTrick(int a, int b){
        int n=a^b;
        if((n&(n-1))==0) return true;
        return false;
    }
}
