//211321823 AMIT HOMRI
/**
 * The {@code Line} class represents a line segment defined by two points.
 */
public class Line {
    private Point start;
    private Point end;

    // constructors
    /**
     * Constructs a new line segment using the given start and end points.
     *
     * @param start the start point of the line
     * @param end   the end point of the line
     */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
        }

    /**
     * Constructs a new line segment using the given coordinates for the start and end points.
     *
     * @param x1 the x-coordinate of the start point
     * @param y1 the y-coordinate of the start point
     * @param x2 the x-coordinate of the end point
     * @param y2 the y-coordinate of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    // Return the length of the line
    /**
     * Returns the length of the line segment.
     *
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }
    // Returns the middle point of the line
    /**
     * Returns the middle point of the line segment.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        double middleX = 0.5 * (this.start.getX() + this.end.getX());
        double middleY = 0.5 * (this.start.getY() + this.end.getY());
        return new Point(middleX, middleY);
    }
    // Returns the start point of the line
    /**
     * Returns the start point of the line segment.
     *
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }
    // Returns the end point of the line
    /**
     * Returns the end point of the line segment.
     *
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }
    /**
     * Checks if this line is vertical.
     *
     * @return true  if the line is vertical,  false otherwise.
     */
    private boolean isVertical() {
        return start.getX() == end.getX();
    }
    /**
     * Calculates the slope of this line.
     *
     * @return The numerical slope of the line, or infinity if the line
     * is vertical.
     */
    public double getSlope() {
        return isVertical()
                ? Double.POSITIVE_INFINITY
                : (end.getY() - start.getY()) / (end.getX() - start.getX());
    }
    /**
     * Calculates the y-intercept of this line.
     *
     * <p>Rationale:
     * for ax + b = y (with 'b' being the y-intercept): b = y - ax.</p>
     *
     * @return The y-intercept of the line.
     */
    public double getYInt() {
        return start.getY() - getSlope() * start.getX();
    }

    /**
     * Checks if a given point lies on this line segment.
     *
     * @param p The point to check.
     * @return {@code true} if the point lies on the line segment,
     * {@code false} otherwise.
     */
    public boolean isOnLine(Point p) {
        // If point not in the segment's vertical range
        if (!Util.isBetween(Math.min(start.getY(), end.getY()),
                p.getY(),
                Math.max(start.getY(), end.getY()))) {
            return false;
        }
        /* If segment is vertical - simply check if the x-coordinates of the
         * point and segment are equal.
         * Else - substitute the point's coordinates in the line's equation */
        return isVertical()
                ? Util.isEqual(p.getX(), start.getX())
                : Util.isEqual(getSlope() * p.getX() + getYInt(), p.getY());
    }

    /**
     * Checks if this line overlaps with another line.
     *
     * @param other The other line.
     * @return {@code true} if the lines overlap, {@code false} otherwise.
     */
    private boolean isOverlapping(Line other) {
        return (isOnLine(other.start()) && other.isOnLine(this.start))
                || (isOnLine(other.start()) && other.isOnLine(this.end))
                || (isOnLine(other.end()) && other.isOnLine(this.start))
                || (isOnLine(other.end()) && other.isOnLine(this.end));
    }

    /**
     * Calculates the intersection point between this line and another line.
     *
     * @param other The other line.
     * @param tSlope The slope of this line.
     * @param oSlope The slope of the other line.
     * @return The intersection point of the two lines.
     */
    private Point getIntPoint(Line other, double tSlope, double oSlope) {
        double x, y;
        /* If one line is vertical - get the x-coordinate of the vertical line
         * and substitute it in the other line's equation for the y-coordinate.
         * Else - get the x-coordinate from the intersection equation and
         * substitute it in one of the lines' equations for the y-coordinate */
        if (this.isVertical()) {
            x = this.start.getX();
            y = oSlope * x + other.getYInt();
        } else if (other.isVertical()) {
            x = other.start().getX();
            y = tSlope * x + this.getYInt();
        } else {
            x = (other.getYInt() - this.getYInt()) / (tSlope - oSlope);
            y = tSlope * x + this.getYInt();
        }
        return new Point(x, y);
    }


    /**
     * Checks if this line intersects with another line.
     *
     * @param other The other line.
     * @return {@code true} if the lines intersect, {@code false} otherwise.
     */
    public boolean isIntersecting(Line other) {
        double tSlope = this.getSlope();
        double oSlope = other.getSlope();
        /* If slopes are equal - check if there's an endpoint of the other
         * segment on this segment.
         * Else - check if the calculated intersection is on both segments */
        if (Util.isEqual(tSlope, oSlope)) {
            return isOnLine(other.start()) || isOnLine(other.end());
        }
        Point intPoint = getIntPoint(other, tSlope, oSlope);
        return isOnLine(intPoint) && other.isOnLine(intPoint);
    }

    /**
     * Checks if this line intersects with two other lines.
     *
     * @param other1 The first line to check for intersection.
     * @param other2 The second line to check for intersection.
     * @return {@code true} if this line intersects with both other lines,
     * {@code false} otherwise.
     */
    public boolean isIntersecting(Line other1, Line other2) {
        return isIntersecting(other1) && isIntersecting(other2);
    }

    /**
     * Calculates the intersection point with another line.
     *
     * @param other The other line.
     * @return The intersection point, or null if the lines do not intersect
     * or have infinite intersection points.
     */
    public Point intersectionWith(Line other) {
        double tSlope = this.getSlope();
        double oSlope = other.getSlope();
        /* If infinite intersection points / no intersection - return null.
         * Else - return the calculated intersection point */
        return isOverlapping(other) || !isIntersecting(other)
                ? null : getIntPoint(other, tSlope, oSlope);
    }

    /**
     * returns true if two lines are same lines
     * @param other
     * @return true if same lines else  false
     */
    public boolean equals(Line other) {
        // Checks if both lines have the same start and end points in either order.
        boolean sameOrder1 = this.start.equals(other.start) && this.end.equals(other.end);
        boolean sameOrder2 = this.start.equals(other.end) && this.end.equals(other.start);

        return sameOrder1 || sameOrder2;
    }
}
