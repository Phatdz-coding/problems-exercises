package Leetcode;
import java.util.Arrays;

import org.hibernate.type.CharacterArrayType;

public class min_move {
    public static void main(String[] args) {
        String s = "111111";
        int k = 5;

        System.out.println(minimumPartition(s, k));
    }

    public static int minimumPartition(String s, int k) {
        // minimum base on the len of k
        int numof_digit_k = String.valueOf(k).length();
        // init
        int minimumPartition = 0;

        if (numof_digit_k < 1) {
            // error
            return -1;
        }

        if (numof_digit_k == 1) {
            // special case
            for (int i = 0; i < s.length(); i++) {
                String sub_s = s.substring(i, i + 1);
                if (Integer.valueOf(sub_s) > k) {
                    return -1;
                }
            }
            return s.length();
        }

        // general case
        int max_i = s.length();
        for (int i = 1, j = 0; i <= max_i && j < max_i; i++) {
            String sub_s = s.substring(j, i);
            Long valueOf_sub_s = Long.valueOf(sub_s);

            if (valueOf_sub_s >= Long.valueOf(String.valueOf(k))) {
                minimumPartition++;
                i--;
                j = i;
            }
        }

        return minimumPartition+1;
    }
}
