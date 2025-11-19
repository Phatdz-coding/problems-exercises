// CS1101 (AY2005/6 Semester 1)
// Lab 5 Exercise 2
// MyRectangle.java (partial code)
// Written by: Aaron Tan

import java.awt.geom.*;
import java.util.*;

public class MyRectangle {

   // Data members: the two corner points
   private Point2D.Double bottomLeftPoint;
   private Point2D.Double topRightPoint;

   // Constructor
   public MyRectangle(Point2D.Double pt1, Point2D.Double pt2) {
      setBottomLeftPoint(pt1);
      setTopRightPoint(pt2);
   }

   // ---------------------------------------------------------------
   // Methods:
   // (Each method should be preceded by a line of description.)
   // (You may create additional methods of your own.)
   // ---------------------------------------------------------------

   public void setBottomLeftPoint(Point2D.Double pt) {
      // fill in the code here
   }

   public void setTopRightPoint(Point2D.Double pt) {
      // fill in the code here
   }

   public Point2D.Double getBottomLeftPoint() {
      // fill in the code here
      return bottomLeftPoint;
   }

   public Point2D.Double getTopRightPoint() {
      // fill in the code here
      return topRightPoint;
   }

   public String toString() {
      // fill in the code here
      return "MyRectangle[bottomLeftPoint=" + bottomLeftPoint +
            ", topRightPoint=" + topRightPoint + "]";
   }

   // -----------------------------------------------------
   // main method used to test the MyRectangle class
   // -----------------------------------------------------
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      // fill in the code here

   }
}
