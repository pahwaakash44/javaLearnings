package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by APahwa on 8/24/2017.
 */
public class HelloWorld
{
    public static void main(String[] args)
    {
        
        System.out.println("Hello World");
        
        /*int[] arr = new int[0];
        
        for (int i =0; i < 5; i++)
            arr[i] = i;
        
        for (int a : arr)
        {
            System.out.println(a);
        }*/
        printMap();
    }
    
    public static void printMap()
    {
        Map<String,List<String>> arguments = new HashMap<>();
        arguments.put("Key1", Arrays.asList("item11","item12"));
        arguments.put("Key2", Arrays.asList("item21","item22"));
    
        System.out.println(arguments.toString());
    }
}
