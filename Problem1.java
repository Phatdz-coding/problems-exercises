package Lab5;

public class Problem1 {

    public static int puzzle(int base, int limit) {
        // base and limit are nonnegative numbers
        if (base > limit)
            return -1;
        else if (base == limit)
            return 1;
        else
            return base * puzzle(base + 1, limit);
    }

    public static void main(String[] args) {
        System.out.println("(14,10): " + puzzle(14, 10));
        System.out.println("\n(4,7): " + puzzle(4, 7));
        System.out.println("\n(0,0): " + puzzle(0, 0));
    }
}