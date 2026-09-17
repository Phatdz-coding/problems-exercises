package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;

public class lc2707 {
    public static void main(String[] args) {
        String s = "rkmsilizktprllwoimafyuqmeqrujxdzgp";
        String[] dictionary = {"afy","lyso","ymdt","uqm","cfybt","lwoim","hdzeg","th","rkmsi","d","e","tp","r","jx","tofxe","etjx","llqs","cpir","p","ncz","ofeyx","eqru","l","demij","tjky","jgodm","y","ernt","jfns","akjtl","wt","tk","zg","lxoi","kt"};

        lc2707 l = new lc2707();

        System.out.println(l.minExtraChar(s, dictionary));
    }

    String s;

    // sort dictionary
    public static void sortByLengthDesc(String[] dictionary) {
        Arrays.sort(dictionary, (a, b) -> Integer.compare(b.length(), a.length()));
    }

    // replace one occurrence of delimiter in the class attribute `s` with a blank space
    public String splitBySubstring(String delimiter) {
        if (this.s == null) {
            return null;
        }
        if (delimiter == null || delimiter.isEmpty()) {
            return this.s;
        }

        int idx = this.s.indexOf(delimiter);
        if (idx < 0) {
            return this.s;
        }

        this.s = this.s.substring(0, idx) + " " + this.s.substring(idx + delimiter.length());
        return this.s;
    }

    public int numberOfMatchWord(String w, int w_len) {
        if (w_len > s.length()) {
            return 0;
        }

        int m = 0;

        for (int i = w_len; i <= s.length(); i++) {
            String sw = s.substring(i - w_len, i);

            if (sw.equals(w)) {
                m++;
                splitBySubstring(sw);
                i = w_len;
            }
        }

        return m;
    }

    public int minExtraChar(String s, String[] dictionary) {
        this.s = s;
        sortByLengthDesc(dictionary);
        int n = this.s.length();

        ArrayList<String> list = new ArrayList<String>();

        for (String w : dictionary) {
            int w_len = w.length();
            int nomw = numberOfMatchWord(w, w_len);

            n -= nomw * w_len;

            if (nomw > 0) {
                list.add(w);
            }
        }

        System.out.println(list);

        return n;
    }
}