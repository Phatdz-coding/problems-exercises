import java.awt.geom.Point2D;

public class Lab6Ex2 extends MyRectangle {

    public Lab6Ex2(java.awt.geom.Point2D.Double pt1, java.awt.geom.Point2D.Double pt2) {
        super(pt1, pt2);
    }

    // getCenterPoint method
    public Point2D.Double getCenterPoint() {
        double centerX = (getBottomLeftPoint().getX() + getTopRightPoint().getX()) / 2;
        double centerY = (getBottomLeftPoint().getY() + getTopRightPoint().getY()) / 2;
        return new Point2D.Double(centerX, centerY);
    }

    // get side lengths
    public double getLength() {
        return Math.abs(getTopRightPoint().getY() - getBottomLeftPoint().getY());
    }

    public double getWidth() {
        return Math.abs(getTopRightPoint().getX() - getBottomLeftPoint().getX());
    }

    /* Main method for testing */
    public static void main(String[] args) {
        /* ===Case 1==== */
        // Lab6Ex2 rectangle1 = new Lab6Ex2(
        // new Point2D.Double(0, 5.0),
        // new Point2D.Double(-8.0, 0));
        // Lab6Ex2 rectangle2 = new Lab6Ex2(
        // new Point2D.Double(4.0, 2.0),
        // new Point2D.Double(0.0, -5.0));

        /* ===Case 2==== */
        // Lab6Ex2 rectangle1 = new Lab6Ex2(
        // new Point2D.Double(0, 5.0),
        // new Point2D.Double(-8.0, 0));
        // Lab6Ex2 rectangle2 = new Lab6Ex2(
        // new Point2D.Double(-8.0, -3.0),
        // new Point2D.Double(-11.0, 0.0));

        /* ===Case 3==== */
        Lab6Ex2 rectangle1 = new Lab6Ex2(
                new Point2D.Double(0, 5.0),
                new Point2D.Double(-8.0, 0));
        Lab6Ex2 rectangle2 = new Lab6Ex2(
                new Point2D.Double(-10.0, -2.0),
                new Point2D.Double(-7.0, 3.0));

        /* ===Case 4==== */
        // Lab6Ex2 rectangle1 = new Lab6Ex2(
        // new Point2D.Double(0, 5.0),
        // new Point2D.Double(-8.0, 0));
        // Lab6Ex2 rectangle2 = new Lab6Ex2(
        // new Point2D.Double(4.0, -2.0),
        // new Point2D.Double(-2.0, -7.0));

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println("\nRectangles status:\n");

        // From here
        // we use the same algorithm as in Lab 6 Exercise 1 to compute the critical
        // length & common area
        Point2D.Double center1 = rectangle1.getCenterPoint();
        Point2D.Double center2 = rectangle2.getCenterPoint();

        double l1 = rectangle1.getLength();
        double w1 = rectangle1.getWidth();
        double l2 = rectangle2.getLength();
        double w2 = rectangle2.getWidth();

        double critical_length = Math.abs(l1 / 2.0 + l2 / 2.0);
        double critical_width = Math.abs(w1 / 2.0 + w2 / 2.0);

        double center_distance_length = Math.abs(center1.getY() - center2.getY());
        double center_distance_width = Math.abs(center1.getX() - center2.getX());

        // case 1: overlap
        if (center_distance_length < critical_length && center_distance_width < critical_width) {
            System.out.println("The rectangles overlap each other.");

            // compute the overlaped area
            double overlap_length = critical_length - center_distance_length;
            double overlap_width = critical_width - center_distance_width;
            double overlap_area = Math.abs(overlap_length * overlap_width);
            System.out.println("The overlapped area is: " + overlap_area);
        }
        // case 2: touch at vertex / side
        else if (center_distance_length == critical_length && center_distance_width == critical_width) {
            System.out.println("The rectangles touch at vertex.");
        }
        // case 3: touch at side
        else if ((center_distance_length == critical_length && center_distance_width <= critical_width) ||
                (center_distance_length <= critical_length && center_distance_width == critical_width)) {
            System.out.println("The rectangles touch at side.");
        }
        // case 4: no overlap
        else {
            System.out.println("The rectangles do not overlap.");

        }
    }
}