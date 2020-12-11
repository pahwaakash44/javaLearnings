package hacker.earth.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation
{
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        return null;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] a = new int[n];
//
//        String[] aItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int aItem = Integer.parseInt(aItems[i]);
//            a[i] = aItem;
//        }
//
//        int[] result = rotLeft(a, d);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    
        int rotate = 4;
        int orignalArr[] = {1,2,3,4,5};
        int rotatedArr[] = new int[orignalArr.length];
        int j = 0;
        for(int i = rotate; i < orignalArr.length; i++)
        {
            rotatedArr[j] = orignalArr[i];
            j++;
        }
    
        for (int i = rotate-1; i >= 0; i--)
        {
            rotatedArr[j] = orignalArr[i];
            j++;
        }
    
        System.out.println("Original Array : ");
    
        Arrays.stream(orignalArr).forEach(System.out::println);
        
        System.out.println("Rotated Array :  ");
    
        Arrays.stream(rotatedArr).forEach(System.out::println);
        
    }
}
