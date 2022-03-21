package hacker.rank.interviewpreparationkit.oneweek.dayone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusMinus
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        /*List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());*/
        
        Result.plusMinus(Arrays.asList(-1,-1,-1));
        
        bufferedReader.close();
    }
}

class Result {
    private Result()
    {
        throw new UnsupportedOperationException("");
    }
    
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    
    /**
     * scenarios:
     * neg, zero, positive
     * zero, positive
     * neg, zero
     * neg zero, zero, positive
     * neg, positive
     * @param arr input
     */
    public static void plusMinus(List<Integer> arr)
    {
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;
        Collections.sort(arr);
        int firstIndexOfZero = arr.indexOf(0);
        if (firstIndexOfZero != -1)
        {
            int lastIndexOfZero = arr.lastIndexOf(0);
            zeroCount = (lastIndexOfZero - firstIndexOfZero == 0) ? 1 : (lastIndexOfZero - firstIndexOfZero + 1);
            negativeCount = firstIndexOfZero;
            positiveCount = arr.size() - (lastIndexOfZero + 1);
        }
        else
        {
            for (Integer i : arr)
            {
                if (i < 0)
                    negativeCount++;
                if (i > 0)
                    positiveCount++;
            }
        }
    
        System.out.printf("%.6f\n",(float)positiveCount/arr.size());
        System.out.printf("%.6f\n",(float)negativeCount/arr.size());
        System.out.printf("%.6f\n",(float)zeroCount/arr.size());
    }
    
}
