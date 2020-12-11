package hacker.earth.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonFactor
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try
        {
            long input1 = Long.parseLong(input.split(" ")[0]);
            long input2 = Long.parseLong(input.split(" ")[1]);
            commonFactors(input1, input2);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println(0);
        }
    }
    
    private static void commonFactors(long input1, long input2)
    {
        int result = 0;
        
        long min = gcd(input1, input2);
        
        for(long i = 1; i <= Math.sqrt(min); i++)
        {
            if(min % i == 0)
            {
                if (min / i == 1)
                    result += 1;
                else
                    result += 2;
                    
            }
        }
        
        System.out.println(result);
    }
    
    static long gcd(long a, long b)
    {
        if(a == 0)
            return b;
        
        return gcd(b%a, a);
    }
}
