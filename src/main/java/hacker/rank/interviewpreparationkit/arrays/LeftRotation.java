package hacker.rank.interviewpreparationkit.arrays;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeftRotation
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(firstMultipleInput[0]);
        
        int d = Integer.parseInt(firstMultipleInput[1]);
        
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());*/
        List<Integer> result = LeftRotationResult.rotLeft(Arrays.asList(1,2,3,4,5), 4);
    
        System.out.println(result.stream()
                .map(Object::toString)
                .collect(joining(" ")));
        
        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
        
        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

class LeftRotationResult {
    
    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */
    
    /**
     * Scenarios
     *   1. rotate from some random element  0 < d < a.size()
     *   2. rotate from last element d == a.size()
     *   3. rotate from first element d == 0
     * @param a array to rotate
     * @param d number of rotation
     * @return rotated array
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> rotatedArray = new ArrayList<>();
        if (d <= a.size())
        {
            // copy all the elements from d to a.size
            for (int i = d; i < a.size(); i++)
            {
                rotatedArray.add(a.get(i));
            }
            // now copy all elements from
            for (int j = 0; j < d; j++)
            {
                rotatedArray.add(a.get(j));
            }
        }
        return rotatedArray;
    }
    
}