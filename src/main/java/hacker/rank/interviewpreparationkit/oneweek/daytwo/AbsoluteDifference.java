package hacker.rank.interviewpreparationkit.oneweek.daytwo;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DiagonalDiffResult {
    
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    
    public static int diagonalDifference(List<List<Integer>> matrix)
    {
        /*
        1 2 3 4
        4 5 6 5
        9 8 9 6
        7 3 2 1
         */
        
        // iterate over parent array
        // get the child array = i th row of the parent array
        // Left Diagonal:
        // get the i th element of the child array
        // add it to the sum of leftDiagonalArray
        // Right Diagonal:
        // get the j th element of the child array
        // add it to the sum of rightDiagonalArray
        // return the abs value of the final left-right diagonal array sum
        
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        
        for (int i = 0, j = matrix.size() - 1; i < matrix.size() && j >= 0; i++, j--)
        {
            System.out.println("diagonal 1 value: " + matrix.get(i).get(i));
            leftDiagonalSum += matrix.get(i).get(i);
            System.out.println("diagonal 2 value: " + matrix.get(i).get(j));
            rightDiagonalSum += matrix.get(i).get(j);
        }
        
        return Math.abs(leftDiagonalSum-rightDiagonalSum);
    }
    
}

public class AbsoluteDifference
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());*/
        
        List<List<Integer>> arr = new ArrayList<>();
        
        /*IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });*/
    
        arr.add(Arrays.asList(11,2,4));
        arr.add(Arrays.asList(4,5,6));
        arr.add(Arrays.asList(10,8,-12));
        
        int result = DiagonalDiffResult.diagonalDifference(arr);
        System.out.println("result: " + result);
        
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
