package Leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

// brute force approach
class Solution2939_1 {
    private static long twoPowerOf(int n) {
        long result = 1;
        while ((n--) != 0) {
            result *= 2;
        }

        return result;
    }

    public int maximumXorProduct(long a, long b, int n) {
        double max = 0;
        double r = 0;
        long maxIteration = twoPowerOf(n);
        long maxX = 0;

        for (long x = 0L; x < maxIteration; x++) {
            r = ((double) (a ^ x)) * ((double) (b ^ x));

            if (r > max) {
                max = r;
                maxX = x;
            }
        }

        return BigInteger.valueOf(a ^ maxX)
                .multiply(BigInteger.valueOf(b ^ maxX))
                .mod(BigInteger.valueOf(1_000_000_007L))
                .intValue();
    }
}

// bit manipulation appraoch
class Solution2939_2 {
    public int[] toBitArray(long num) {
        int[] result = new int[64];

        for (int i = 0; i < 64; i++) {
            boolean bit = ((num >>> i) & 1L) == 1L;
            result[i] = bit ? 1 : 0;
        }
        return result;
    }

    private long findOptimalX(long num, int n){
        long flip = ~num;
        long shift1, shift2 = Long.MAX_VALUE;
        long stopping_condition = ((long)java.lang.Math.pow(2.0, ((double)n)));

        int i = 1;
        while (shift2 > stopping_condition) {
            shift1 = flip << i;
            shift2 = shift1 >>> i;
            i++;
        }

        return shift2;
    }

    public int maximumXorProduct(long a, long b, int n) {
        long x = (a >= b) ? findOptimalX(b, n) : findOptimalX(a, n);

        return BigInteger.valueOf(a ^ x).multiply(BigInteger.valueOf(b ^ x)).mod(BigInteger.valueOf(1_000_000_007L)).intValue();
    }
}

public class LC2939 {
    public static void main(String[] args) {
        Solution2939_2 s = new Solution2939_2();
        // System.out.println(Long.MIN_VALUE);
        // System.out.println(712958946092410L * 53449611838880L);
        System.out.println(s.maximumXorProduct(900131674668079L,876236539936986L,49));
        // long val = 5;
        // long flip = ~val;
        // long shift, shift2 = Long.MAX_VALUE;
        // int i = 1;
        // while (shift2 >= 5) {
        //     shift = flip << i;
        //     shift2 = shift >>> i;
        //     // System.out.println("shift =" + Arrays.toString(s.toBitArray(shift)) +
        //     // "\nshift2 = "+ Arrays.toString(s.toBitArray(shift2)) + "\n\n\n");
        //     i++;
        // }
        // // 1 1 1 0 1 1 0 1 1 0 1 0 0 0
        // System.out.println(shift2);
        // System.out.println(Arrays.toString(s.toBitArray(val)));
        // System.out.println(Arrays.toString(s.toBitArray(shift2)));
    }
}
