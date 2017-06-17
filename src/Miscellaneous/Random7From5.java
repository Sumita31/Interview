package Miscellaneous;

public class Random7From5 {

    int rand7()
    {
        int sum=0;
        do
        {
            //We can generate from 1 to 21 with equal
            // probability using the following expression.
            sum = 5 * rand5() + rand5() - 5;
        } while (sum > 22);

        return sum % 7 + 1;
    }

    public int rand5(){
        int random = (int)(Math.random() * 5 + 1);
        return random;
    }

    public void countBits(int number){
        System.out.println (Integer.bitCount (number) );
    }

    public static void main(String[] args) {
        Random7From5 obj = new Random7From5 ();
//        obj.countBits (13);
        System.out.println (obj.rand7());
    }




}
