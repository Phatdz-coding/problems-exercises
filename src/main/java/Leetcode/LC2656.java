package Leetcode;

class Solution2656 {
    private int max(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public int maximizeSum(int[] nums, int k) {
        int max = max(nums);
        return k * max + k * (k - 1) / 2;
    }
}

public class LC2656 {
    public static void main(String[] args) {
        Solution2656 solution = new Solution2656();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(solution.maximizeSum(nums, k));
    }
}
