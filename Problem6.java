package Lab5;

public class Problem6 {
    public static int gcd(int p, int q) {
        return (q == 0) ? p : gcd(q, p % q);
    }

    public static void main(String[] args) {
        System.out.println(gcd(6, 36));
    }
}
