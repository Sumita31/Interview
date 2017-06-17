package Miscellaneous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by sumitachauhan on 6/12/17.
 */
public class ValidatePhoneNumber {
    public static void main(String[] argv) {
        //grep '\(([0-9]\{3\})\|[0-9]\{3\}\)[ -]\?[0-9]\{3\}[ -]\?[0-9]\{4\}' ./*
        try {
            BufferedReader bf = new BufferedReader (new FileReader ("test1.txt"));
            Pattern pattern = Pattern.compile("\\(([0-9]\\{3})\\|[0-9]\\{3}\\)[ -]\\?[0-9]\\{3}[ -]\\?[0-9]\\{4}");
        //Stream<String> a = bf.lines();
            //a.forEach();
            Matcher matcher = pattern.matcher(bf.readLine());
            System.out.println (bf.readLine());
            if (matcher.matches()) {
                System.out.println("Valid Phone Number ");
            }
            else
            {
                System.out.println("Phone Number must be in the form XXX-XXXXXXX");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //String sPhoneNumber = "605-8889999";
        //String sPhoneNumber = "605-88899991";
//        String sPhoneNumber = "605-888999A";
//
//        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
//        Matcher matcher = pattern.matcher(sPhoneNumber);
//
//        if (matcher.matches()) {
//            System.out.println("Valid Phone Number ");
//        }
//        else
//        {
//            System.out.println("Phone Number must be in the form XXX-XXXXXXX");
//        }
    }
}
