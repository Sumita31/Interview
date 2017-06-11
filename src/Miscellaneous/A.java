package Miscellaneous;
import java.util.*;

interface A1{
    public void A();
}


interface B1{
    public void A();
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

// Write your Checker class here
class Checker implements Comparator<Player>{
    @Override
    public int compare(Player one, Player two){
        if(one.score != two.score)
            return two.score - one.score;
        else return one.name.compareTo(two.name);
    }
}

public class A implements A1, B1{

    @Override
    public void A() {
        System.out.println("--");
    }

    public static void main(String[] args) {
        A obj = new A();
        obj.A();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}