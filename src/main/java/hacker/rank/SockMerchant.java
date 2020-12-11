package hacker.rank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant
{
    // Complete the sockMerchant function below.
    public static int sockMerchant(int n, int[] ar)
    {
        Map<Integer, Integer> sockCount = new HashMap<>();
        for (int sock : ar)
        {
            if (sockCount.containsKey(sock))
            {
                int count = sockCount.get(sock);
                sockCount.put(sock, ++count);
            }
            else
            {
                sockCount.put(sock, 1);
            }
        }
        
        int pairs = 0;
        
        for (Map.Entry<Integer, Integer> entry : sockCount.entrySet())
        {
            if (entry.getValue() % 2 == 0)
                pairs += entry.getValue() / 2;
            else if ( entry.getValue() - 1 >= 2  && ((entry.getValue() - 1) % 2 == 0))
            {
                pairs += (entry.getValue()-1)/2;
            }
        }
        
        return pairs;
    }
    
//    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int[] arr = new int[] {10,20,20,10,10,30,50,10,20};
    
        System.out.println(sockMerchant(arr.length, arr));
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] ar = new int[n];
        
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        int result = sockMerchant(n, ar);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();*/
    }
}
