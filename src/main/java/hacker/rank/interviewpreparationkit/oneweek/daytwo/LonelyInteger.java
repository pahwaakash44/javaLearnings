package hacker.rank.interviewpreparationkit.oneweek.daytwo;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LoneyIntegerResult
{
    
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    
    /**
     * Scenarios:
     1. first element is unique
     2. last element is unique
     3. any middle element is unique
     4. no elements are unique
     **/
    public static int lonelyInteger(List<Integer> integerList) {
        // Write your code here
        
        // sort the array
    
        Collections.sort(integerList);
        
        // for each element check if the element on next position is same or not
        // if same then increment to the next of that element
        // if not then return that element
        
        for (int index = 0; index < integerList.size();)
        {
            int curElement = integerList.get(index);
            int nextElement = (index + 1) < integerList.size() ? integerList.get(index + 1) : -1;
            if (nextElement == -1 || curElement != nextElement)
                return curElement;
            else
                index = index + 2;
        }
        return -1;
    }
    
}

public class LonelyInteger
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());*/
        
        int result = LoneyIntegerResult.lonelyInteger(Arrays.asList(6,1,2,3,3,2,1));
        System.out.println(result);
        
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
