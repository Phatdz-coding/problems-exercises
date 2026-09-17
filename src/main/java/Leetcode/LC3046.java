package Leetcode;

import java.util.Stack;

class Solution3046 {
    public boolean isPossibleToSplit(int[] nums) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        for (int num : nums) {
            if (!s1.contains(num)) {
                s1.add(num);
            } else if (!s2.contains(num)) {
                s2.add(num);
            } else {
                return false;
            }
        }

        return true;
    }
}

public class LC3046 {
    public static void main(String[] args) {
        int[] a = {1,1,1,1};

        System.out.println((new Solution3046()).isPossibleToSplit(a));
    }
}