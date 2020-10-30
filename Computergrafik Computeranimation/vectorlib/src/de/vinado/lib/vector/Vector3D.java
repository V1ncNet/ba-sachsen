package de.vinado.lib.vector;

/**
 * Represents a 3D-vector as you know from linear algebra.
 *
 * @author Vincent Nadoll
 */
public class Vector3D {

    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D scale(double scale) {
        return new Vector3D(scale * x, scale * y, scale * z);
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(x + v.x, y + v.y, z + v.z);
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double dot(Vector3D v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3D normalize() {
        return scale(1d / length());
    }

    public Vector3D cross(Vector3D v) {
        return new Vector3D(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    public double angle(Vector3D v) {
        return Math.toDegrees(angleRad(v));
    }

    private double angleRad(Vector3D v) {
        return Math.acos(cosPhi(v));
    }

    private double cosPhi(Vector3D v) {
        // return normalize().dotProduct(v.normalize());
        return dot(v) / (length() * v.length());
    }

    public Vector3D difference(Vector3D v) {
        // return v.add(scale(-1));
        return new Vector3D(v.x - x, v.y - y, v.z - z);
    }

    public double distance(Vector3D v) {
        return difference(v).length();
    }

    /*public double distance(Vector3D v) {
        return Math.sqrt((binomialMinus(v.x, x)) + binomialMinus(v.y, y) + binomialMinus(v.z, z));
    }

    private static double binomialMinus(double a, double b) {
        return (a * a) - (2 * a * b) + (b * b);
    }*/

    @Override
    public String toString() {
        return String.format("( %.3f %.3f %.3f )", x, y, z);
    }
}
