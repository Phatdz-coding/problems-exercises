public class Lab6Ex1 {
    public static void main(String[] args) {

        Cuboid cuboid1 = new Cuboid(new Point3D(1, 2, 3), new Point3D(4, 5, 6));
        Cuboid cuboid2 = new Cuboid(new Point3D(6, 5, 4), new Point3D(3, 2, 1));

        System.out.println(cuboid1);
        System.out.println(cuboid2);

        // NOTE: This algorithm is 100% HUMAN-BRAIN generated. AI not involved.
        Point3D center1 = cuboid1.getCenter();
        Point3D center2 = cuboid2.getCenter();

        double l1 = cuboid1.getLength();
        double w1 = cuboid1.getWidth();
        double d1 = cuboid1.getDepth();
        double l2 = cuboid2.getLength();
        double w2 = cuboid2.getWidth();
        double d2 = cuboid2.getDepth();

        // calculate critical distances
        double critical_X = w1 / 2 + w2 / 2;
        double critical_Y = l1 / 2 + l2 / 2;
        double critical_Z = d1 / 2 + d2 / 2;

        double distanceCenters_X = Math.abs(center1.getX() - center2.getX());
        double distanceCenters_Y = Math.abs(center1.getY() - center2.getY());
        double distanceCenters_Z = Math.abs(center1.getZ() - center2.getZ());

        if (distanceCenters_X < critical_X &&
                distanceCenters_Y < critical_Y &&
                distanceCenters_Z < critical_Z) {
            System.out.println("Cuboids intersect.");

            // calculate the common vollume
            double overlap_w = critical_X - distanceCenters_X;
            double overlap_l = critical_Y - distanceCenters_Y;
            double overlap_d = critical_Z - distanceCenters_Z;
            double commonVolume = Math.abs(overlap_w * overlap_l * overlap_d);
            System.out.println("Common volume: " + commonVolume);
        } else {
            System.out.println("Cuboids do not intersect.");
        }

    }
}