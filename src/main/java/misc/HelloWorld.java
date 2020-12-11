package misc;

/**
 * Created by APahwa on 8/24/2017.
 */
public class HelloWorld
{
    public static void main(String[] args)
    {
        
        System.out.println("Hello World");
        
        int[] arr = new int[0];
        
        for (int i =0; i < 5; i++)
            arr[i] = i;
        
        for (int a : arr)
        {
            System.out.println(a);
        }
    }
}
