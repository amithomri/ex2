//amit homri 211321823

import biuoop.DrawSurface;

/** class ball .
 *  create ball with these fields
 */
public class Ball {
    // constructor
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private int maxX;
    private int maxY;

    /**
     * constructor for ball.
     * @param center center of point
     * @param r radius
     * @param color ball color
     * @param maxX maximum x value board
     * @param maxY is max y value board
     */
    public Ball(Point center, int r, java.awt.Color color, int maxX, int maxY) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.maxX = maxX;
        this.maxY = maxY;
    }
    // accessors

    /**
     * x of center point .
     * @return x of center point .
     */
    public int getX() {
        return (int) center.getX();
    }
    /**
     * y of center point .
     * @return y of center point .
     */
    public int getY() {
        return (int) center.getY();
    }
    /**
     * radius of ball .
     * @return radius of ball .
     */
    public int getSize() {
        return this.radius;
    }
    /**
     * ball color.
     * @return color of ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    // draw the ball on the given DrawSurface
    /**
     * draws ball on gui.
     * @param surface tool for gui .
     */
    public void drawOn(DrawSurface surface) {
        surface.fillCircle(getX(), getY(), radius);
    }
    /**
     * sets velocity of ball.
     * @param v new ball speed
     */
    public void setVelocity(Velocity v) {
        this.velocity = new Velocity(v.getDx(), v.getDy());
    }
    /**
     * sets  velocity of ball.
     * @param dx speed in x.
     * @param dy speed in y.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return velocity of ball.
     */
    public Velocity getVelocity() {
        return new Velocity(velocity.getDx(), velocity.getDy());
    }
    /**
     * Sets the velocity of the ball based on its size, with a random direction.
     */
    public void setVelocityBySize() {
        java.util.Random rnd = new java.util.Random();
        double speedBySize = 200.0 / radius;
        Velocity v = Velocity.fromAngleAndSpeed(rnd.nextDouble() * 360,
                speedBySize);
        setVelocity(v);
    }
    /**
     * changes ball position.
     */
    public void moveOneStep() {
        //x axes border reached.
        if (getX() + getSize() >= maxX || getX() - getSize() <= 0) {
            this.setVelocity(-getVelocity().getDx(), getVelocity().getDy());
        }
        //y axes border reached
        if (getY() + getSize() >= maxY || getY() - getSize() <= 0) {
            setVelocity(getVelocity().getDx(), -getVelocity().getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

}
