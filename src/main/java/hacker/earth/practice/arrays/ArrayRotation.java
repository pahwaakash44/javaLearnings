package hacker.earth.practice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Given an unsorted array arr[] of size N, rotate it by D elements (clockwise).
 *
 * Input:
 * The first line of the input contains T denoting the number of testcases.
 * First line of each test case contains two space separated elements,
 * N denoting the size of the array and an integer D denoting the number size of the rotation.
 * Subsequent line will be the N space separated array elements.
 *
 * Output:
 * For each testcase, in a new line, output the rotated array.
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= N <= 107
 * 1 <= D <= N
 * 0 <= arr[i] <= 105
 *
 * Example:
 * Input:
 * 2
 * 5 2
 * 1 2 3 4 5
 * 10 3
 * 2 4 6 8 10 12 14 16 18 20
 *
 * Output:
 * 3 4 5 1 2
 * 8 10 12 14 16 18 20 2 4 6
 *
 * Explanation' :
 * Test?case 1: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
 *
 *
 */


public class ArrayRotation
{
    
    public static void main(String[] args)
    {
        int testCases = 0, arrayElements = 0, rotateElements = 0;
        Scanner in = new Scanner(System.in);
        testCases = in.nextInt();
        List<int[]> rotatedArrays = new ArrayList<>();
        for (int i = 0; i < testCases; i++)
        {
            arrayElements = in.nextInt();
            rotateElements = in.nextInt();
            int[] orignalArr = new int[arrayElements];
            for (int j = 0; j < orignalArr.length ; j++)
            {
                orignalArr[j] = in.nextInt();
            }
            rotatedArrays.add(rotateArray(orignalArr, rotateElements));
        }
        rotatedArrays.forEach(ArrayRotation::printRotatedArray);
    }
    
    public static int[] rotateArray(int[] originalArray, int rotateElements)
    {
        int[] rotatedArray = new int[originalArray.length];
        int[] tempArray = new int[rotateElements];
        for(int i = 0; i < rotateElements; i++)
        {
            tempArray[i]=originalArray[i];
        }
        for(int i = rotateElements, j = 0; i < originalArray.length; i++, j++)
        {
            rotatedArray[j] = originalArray[i];
        }
        int remaingElements = originalArray.length - rotateElements;
        for (int i = 0, j = remaingElements; i < tempArray.length; i++, j++)
        {
            rotatedArray[j] = tempArray[i];
        }
        return (rotatedArray);
    }
    
    private static void printRotatedArray(int[] rotatedArray)
    {
        for(int i : rotatedArray)
        {
            System.out.print(i + " ");
        }
    }
}
