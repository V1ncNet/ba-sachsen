package de.vinado.lib.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Path2D;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Vincent Nadoll
 */
public class Heartbeat extends Frame {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    /**
     * The overall duration for transforming shape A to shape B <em>t</em><sub>ges</sub> in ms
     */
    private static final long DURATION = 600;

    /**
     * Number of steps used to transform shape A into shape B
     */
    private static final int STEPS = 100;

    /**
     * The time between to frames
     */
    private static final long PERIOD = DURATION / STEPS;

    private static final Timer TIMER = new Timer();

    /**
     * Starting point of shape A
     */
    private static final int[][] sourcePoints = definePoints(2);
    private static final int[][] targetPoints = definePoints(3.5);

    private static int[][] definePoints(double scale) {
        int x = WINDOW_WIDTH / 2;
        int y = WINDOW_HEIGHT / 2;
        return new int[][]{
                {x, y},
                {x, (int) (y - 30 * scale)},
                {(int) (x - 50 * scale), (int) (y - 30 * scale)},
                {(int) (x - 50 * scale), y},
                {(int) (x - 50 * scale), (int) (y + 30 * scale)},
                {x, (int) (y + 35 * scale)},
                {x, (int) (y + 60 * scale)},
                {x, (int) (y + 35 * scale)},
                {(int) (x + 50 * scale), (int) (y + 30 * scale)},
                {(int) (x + 50 * scale), y},
                {(int) (x + 50 * scale), (int) (y - 30 * scale)},
                {x, (int) (y - 30 * scale)},
        };
    }

    private final Image backBuffer;

    /**
     * Added to alpha to get the new alpha for calculating the next frame <em>0 &#8804; &Delta;&alpha; &#8804;
     * 1</em>
     */
    private float fraction = 1.0f / STEPS;

    /**
     * Coefficient of the convex combination used to calculate a certain frame <em>0 &#8804; &Delta;&alpha; &#8804;
     * 1</em>
     */
    private float alpha;

    public Heartbeat() {
        setTitle("Heartbeat");
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });

        //create panel for drawing
        Panel canvas = new Panel() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(backBuffer, 0, 0, null);
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        };

        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        //add panel to window
        add(canvas);
        setResizable(false);
        pack();

        //create image for off-screen drawing (double buffering)
        backBuffer = canvas.createImage(WINDOW_WIDTH, WINDOW_HEIGHT);

        //get graphics object for back buffer
        Graphics2D g2 = (Graphics2D) backBuffer.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //schedule animation task
        TIMER.schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        float next = alpha + fraction;
                        int[][] pointsBetween = tween(alpha);

                        drawBackground(g2);
                        drawHeart(g2, pointsBetween);

                        canvas.repaint();

                        if (next < 0 || next > 1) {
                            fraction = -fraction;
                        }

                        alpha = next;
                    }
                }, 0, PERIOD);

        setVisible(true);
    }

    private static int[][] tween(float alpha) {
        int[][] pointsBetween = new int[sourcePoints.length][sourcePoints[0].length];

        for (int i = 0; i < sourcePoints.length; i++) {
            for (int j = 0; j < sourcePoints[i].length; j++) {
                pointsBetween[i][j] = (int) (sourcePoints[i][j] + alpha * (targetPoints[i][j] - sourcePoints[i][j]));
            }
        }

        return pointsBetween;
    }

    private static void drawBackground(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private static void drawHeart(Graphics2D g2, int[][] points) {
        Path2D.Double heart = new Path2D.Double();
        heart.moveTo(points[0][0], points[0][1]);
        heart.curveTo(points[1][0], points[1][1], points[2][0], points[2][1], points[3][0], points[3][1]);
        heart.curveTo(points[4][0], points[4][1], points[5][0], points[5][1], points[6][0], points[6][1]);
        heart.curveTo(points[7][0], points[7][1], points[8][0], points[8][1], points[9][0], points[9][1]);
        heart.curveTo(points[10][0], points[10][1], points[11][0], points[11][1], points[0][0], points[0][1]);
        heart.closePath();

        g2.setColor(Color.RED);
        g2.fill(heart);
        g2.setColor(Color.BLACK);
    }

    public static void main(String[] args) {
        new Heartbeat();
    }
}
