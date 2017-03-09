package Miscellaneous;

/**
 * Created by sumitachauhan on 2/23/17.
 */
public class Random7From5 {

    int rand7()
    {
        int sum=0;
        do
        {
            System.out.println();
            //sum = 5 * rand5() + rand5();
        } while (sum > 20);

        return sum % 7;
    }


}
