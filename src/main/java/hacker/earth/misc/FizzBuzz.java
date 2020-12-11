package hacker.earth.misc;

public class FizzBuzz
{
    
    public static void main(String[] args)
    {
        System.out.println("Print from 1 to 100 : ");
        fizzBuzz();
    }
    
    static void fizzBuzz()
    {
        for (int i = 1; i < 100; i++)
        {
            if (i%5 == 0)
                System.out.print("Buzz");
            else if (i%3 == 0)
                System.out.print("Fizz");
            else
                System.out.print(i);
    
            System.out.println();
        }
    }
}
