package Leetcode;

class Solution12 {
    private static final java.util.Hashtable<Integer, String> ht = new java.util.Hashtable<>(
            java.util.Map.ofEntries(
                    java.util.Map.entry(1, "I"),
                    java.util.Map.entry(2, "II"),
                    java.util.Map.entry(3, "III"),
                    java.util.Map.entry(4, "IV"),
                    java.util.Map.entry(5, "V"),
                    java.util.Map.entry(6, "VI"),
                    java.util.Map.entry(7, "VII"),
                    java.util.Map.entry(8, "VIII"),
                    java.util.Map.entry(9, "IX"),
                    java.util.Map.entry(10, "X"),
                    java.util.Map.entry(20, "XX"),
                    java.util.Map.entry(30, "XXX"),
                    java.util.Map.entry(40, "XL"),
                    java.util.Map.entry(50, "L"),
                    java.util.Map.entry(60, "LX"),
                    java.util.Map.entry(70, "LXX"),
                    java.util.Map.entry(80, "LXXX"),
                    java.util.Map.entry(90, "XC"),
                    java.util.Map.entry(100, "C"),
                    java.util.Map.entry(200, "CC"),
                    java.util.Map.entry(300, "CCC"),
                    java.util.Map.entry(400, "CD"),
                    java.util.Map.entry(500, "D"),
                    java.util.Map.entry(600, "DC"),
                    java.util.Map.entry(700, "DCC"),
                    java.util.Map.entry(800, "DCCC"),
                    java.util.Map.entry(900, "CM"),
                    java.util.Map.entry(1000, "M"),
                    java.util.Map.entry(2000, "MM"),
                    java.util.Map.entry(3000, "MMM")));

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }

        String result = "";

        for (int i = 3; i >= 0; i--) {
            int n = (int) (java.lang.Math.floor(
                    ((double) num) / java.lang.Math.pow(10.0, ((double) i))) * java.lang.Math.pow(10.0, ((double) i)));
            
                if (n != 0) {
                    result = result.concat(ht.get(n));

                    num -= n;
                }
        }

        return result;
    }
}

public class LC12 {
    public static void main(String[] args) {
        int n = 1994;
        String roman = (new Solution12()).intToRoman(n);

        System.out.println(roman);
    }
}
