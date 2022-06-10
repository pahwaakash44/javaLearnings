package hacker.rank.interviewtest.paypal;

import java.io.*;

public class ParadeInHackerLand
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String color = bufferedReader.readLine();

        int result = ParadeResult.getSwapTime(color);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/

        System.out.println(ParadeResult.getSwapTime("0101"));
        System.out.println(ParadeResult.getSwapTime("001011"));
    }
}

class ParadeResult
{

    /*
     * Complete the 'getSwapTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING color as parameter.
     */

    public static int getSwapTime(String color)
    {
        int numberOfSeconds = 0;
        char[] persons = color.toCharArray();
        String updateColor = color;

        while(updateColor.contains("01"))
        {
            for(int i = 0; i < persons.length - 1; i++)
            {
                if (persons[i] == '0' && persons[i+1] == '1')
                {
                    char temp = persons[i];
                    persons[i] = persons[i+1];
                    persons[i+1] = temp;
                    i++;
                }
            }
            numberOfSeconds++;
            updateColor = new String(persons);
        }
        return numberOfSeconds;
    }
}
