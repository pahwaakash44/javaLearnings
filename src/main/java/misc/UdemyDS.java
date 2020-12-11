package misc;

import java.util.Arrays;

public class UdemyDS
{
    public static void main(String[] args)
    {
        int[] boxes = new int[]{1,2,3,4,5};
        logAllPairsForArray(boxes);
    }
    
    public static void logAllPairsForArray(int[] arr)
    {
        System.out.println("Pairs : ");
        Arrays.stream(arr).forEach(k -> Arrays.stream(arr).mapToObj(i -> k + "" + i).forEach(System.out::println));
    }
}
