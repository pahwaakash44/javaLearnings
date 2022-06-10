package masterCodingInterview.arrays.leetcode;

import java.util.Arrays;

public class MoveZeros
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(moveZeros2(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeros2(new int[]{0, 0, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeros2(new int[]{0, 0, 0})));
    }

    static int[] moveZeros(int[] nums)
    {
        if (nums.length == 1) return nums;
        for(int i = 0, j = 1; i < nums.length && j < nums.length; i++, j++)
        {
            if(nums[i] == 0 && nums[j] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            else if (nums[i] == 0 && nums[j] == 0)
            {
                do
                {
                    j++;
                } while (j < nums.length && nums[j] == 0);
                if (j < nums.length && nums[i] == 0 && nums[j] != 0)
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    static int[] moveZeros2(int[] nums)
    {
        if (nums.length == 1) return nums;
        int lastNonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0) nums[lastNonZeroIndex++] = nums[i];
        }

        while (lastNonZeroIndex < nums.length)
        {
            nums[lastNonZeroIndex++] = 0;
        }
        return nums;
    }
}
