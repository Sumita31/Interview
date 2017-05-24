package HackerRank;

/**
 * Created by sumitachauhan on 5/21/17.
 */
public class PrimeNumber {
    public  void checkPrime(int num){
        if(num<2){
            System.out.println("Not prime");
            return;
        }
        int l=(int)Math.sqrt(num);
        for(int i=2; i<=l; i++){
            if(num%i==0){
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");
    }

    public static void main(String[] args) {
        PrimeNumber obj = new PrimeNumber();
        for(int num=0; num<100; num++) {
            obj.checkPrime(num);
        }
    }
}
