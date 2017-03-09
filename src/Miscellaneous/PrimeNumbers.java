package Miscellaneous;

/**
 * Created by sumitachauhan on 3/6/17.
 */
public class PrimeNumbers {

    public void printPrime(int n)
    {
        for(int i=2; i<=n; i++)
        {
            if(isPrime(i))
            {
                System.out.print(i+", ");
            }
        }
    }

    public boolean isPrime(int n)
    {
        for(int i=2; i<n; i++)
        {
            if(n%i == 0)
            {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args)
    {
        PrimeNumbers obj = new PrimeNumbers();
        obj.printPrime(8);
    }
}
