//211321823 amit homri
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.Random;

public class MultipleFramesBouncingBallsAnimation {
    static private void drawBalls(Ball[] balls) {
        GUI gui = new GUI("title", 400, 400);
        Sleeper sleeper = new Sleeper();
        for (Ball ball : balls) {
            ball.setVelocityBySize();
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Ball ball : balls) {
                ball.moveOneStep();
                ball.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50); // wait for 50 milliseconds.
        }
    }
    public static void main(String[] args) {
        Ball[] balls = new Ball[args.length];
        for (int i = 0; i < balls.length; i++) {
            Random rand = new Random();
            double x = rand.nextInt(400) + 1; // get integer in range 1-400
            double y = rand.nextInt(400) + 1; // get integer in range 1-300
            balls[i] = new Ball(new Point(x, y), Integer.parseInt(args[i]), Color.cyan, 400, 400);
        }
        drawBalls(balls);
    }
}
