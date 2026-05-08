package Lab5;

public class Problem2 {
    public static double sum(int n) {
        if (n <= 1) {
            return 1;
        }

        return 1.0 / n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}
