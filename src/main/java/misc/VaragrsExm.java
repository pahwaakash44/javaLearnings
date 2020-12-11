package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VaragrsExm
{
    public static void main(String[] args)
    {
        List<Integer> integers= new ArrayList<>(Arrays.asList(1,2,3,4));
        fun2("Trial1", integers.stream().toArray(Integer[]::new));
//        fun2("Trial1", integers.stream().toArray(Integer[]::new));
    
        String[] intArr = integers.toString().replaceAll("\\[(.*?)\\]", "$1").split(",");
        for (String intAr : intArr)
            System.out.println(intAr);
    }
    
    static void fun2(String str, Integer... a)
    {
        System.out.println("String: " + str);
        System.out.println("Number of arguments is: " + a.length);
        
        // using for each loop to display contents of a
        for(int i : a)
        {
            System.out.print(i + " ");
        }
        
        System.out.println();
    }
}
