package Amazon;

/**
 * Created by sumitachauhan on 7/24/17.
 */
public class Multiplication {
    public void printMultiplication(){
        for(int i=1; i<13; i++){
            for(int j=1; j<13; j++){
                System.out.print((i*j)+"\t\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Multiplication obj = new Multiplication();
        obj.printMultiplication();
    }
}
