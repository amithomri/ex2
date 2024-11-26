//211321823 amit homri
import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;
public class AbstractArtDrawing {


    /**
     * Draws triangles between lines that intersect.
     *
     * @param arr the array of lines
     * @param d   the DrawSurface to draw on
     */
    public void drawTriangles(Line[] arr, DrawSurface d) {
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // a triangle exists if the 3 of them intersect with each other
                    if (arr[i].isIntersecting(arr[j]) && arr[i].isIntersecting(arr[k])
                            && arr[j].isIntersecting(arr[k])) {
                        Point intersection1 = arr[i].intersectionWith(arr[j]);
                        Point intersection2 = arr[i].intersectionWith(arr[k]);
                        Point intersection3 = arr[j].intersectionWith(arr[k]);
                        // Draw triangle between the intersection points
                        d.setColor(Color.GREEN); // Change color if needed
                        d.drawLine((int) intersection1.getX(), (int) intersection1.getY(),
                                (int) intersection2.getX(), (int) intersection2.getY());
                        d.drawLine((int) intersection1.getX(), (int) intersection1.getY(),
                                (int) intersection3.getX(), (int) intersection3.getY());
                        d.drawLine((int) intersection2.getX(), (int) intersection2.getY(),
                                (int) intersection3.getX(), (int) intersection3.getY());
                    }
                }
            }
        }
    }


    public void drawRandomCircles() {
        Line[] arr = new Line[10];
        Random rand = new Random(); // create a random-number generator
// Create a window with the title "Random Circles Example"
// which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(400) + 1; // get integer in range 1-400
            int y = rand.nextInt(300) + 1; // get integer in range 1-300
            int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
            int r = 5 * (rand.nextInt(4) + 1); // get integer in 5,10,15,20
            Line randomLine = new Line(new Point(x, y), new Point(x2, y2));
            arr[i] = randomLine;
            d.setColor(Color.black);
            d.drawLine(x, y, x2, y2);
            d.setColor(Color.BLUE);
            d.fillCircle((int) randomLine.middle().getX(), (int) randomLine.middle().getY(), 3);
        }
        for (int j = 1; j < 10; j++) {
            for (int i = 0; i < j; i++) {
                // check if intersect to draw intersect points
                if (arr[i].isIntersecting(arr[j])) {
                        d.setColor(Color.red);
                        int xIntersect = (int) arr[i].intersectionWith(arr[j]).getX();
                        int yIntersect = (int) arr[i].intersectionWith(arr[j]).getY();
                        d.fillCircle(xIntersect, yIntersect, 3);
                }
            }
        }
                        // triangle in gui are multi intersections
                        drawTriangles(arr, d);
                        gui.show(d);
                    }





    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomCircles();

    }
}
