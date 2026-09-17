package Lab5;

public class Problem4 {
    public static int findmin(int a[], int n) {
        if (n == 1) {
            return a[0];
        }

        int[] b = new int[n - 1];
        for (int i = 1; i < n; i++) {
            b[i - 1] = a[i];
        }

        return java.lang.Math.min(a[0], findmin(b, n - 1));
    }

    public static int findsum(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }

        return a[n - 1] + findsum(a, n - 1);
    }

    public static void main(String[] args) {
        // sample array
        int a[] = { 3, 12, 33, 123, 39, 22, 56, 341, 9, 2 };
        // System.out.println(findmin(a, a.length));
        System.out.println(findsum(a, a.length));
    }
}
