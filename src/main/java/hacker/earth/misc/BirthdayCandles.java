package hacker.earth.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BirthdayCandles
{
    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar)
    {
        int candlesBlown = 0;
    
        Map<Integer, Integer> candleCount = new HashMap<>();
        for (int a : ar)
        {
            if (candleCount.containsKey(a))
            {
                candleCount.put(a, candleCount.get(a) + 1);
            }
            else
            {
                candleCount.put(a, 1);
            }
        }
    
        candlesBlown = candleCount.get(Collections.max(candleCount.keySet()));
        
        return candlesBlown;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] ar = new int[arCount];
        
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for(int i = 0; i < arCount; i++)
        {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        int result = birthdayCakeCandles(ar);
        
        System.out.println(result);
        scanner.close();
    }
}
