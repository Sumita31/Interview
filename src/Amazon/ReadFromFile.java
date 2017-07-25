package Amazon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sumitachauhan on 6/30/17.
 */
public class ReadFromFile {
    public static void main(String[] args) {
        Map<String,String > map= new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("test1.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp=line.split(" ");
                if(map.containsValue(temp[1])){
                    System.out.println(temp[1]+" found " + temp[0]);
                    System.exit(0);
                }
                else{
                    map.put(temp[0],temp[1]);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
