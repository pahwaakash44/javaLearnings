package masterCodingInterview.arrays.leetcode;

public class MaximumSubArraySum
{
    public static void main(String[] args)
    {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    static int maxSubArray(int[] nums)
    {
        if (nums.length == 1) return nums[0];

        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;

        for (int index = 0; index < nums.length -1; index++)
        {
            max_end_here = max_end_here + nums[index];
            if (max_so_far < max_end_here) max_so_far = max_end_here;
            if (max_end_here < 0) max_end_here = 0;
        }

        return max_so_far;
    }
}
