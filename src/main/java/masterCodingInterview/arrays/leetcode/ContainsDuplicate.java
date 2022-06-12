package masterCodingInterview.arrays.leetcode;

import java.util.*;

public class ContainsDuplicate
{
    public static void main(String[] args)
    {
        System.out.println(containsDuplicate3(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate3(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate3(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    static boolean containsDuplicate1(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    static boolean containsDuplicate2(int[] nums)
    {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums)
        {
            if (!numbers.add(num)) return true;
        }
        return false;
    }

    static boolean containsDuplicate3(int[] nums)
    {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.keySet();
        for (int num : nums)
        {
            if (numbers.put(num, "PRESENT") != null) return true;
        }
        return false;
    }
}
