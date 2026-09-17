package Lab5;

public class Problem10 {

    /**
     * Recursively prints the points of the Sierpinski Triangle for a given order.
     * @param order the depth of recursion
     * @param p1 coordinate of first vertex
     * @param p2 coordinate of second vertex
     * @param p3 coordinate of third vertex
     */
    public static void displaySierpinski(int order, double x1, double y1, double x2, double y2, double x3, double y3) {
        if (order == 0) {
            // Base case: Draw the triangle
            System.out.printf("polygon((%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f))%n", x1, y1, x2, y2, x3, y3);
        } else {
            // Recursive calls: Find midpoints
            double x12 = (x1 + x2) / 2;
            double y12 = (y1 + y2) / 2;
            double x23 = (x2 + x3) / 2;
            double y23 = (y2 + y3) / 2;
            double x31 = (x3 + x1) / 2;
            double y31 = (y3 + y1) / 2;

            // Divide into three smaller triangles
            displaySierpinski(order - 1, x1, y1, x12, y12, x31, y31);
            displaySierpinski(order - 1, x12, y12, x2, y2, x23, y23);
            displaySierpinski(order - 1, x31, y31, x23, y23, x3, y3);
        }
    }

    public static void main(String[] args) {
        // Initial triangle coordinates
        double x1 = 200, y1 = 20;
        double x2 = 20, y2 = 380;
        double x3 = 380, y3 = 380;
        int order = 3; // Depth of recursion

        System.out.println("Sierpinski Triangle coordinates for order " + order + ":");
        displaySierpinski(order, x1, y1, x2, y2, x3, y3);
    }
}
