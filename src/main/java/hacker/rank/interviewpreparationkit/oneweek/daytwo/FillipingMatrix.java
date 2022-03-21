package hacker.rank.interviewpreparationkit.oneweek.daytwo;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class FlippingMatrixResult
{
    
    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    
    public static int flippingMatrix(Integer[][] matrix)
    {
        // Write your code here
        int sum = 0;
        
        // reverse sort all the rows of the matrix
        for(Integer[] rowList : matrix)
        {
            Arrays.sort(rowList, Collections.reverseOrder());
        }
        
        Arrays.sort(matrix, (o1, o2) -> o2[0].compareTo(o1[0]));
        
        System.out.println("row reversed");
        Arrays.stream(matrix).forEach(integers -> System.out.println(Arrays.toString(integers)));
        return sum;
    }
    
}

public class FillipingMatrix
{
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        
        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                
                List<List<Integer>> matrix = new ArrayList<>();
                
                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                
                int result = FlippingMatrixResult.flippingMatrix(matrix);
                
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();
        bufferedWriter.close();*/
        
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(112, 42, 83, 119)));
        matrix.add(new ArrayList<>(Arrays.asList(56, 125, 56, 49)));
        matrix.add(new ArrayList<>(Arrays.asList(15, 78, 101, 43)));
        matrix.add(new ArrayList<>(Arrays.asList(62, 98, 114, 108)));
        
        System.out.println("input");
        //        matrix.stream().forEach(System.out::println);
        Integer[][] arrayMatrix = matrix.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
        Arrays.stream(arrayMatrix).forEach(integers -> System.out.println(Arrays.toString(integers)));
        int result = FlippingMatrixResult.flippingMatrix(arrayMatrix);
        
        System.out.println("result: " + result);
    }
}
