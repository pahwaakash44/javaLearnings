package masterCodingInterview.arrays.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 5)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 4)));
    }

    static int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> complementIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int value = nums[i];
            int complement = target - value;

            if (complementIndexMap.containsKey(value))
            {
                return new int[] {complementIndexMap.get(value), i};
            }
            else
            {
                complementIndexMap.put(complement, i);
            }
        }
        return new int[]{};
    }
}
