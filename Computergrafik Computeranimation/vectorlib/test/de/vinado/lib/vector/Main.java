package de.vinado.lib.vector;

/**
 * @author Vincent Nadoll
 */
public class Main {

    public static void main(String[] args) {
        Vector3D v = new Vector3D(1, 2, 3);
        Vector3D w = new Vector3D(-1, 0.5, 5);

        System.out.println("        v = " + v);
        System.out.println("        w = " + w);
        System.out.println("    2 * v = " + v.scale(2));
        System.out.println("    w + v = " + v.add(w));
        System.out.printf("      |v| = %.3f%n", v.length());
        System.out.printf("    w · v = %.3f%n", v.dot(w));
        System.out.println("    vNorm = " + v.normalize());
        System.out.printf("  |vNorm| = %.0f%n", v.normalize().length());
        System.out.println("    v × w = " + v.cross(w));
        System.out.println("    w × v = " + w.cross(v));
        System.out.println("    w - v = " + v.difference(w));
        System.out.printf("  |w - v| = %.3f%n", v.distance(w));
        System.out.printf("        φ = %.3f°%n", v.angle(w));
        System.out.printf(" φ(v × w) = %.0f%n", v.cross(w).angle(v));
        System.out.printf("v × w · v = %.0f%n", v.cross(w).dot(v));
    }
}
