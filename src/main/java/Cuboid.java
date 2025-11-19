public class Cuboid {
    private Point3D corner1, corner2;

    public Cuboid(Point3D corner1, Point3D corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    public Cuboid(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.corner1 = new Point3D(x1, y1, z1);
        this.corner2 = new Point3D(x2, y2, z2);
    }

    // set getter methods
    public Point3D getCorner1() {
        return corner1;
    }

    public Point3D getCorner2() {
        return corner2;
    }

    public void setCorner1(Point3D corner1) {
        this.corner1 = corner1;
    }

    public void setCorner2(Point3D corner2) {
        this.corner2 = corner2;
    }

    // tostring method
    @Override
    public String toString() {
        return "Cuboid{" +
                "corner1=" + corner1 +
                ", corner2=" + corner2 +
                '}';
    }

    // getcenter method
    public Point3D getCenter() {
        double centerX = (corner1.getX() + corner2.getX()) / 2.0;
        double centerY = (corner1.getY() + corner2.getY()) / 2.0;
        double centerZ = (corner1.getZ() + corner2.getZ()) / 2.0;
        return new Point3D(centerX, centerY, centerZ);
    }

    // get width, height, depth methods
    public double getWidth() {
        return Math.abs(corner2.getX() - corner1.getX());
    }

    public double getLength() {
        return Math.abs(corner2.getY() - corner1.getY());
    }

    public double getDepth() {
        return Math.abs(corner2.getZ() - corner1.getZ());
    }
}