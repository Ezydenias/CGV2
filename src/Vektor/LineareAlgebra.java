package Vektor;

/**
 * Created by Ezydenias on 4/12/2017.
 */
public class LineareAlgebra {

    public static Vektor2D add(Vektor2D a, Vektor2D b) throws Exception {
        Vektor2D temp = new Vektor2D(a);

        temp.x += b.x;
        temp.y += b.y;

        if (((temp.x == Double.POSITIVE_INFINITY) || (temp.x == Double.NEGATIVE_INFINITY)) || ((temp.y == Double.POSITIVE_INFINITY) || (temp.y == Double.NEGATIVE_INFINITY))) {
            throw new Exception("Emotionally Overflow");
        }
        return (temp);
    }

    public static Vektor3D add(Vektor3D a, Vektor3D b) throws Exception {
        Vektor3D temp = new Vektor3D(a);

        temp.x += b.x;
        temp.y += b.y;
        temp.z += b.z;

        if (((temp.x == Double.POSITIVE_INFINITY) || (temp.x == Double.NEGATIVE_INFINITY)) || ((temp.y == Double.POSITIVE_INFINITY) || (temp.y == Double.NEGATIVE_INFINITY)) || ((temp.z == Double.POSITIVE_INFINITY) || (temp.z == Double.NEGATIVE_INFINITY))) {
            throw new Exception("Emotionally Overflow");
        }
        return (temp);
    }

    public static Vektor2D sub(Vektor2D a, Vektor2D b) throws Exception {
        Vektor2D temp = new Vektor2D(b);
        temp.x *= -1.0;
        temp.y *= -1.0;

        temp = add(a, temp);

        return (temp);
    }

    public static Vektor3D sub(Vektor3D a, Vektor3D b) throws Exception {
        Vektor3D temp = new Vektor3D(b);
        temp.x *= -1.0;
        temp.y *= -1.0;
        temp.z *= -1.0;

        temp = add(a, temp);

        return (temp);
    }

    public static Vektor3D mult(Vektor3D a, double x) throws Exception {
        Vektor3D temp = new Vektor3D(a);

        temp.x *= x;
        temp.y *= x;
        temp.z *= x;

        if (((temp.x == Double.POSITIVE_INFINITY) || (temp.x == Double.NEGATIVE_INFINITY)) || ((temp.y == Double.POSITIVE_INFINITY) || (temp.y == Double.NEGATIVE_INFINITY)) || ((temp.z == Double.POSITIVE_INFINITY) || (temp.z == Double.NEGATIVE_INFINITY))) {
            throw new Exception("Emotionally Overflow");
        }
        return (temp);
    }

    public static Vektor3D mult(double x, Vektor3D a) throws Exception {
        return (mult(a, x));
    }

    public static Vektor2D mult(Vektor2D a, double x) throws Exception {
        Vektor2D temp = new Vektor2D(a);

        temp.x *= x;
        temp.y *= x;

        if (((temp.x == Double.POSITIVE_INFINITY) || (temp.x == Double.NEGATIVE_INFINITY)) || ((temp.y == Double.POSITIVE_INFINITY) || (temp.y == Double.NEGATIVE_INFINITY))) {
            throw new Exception("Emotionally Overflow");
        }

        return (temp);

    }

    public static Vektor2D mult(double x, Vektor2D a) throws Exception {
        return (mult(a, x));
    }

    public static Vektor3D div(Vektor3D a, double x) throws Exception {
        if (x == 0) {
            throw new Exception("Division with Zero still Undefined");
        } else {
            return (mult(a, 1.0 / x));
        }

    }

    public static Vektor3D div(double x, Vektor3D a) throws Exception {
        return (div(a, x));
    }

    public static Vektor2D div(Vektor2D a, double x) throws Exception {
        if (x == 0) {
            throw new Exception("Division with Zero still Undefined");
        } else {
            return (mult(a, 1.0 / x));
        }
    }

    public static Vektor2D div(double x, Vektor2D a) throws Exception {
        return (div(a, x));
    }

    public static boolean isEqual(Vektor3D a, Vektor3D b) {
        if ((a.x == b.x) && (a.y == b.y) && (a.z == b.z)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEqual(Vektor2D a, Vektor2D b) {
        if ((a.x == b.x) && (a.y == b.y)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEqual(Vektor3D a, Vektor3D b) {
        if ((a.x == b.x) && (a.y == b.y) && (a.z == b.z)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNotEqual(Vektor2D a, Vektor2D b) {
        if ((a.x == b.x) && (a.y == b.y)) {
            return false;
        } else {
            return true;
        }
    }

    public static double length(Vektor3D a) {
        double n = ((a.x * a.x) + (a.y * a.y) + (a.z * a.z));
        n = Math.sqrt(n);
        return n;
    }

    public static double length(Vektor2D a) {
        double n = ((a.x * a.x) + (a.y * a.y));
        n = Math.sqrt(n);
        return n;
    }

    public static Vektor3D normalize(Vektor3D a) throws Exception {
        Vektor3D temp = new Vektor3D(a);
        double n = length(a);
        temp = div(temp, n);
        return (temp);
    }

    public static Vektor2D normalize(Vektor2D a) throws Exception {
        Vektor2D temp = new Vektor2D(a);
        double n = length(a);
        temp = div(temp, n);
        return (temp);
    }

    public static double euklDistance(Vektor3D a, Vektor3D b) {
        double result, c, d, f;
        c = a.x - b.x;
        d = a.y - b.y;
        f = a.z - b.z;
        c *= c;
        d *= d;
        f *= f;
        result = c + d + f;
        result = Math.sqrt(result);
        return result;
    }

    public static double euklDistance(Vektor2D a, Vektor2D b) {
        double result, c, d;
        c = a.x - b.x;
        d = a.y - b.y;
        c *= c;
        d *= d;
        result = c + d;
        result = Math.sqrt(result);
        return result;
    }

}
