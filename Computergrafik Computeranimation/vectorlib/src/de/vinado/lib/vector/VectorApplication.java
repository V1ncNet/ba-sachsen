package de.vinado.lib.vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;

/**
 * @author Vincent Nadoll
 */
public class VectorApplication extends JFrame {

    public VectorApplication() throws HeadlessException {
        getContentPane().add(new View());

        setVisible(true);
    }

    @Override
    protected void frameInit() {
        super.frameInit();

        setTitle("Vector Visualization");
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
            g2.translate(width / 2, height / 2);

            g2.setColor(Color.GRAY);
            g2.drawLine(-(width / 2), 0, width / 2, 0);
            g2.drawLine(0, -(height / 2), 0, height / 2);

            int scale = 50;
            for (int i = -(width / 2) + scale; i <= (width / 2) - scale; i += scale) {
                g2.drawLine(i, 5, i, -5);
                g2.drawString(Integer.toString(i), i - 10, 20);
            }

            for (int i = -(height / 2) + scale; i <= (height / 2) - scale; i += scale) {
                g2.drawLine(5, i, -5, i);
                g2.drawString(Integer.toString(-i), 10, i + 4);
            }

            g2.setColor(Color.BLACK);

            Vector3D v = new Vector3D(100, 200, 300);
            Vector3D w = new Vector3D(100, 50, 500);
            Vector3D sum = v.add(w);

            draw(Color.GREEN, v, g2);
            draw(Color.BLUE, w, g2);
            draw(Color.RED, sum, g2);
        }

        private void draw(Color color, Vector3D v, Graphics2D g) {
            int x = (int) v.getX();
            int y = (int) v.getY();

            g.setColor(color);

            g.drawLine(0, 0, x, -y);
            g.drawOval(x - 6, -y - 6, 12, 12);

            g.drawString(String.format("%d,%d", x, y), x + 12, -y);

            g.setColor(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new VectorApplication();
    }
}
