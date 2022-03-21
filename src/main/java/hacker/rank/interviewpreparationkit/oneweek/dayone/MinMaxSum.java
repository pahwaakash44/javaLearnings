package hacker.rank.interviewpreparationkit.oneweek.dayone;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinMaxSum
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());*/
    
//        MinMaxSumResult.miniMaxSum(Arrays.asList(1,2,3,4,5));
//        MinMaxSumResult.miniMaxSum(Arrays.asList(1,3,5,7,9));
//        MinMaxSumResult.miniMaxSum(Arrays.asList(396285104,573261094,759641832,819230764,364801279));
//        MinMaxSumResult.miniMaxSum(Arrays.asList(793810624,895642170,685903712,623789054,468592370));
//        MinMaxSumResult.miniMaxSum(Arrays.asList(501893267,649027153,379408215,452968170,487530619));
        MinMaxSumResult.minMaxSum2(Arrays.asList(156873294,719583602,581240736,605827319,895647130));
        
//        bufferedReader.close();
    }
}

class MinMaxSumResult {
    
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    
    /**
     * Scenarios:
     *  1,2,3,4
     *  2,3,4,5
     *  1,3,4,5
     *  1,2,4,5
     *  1,2,3,5
     * @param arr
     */
    public static void miniMaxSum(List<Integer> arr)
    {
        long sum = 0;
        long min = 1000000000;
        long max = 0;
       for(Integer i : arr)
       {
           long n = i;
           System.out.println("n: " + n);
            sum = sum + n;
           System.out.println("sum: " + sum);
            if (min > n)
            {
                min = n;
                System.out.println("min: " + min);
            }
            if (max < n)
            {
                max = n;
                System.out.println("max: " + max);
            }
        }
        System.out.println("final");
        System.out.println("sum: " + sum);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println((sum - max) + " " + (sum - min));
    }
    
    public static void minMaxSum2(List<Integer> arr)
    {
        long minimumSum = 0;
        long maximumSum = 0;
    
        Collections.sort(arr);
    
        for (int i = 0; i < arr.size() - 1; i++)
        {
            minimumSum += arr.get(i);
        }
    
        for (int i = 1; i < arr.size(); i++)
        {
            maximumSum += arr.get(i);
        }
    
        System.out.println(minimumSum + " " + maximumSum);
    
    }
}

