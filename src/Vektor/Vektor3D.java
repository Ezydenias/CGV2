/**
 * Created by Ezydenias on 4/12/2017.
 */

package Vektor;

public class Vektor3D {
    public double x;
    public double y;
    public double z;

    public Vektor3D() {
        this(0, 0, 0);
    }

    public Vektor3D(double x, double y, double z) {
        this.setPosition(x, y, z);
    }

    public Vektor3D(Vektor3D a) {

        this(a.x, a.y, a.z);
    }

    public void setPosition(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setPosition(Vektor3D a) {
        this.setPosition(a.x, a.y, a.z);
    }

    public void add(double x, double y, double z) throws Exception {
        double ex = this.x;
        double ey = this.y;
        double ez = this.z;

        ex += x;
        ey += y;
        ez += z;

        if (((ex == Double.POSITIVE_INFINITY) || (ex == Double.NEGATIVE_INFINITY)) || ((ey == Double.POSITIVE_INFINITY) || (ey == Double.NEGATIVE_INFINITY)) || ((ez == Double.POSITIVE_INFINITY) || (ez == Double.NEGATIVE_INFINITY))) {
            throw new Exception("Emotionally Overflow");
        }
        this.x = ex;
        this.y = ey;
        this.z = ez;
    }

    //exception weiter werfen
    public void add(Vektor3D a) throws Exception {
        add(a.x, a.y, a.z);
    }

    public void sub(Vektor3D a) throws Exception {
        add(-a.x, -a.y, -a.z);
    }


    public void sub(double x, double y, double z) throws Exception {
        add(-x, -y, -z);
    }

    public void mult(double x, double y, double z) throws Exception {
        double ex = this.x;
        double ey = this.y;
        double ez = this.z;

        ex *= x;
        ey *= y;
        ez *= z;

        if (((ex == Double.POSITIVE_INFINITY) || (ex == Double.NEGATIVE_INFINITY)) || ((ey == Double.POSITIVE_INFINITY) || (ey == Double.NEGATIVE_INFINITY)) || ((ez == Double.POSITIVE_INFINITY) || (ez == Double.NEGATIVE_INFINITY))) {
            throw new Exception("Emotionally Overflow");
        }
        this.x = ex;
        this.y = ey;
        this.z = ez;
    }


    public void mult(double a) throws Exception {
        mult(a, a, a);
    }

    public void div(double x, double y, double z) throws Exception {
        if (x == 0 || y == 0 || z == 0) {
            throw new Exception("Division with Zero still Undefined");
        } else {
            mult(1.0 / x, 1.0 / y, 1.0 / z);
        }
    }

    public void div(double a) throws Exception {
        div(a, a, a);
    }

    public boolean isEqual(Vektor3D a) {
        if (this.x == a.x && this.y == a.y && this.z == a.z) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNotEqual(Vektor3D a) {
        if (this.x == a.x && this.y == a.y && this.z == a.z) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isNullFector() {
        if (this.x == 0 && this.y == 0 && this.z == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double length() {
        double n = ((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
        n = Math.sqrt(n);
        return n;
    }

    public void normalize() throws Exception {
        double n = length();
        div(n, n, n);
    }
}
