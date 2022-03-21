package hacker.earth.mock.interview.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DigitsDivisibility
{
    public static void main(String args[]) throws Exception
    {
        /* Sample code to perform I/O:
         * Use either of these methods for input
         */
    
        // Write your code here
        
        // take input
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int digitsLength = Integer.parseInt(br.readLine());
        String[] strArray = br.readLine().split(" ");
        int numberLength = Integer.parseInt(br.readLine());
        int divisibleBy = 3;
        
        // create combinations of numbers for the length given
        List<Integer> combinations = new ArrayList<>();
        
        for (int i = 0; i < digitsLength; i++)
        {
            if (i == 0 && Integer.parseInt(strArray[i]) == 0)
            {
                System.out.println("first digit is zero");
            }
            else
            {
                for (int j = 0; j < digitsLength; j++)
                {
                    
                    int number = Integer.parseInt(strArray[i]+strArray[j]);
                    System.out.println(number);
                    combinations.add(number);
                }
            }
        }
        
        // check all the combined numbers for divisibility
    
        List<Integer> divisibleNumbers = combinations.stream()
                .filter(integer -> integer % divisibleBy == 0)
                .collect(Collectors.toList());
        
        // if there is only 1 print it / are more than 1 print lowest / none than print -1
        System.out.println("Final Number : ");
        if (divisibleNumbers.size() == 1)
            System.out.println(divisibleNumbers.get(0));
        if (divisibleNumbers.size() > 1)
            System.out.println(Collections.min(divisibleNumbers));
    }
}
