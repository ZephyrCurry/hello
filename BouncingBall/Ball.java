/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package BouncingBall;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ball {

    private double rx, ry;
    private double vx, vy;
    private double radius;

    public Ball() {
        rx = 0;
        ry = 0;
        vx = StdRandom.uniformDouble(-0.003, 0.003);
        vy = StdRandom.uniformDouble(-0.003, 0.003);
        radius = 0.05;
    }

    public void move(double dt) {
        // if ((rx + vx * dt < radius) || (rx + vx * dt > 1.0 - radius)) vx = -vx;
        // if ((rx + vy * dt < radius) || (rx + vy * dt > 1.0 - radius)) vy = -vy;
        // rx = rx + vx * dt;
        // ry = ry + vy * dt;
        if (Math.abs(rx + vx * dt) > 1.0 - radius) vx = -vx;
        if (Math.abs(ry + vy * dt) > 1.0 - radius) vy = -vy;
        rx = rx + vx * dt;
        ry = ry + vy * dt;
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledCircle(rx, ry, radius);
    }
}
