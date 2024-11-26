//211321823 AMIT HOMRI
/**
 *  class represents a point in a two-dimensional space.
 */
public class Point {
    private double x;
    private double y;
    // constructor
    /**
     * Constructs a point at the specified (x, y) location.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // distance -- return the distance of this point to the other point
    /**
     *  distance -- return the distance of this point to the other point.
     *
     * @param other the point to which the distance is to be measured
     * @return the distance between this point and the specified point
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    // equals -- return true is the points are equal, false otherwise
    /**
     * equals -- return true is the points are equal, false otherwise
     * if and only if the argument is not {@code null} and is a {@code Point}
     * object that represents the same location as this point.
     *
     * @param other the point to compare with this point
     * @return {@code true} if the points are equal, {@code false} otherwise
     */
    public boolean equals(Point other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return this.x == other.x && this.y == other.y;
    }
    // Return the x and y values of this point
    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate of this point
     */
    public double getX() {
        return x;
    }
    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate of this point
     */
    public double getY() {
        return y;
    }
}
