package Leetcode;

import java.util.Hashtable;

public class LogestSubString {

    public static void main(String[] args) {
        String s = "cdd";
        Solution2 solution = new Solution2();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class Solution2 {
    private int longest_sub_string = 0;

    public int lengthOfLongestSubstring(String s) {
        // counter
        int counter = 0;
        // char array
        char[] a = s.toCharArray();
        // create hashtable
        Hashtable<Integer, Character> ht = new Hashtable<>();
        // key counter
        int key = 0;
        int i = 0;

        for (char c : a) {
            if (ht.containsValue(c)) {
                // Handle duplicate character
                do {
                    ht.remove(i);
                    i++;
                } while (i < key && ht.containsValue(c));

                ht.put(key++, c);
            } else {
                ht.put(key++, c);
            }

            if (ht.size() > longest_sub_string) {
                longest_sub_string = ht.size();
            }
        }

        return longest_sub_string;
    }
}