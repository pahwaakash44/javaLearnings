package hacker.rank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountingValleys
{
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        
        String path = bufferedReader.readLine();
        
        int result = Result.countingValleys(steps, path);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();*/
    
//        int steps = 8;
//        String path = "UDDDUDUU";
//        int steps = 12;
//        String path = "DDUUDDUDUUUD";
//        int steps = 4;
//        String path = "UDDU";
        int steps = 1000000;
        String path = new String(Files.readAllBytes(Paths.get("D:\\E-bkp\\Akash_Docs\\myLearnings\\JavaPractice\\src\\main\\resources\\steps.properties")));
        System.out.println(Result.countingValleys(steps, path));
    }
}

class Result
{
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    
    public static int countingValleys(int steps, String path)
    {
        // Write your code here
        String[] pathArr = path.split("");
        int valleysTraversed = 0;
        int upCount = 0;
        int downCount = 0;
        
        if (pathArr.length == 0)
            return valleysTraversed;
        
        for (int i = 0; i < steps; i++)
        {
            if (pathArr[i].equalsIgnoreCase("u"))
                upCount++;
            if (pathArr[i].equalsIgnoreCase("d"))
                downCount++;
            if (upCount == downCount
                    && !(i == 1 && pathArr[i-1].equalsIgnoreCase("u"))
                    && !((i+1) == steps && pathArr[i].equalsIgnoreCase("d")))
                valleysTraversed++;
        }
        
        return valleysTraversed;
    }
}




