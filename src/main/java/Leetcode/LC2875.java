package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC2875 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2,3};
        int target = 4;
        Solution2875 solution = new Solution2875();
        System.out.println(solution.minSizeSubarray(nums, target));
    }
}

class Solution2875 {
    public int minSizeSubarray(int[] nums, int target) {
        int len = nums.length;
        int max_iteration = len * 100;

        int i = 0;
        int sum = 0;
        int min = -1;
        Queue<Integer> q = new LinkedList<Integer>();

        for (i = 0; i < max_iteration; i++) {
            int n = nums[i % len];
            sum += n;
            q.add(n);

            while (sum > target) {
                sum -= q.poll();
            }
            if (sum == target) {
                if (min == -1 || q.size() < min) {
                    min = q.size();
                }
            }
        }

        return min;
    }
}