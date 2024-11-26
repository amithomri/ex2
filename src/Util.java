//211321823 amit homri
/**
 * Utility class for common mathematical operations and array manipulation.
 */
public abstract class Util {
    /**
     * A small value used to determine equality between double values.
     */
    public static final double EPSILON = 0.00001;

    /**
     * Checks if the first double value is greater than the second by
     * a margin defined by EPSILON.
     *
     * @param a The first double value.
     * @param b The second double value.
     * @return {@code true} if {@code a} is greater than {@code b} by
     * a margin defined by EPSILON, {@code false} otherwise.
     */
    public static boolean isGreat(double a, double b) {
        return a - b > EPSILON;
    }

    /**
     * Checks if two double values are equal, considering a margin defined
     * by EPSILON.
     *
     * <p>Supports infinite values.</p>
     *
     * @param a The first double value.
     * @param b The second double value.
     * @return {@code true} if {@code a} is equal to {@code b} within a margin
     * defined by EPSILON, {@code false} otherwise.
     */
    public static boolean isEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON || Double.isNaN(Math.abs(a - b));
    }

    /**
     * Checks if a value is between two other values, considering a small
     * margin defined by EPSILON.
     *
     * @param a The lower boundary.
     * @param b The value to check.
     * @param c The higher boundary.
     * @return {@code true} if {@code b} is between {@code a} and {@code c}
     * (included) within a margin defined by EPSILON, {@code false} otherwise.
     */
    public static boolean isBetween(double a, double b, double c) {
        return (isGreat(b, a) || isEqual(b, a))
               && (isGreat(c, b) || isEqual(c, b));
    }

    /**
     * Returns the modulo of two double values.
     * If the dividend is greater than zero, it behaves like the standard
     * modulo operator; otherwise, it returns the remainder plus the divisor.
     *
     * @param a The dividend.
     * @param b The divisor.
     * @return The modulo of {@code a} and {@code b}.
     */
    public static double mod(double a, double b) {
        return isGreat(0, a) ? b + a : a % b;
    }
}
