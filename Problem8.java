package Lab5;

import java.util.ArrayList;

public class Problem8 {
    public static void recusive_subset(ArrayList<Integer> a, int length){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j >= i) {
                    continue;
                }
                System.out.println(a.subList(j, i));
            }
        }
    }

    public static void main(String[] args) {
        // int[] raw_array = { 2, 4, 1, 6, 7, 2, 90, 23, 13, 8 };
        int[] raw_array = {1,2,3};

        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int element : raw_array) {
            a.add(element);
        }

        recusive_subset(a, a.size());
    }
}
