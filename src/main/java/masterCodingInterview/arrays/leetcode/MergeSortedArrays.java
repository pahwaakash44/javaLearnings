package masterCodingInterview.arrays.leetcode;

import java.util.Arrays;

public class MergeSortedArrays
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{3, 9, 10, 18, 23}, new int[]{5, 12, 15, 20, 21, 25})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{1, 5}, new int[]{4, 6, 7})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{1, 5}, new int[]{-4, 6, 7})));
    }

    static int[] mergeArrays(int[] array1, int[] array2)
    {
        int[] mergedArray = new int[array1.length + array2.length];

        int i = 0; // array1 counter
        int j = 0; // array2 counter
        int k = 0; // merged array counter

        while (i <= array1.length - 1 && j <= array2.length - 1)
        {
            if (array1[i] < array2[j])
            {
                mergedArray[k] = array1[i];
                i++;
            }
            else
            {
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i <= array1.length - 1)
        {
            mergedArray[k] = array1[i];
            i++; k++;
        }

        while (j <= array2.length - 1)
        {
            mergedArray[k] = array2[j];
            j++; k++;
        }

        return mergedArray;
    }
}
