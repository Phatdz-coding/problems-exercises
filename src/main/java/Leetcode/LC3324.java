package Leetcode;

import java.util.List;
import java.util.ArrayList;

class Solution3324 {
    private Character toChar(String c) {
        return c.charAt(0);
    }

    protected List<String> sequenceOfCharacter(String target_char) {
        Character c = toChar(target_char);
        Character begin_char = 'a';
        List<String> result = new ArrayList<String>();
        result.add("a");
        while (begin_char != c) {
            begin_char++;
            result.add(String.valueOf(begin_char));
        }

        return result;
    }

    public List<String> stringSequence(String target) {
        char[] c = target.toCharArray();
        List<String> result = new ArrayList<String>();
        int i = 0;
        for (char ch : c) {
            List<String> temp = sequenceOfCharacter(String.valueOf(ch));
            for (String character : temp) {
                if (result.size() != 0) {
                    result.add(result.get(i) + character);
                } else {
                    result.addAll(temp);
                    break;
                }
            }
            i = result.size() - 1;
        }
        return result;
    }
}

public class LC3324 {
    public static void main(String[] args) {
        Solution3324 solution = new Solution3324();
        System.out.println(solution.sequenceOfCharacter("c"));
        System.out.println(solution.stringSequence("abc"));
        System.out.println(solution.stringSequence("he"));
    }
}