package JavaConcepts;

import java.lang.reflect.*;
import java.util.*;


public class Reflection{

    public static void main(String[] args) {
        try{
            Class c = Class.forName ("java.sql.Connection");
            Method methods[] = c.getDeclaredMethods ();
            for(Method method: methods){
                System.out.println(method.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
