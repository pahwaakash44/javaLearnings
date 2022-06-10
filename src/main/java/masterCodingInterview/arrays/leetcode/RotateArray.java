package masterCodingInterview.arrays.leetcode;

import java.util.Arrays;

public class RotateArray
{
    public static void main(String[] args)
    {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    static void rotate(int[] nums, int k)
    {
        if (nums == null)
            return;
        if (k == 0 || nums.length == 1)
            System.out.println(Arrays.toString(nums));

        int j = 0;
        int[] rotatedArray = new int[nums.length];
        for (int i = nums.length - k; i < nums.length; i++)
        {
            rotatedArray[j++] = nums[i];
        }

        for(int i = 0; i < nums.length - k; i++)
        {
            rotatedArray[j++] = nums[i];
        }

        System.out.println(Arrays.toString(rotatedArray));
    }
}
