package de.vinado.lib.path;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

/**
 * @author Vincent Nadoll
 */
public class PathApplication extends JFrame {

    public PathApplication() throws HeadlessException {
        getContentPane().add(new View());

        setVisible(true);
    }

    @Override
    protected void frameInit() {
        super.frameInit();

        setTitle("Path Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static class View extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getSize().width;
            int height = getSize().height;
            g2.translate(width / 2, (height / 2) + (height / 3));

            drawHeart(g2);
            drawKnot(g2);
        }

        private void drawHeart(Graphics2D g2) {
            int origx = 0, origy = 0;
            int c1x = -300, c1y = 240;
            int c2x = 0, c2y = 280;
            int c3x = 0, c3y = 200;
            int c4x = 0, c4y = 280;
            int c5x = 300, c5y = 240;

//            drawOval(origx, -origy, "Orig", g2);
//            drawOval(c1x, -c1y, "C1", g2);
//            drawOval(c2x, -c2y, "C2", g2);
//            drawOval(c3x, -c3y, "C3", g2);
//            drawOval(c4x, -c4y, "C4", g2);
//            drawOval(c5x, -c5y, "C5", g2);

            Path2D.Double p = new Path2D.Double();
            p.moveTo(origx, -origy);
            p.curveTo(c1x, -c1y, c2x, -c2y, c3x, -c3y);
            p.curveTo(c4x, -c4y, c5x, -c5y, origx, -origy);

            g2.setColor(Color.RED);
            g2.fill(p);
            g2.draw(p);

            g2.setColor(Color.BLACK);
        }

        private void drawKnot(Graphics2D g2) {
            int origx = 0, origy = 0;
            int c1x = -120, c1y = 60;
            int c2x = 50, c2y = 280;
            int c3x = 120, c3y = 200;
            int c4x = 120, c4y = 100;
            int c5x = -120, c5y = 100;
            int c6x = -120, c6y = 200;
            int c7x = -50, c7y = 280;
            int c8x = 120, c8y = 60;

//            drawOval(origx, origy, "Orig", g2);
//            drawOval(c1x, -c1y, "C1", g2);
//            drawOval(c2x, -c2y, "C2", g2);
//            drawOval(c3x, -c3y, "C3", g2);
//            drawOval(c4x, -c4y, "C4", g2);
//            drawOval(c5x, -c5y, "C5", g2);
//            drawOval(c6x, -c6y, "C6", g2);
//            drawOval(c7x, -c7y, "C7", g2);
//            drawOval(c8x, -c8y, "C8", g2);

            Path2D.Double p = new Path2D.Double(Path2D.WIND_EVEN_ODD);
            p.moveTo(origx, -origy);
            p.curveTo(c1x, -c1y, c2x, -c2y, c3x, -c3y);
            p.curveTo(c4x, -c4y, c5x, -c5y, c6x, -c6y);
            p.curveTo(c7x, -c7y, c8x, -c8y, origx, -origy);

            g2.fill(p);
            g2.draw(p);
        }

        private void drawOval(int x, int y, String label, Graphics2D g) {
            g.drawOval(x - 6, y - 6, 12, 12);
            g.setColor(Color.GRAY);
            g.drawString(label, x + 10, y + 20);
            g.setColor(Color.BLACK);
        }

        private void drawFoo(Graphics2D g2) {
            Path2D.Double p = new Path2D.Double();
            p.moveTo(100, 100);
            p.lineTo(200, 100);
            p.quadTo(300, 100, 300, 300);
            p.curveTo(300, 500, 200, 100, 200, 400);
            p.closePath();

            g2.fill(p);
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(5f));
            g2.draw(p);
        }
    }

    public static void main(String[] args) {
        new PathApplication();
    }
}
