//amit homri 211321823
// Velocity specifies the change in position on the `x` and the `y` axes.

/**
 * class velocity speed of ball .
 */
public class Velocity {
    // constructor
    private double dx; // speed in x axes
    private double dy; // speed in y axes
    /**
     * velocity constructor.
     * @param dx speed in x axes
     * @param dy speed in y axes
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Creates a Velocity from an angle and speed.
     *
     * @param angle The angle of the velocity in degrees.
     * @param speed The speed of the velocity.
     * @return A Velocity object representing the specified angle and speed.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radian = Math.toRadians(Util.mod(angle - 90, 360));
        double dx = Math.cos(radian) * speed;
        double dy = Math.sin(radian) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * return dx.
     * @return double speed in x axes.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * return dy.
     * @return double speed in y axes.
     */
    public double getDy() {
        return this.dy;
    }
    // Take a point with position (x,y) and return a new point
// with position (x+dx, y+dy)
    /**
     * return ball place after move.
     * @param p point added to ball
     * @return new position of ball
     */
    public Point applyToPoint(Point p) {
        return new Point(dx + p.getX(), dy + p.getY());
    }
}
