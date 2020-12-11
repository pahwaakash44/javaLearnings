package hacker.earth.misc;

import java.util.Scanner;

public class FredoAndArrayUpdate
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long[] inputs = new long[scanner.nextInt()];
        String[] input = scanner.nextLine().split(" ");
        long sumOfInitialArray = 0;
        try
        {
            for (int i = 0; i < inputs.length; i++)
            {
                inputs[i] = Long.parseLong(input[i]);
                sumOfInitialArray += inputs[i];
            }
            minUpdateVal(sumOfInitialArray, inputs);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println(0);
        }
    }
    
    private static void minUpdateVal(long sumOfInitialArray, long[] inputs)
    {
    
    }
}
