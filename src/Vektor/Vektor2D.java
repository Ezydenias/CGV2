/**
 * Created by Ezydenias on 4/12/2017.
 */


package Vektor;

public class Vektor2D {
    public double x;
    public double y;

    public Vektor2D() {
        this(0, 0);
    }

    public Vektor2D(double x, double y) {
        this.setPosition(x, y);
    }

    public Vektor2D(Vektor2D a) {

        this(a.x, a.y);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(Vektor2D a) {
        this.setPosition(a.x, a.y);
    }

    public void add(double x, double y) throws Exception {
        double ex = this.x;
        double ey = this.y;

        ex += x;
        ey += y;

        if (((ex == Double.POSITIVE_INFINITY) || (ex == Double.NEGATIVE_INFINITY)) || ((ey == Double.POSITIVE_INFINITY) || (ey == Double.NEGATIVE_INFINITY))){
            throw new Exception("Emotionally Overflow");
        }

//        if (x < 0 && this.x < 0) {
//            if ((-Double.MAX_VALUE - x) > this.x) {
//                throw new Exception("Out of Negative x Range");
//            }
//        } else if (x > 0 && this.x > 0) {
//            if ((Double.MAX_VALUE - x) < this.x) {
//                throw new Exception("Out of Positive x Range");
//            }
//        } else if (y < 0 && this.y < 0) {
//            if ((-Double.MAX_VALUE - y) > this.y) {
//                throw new Exception("Out of Negative y Range");
//            }
//        } else if (y > 0 && this.y > 0) {
//            if ((Double.MAX_VALUE - y) < this.y) {
//                throw new Exception("Out of Positive y Range");
//            }
//        }


        this.x = ex;
        this.y = ey;


    }

    //exception weiter werfen
    public void add(Vektor2D a) throws Exception {
        add(a.x, a.y);
    }

    public void sub(Vektor2D a) throws Exception {
        add(-a.x, -a.y);
    }


    public void sub(double x, double y) throws Exception {
        add(-x, -y);
    }

    public void mult(double x, double y) throws Exception {
        double ex = this.x;
        double ey = this.y;

        ex*=x;
        ey*=y;

        if (((ex == Double.POSITIVE_INFINITY) || (ex == Double.NEGATIVE_INFINITY)) || ((ey == Double.POSITIVE_INFINITY) || (ey == Double.NEGATIVE_INFINITY))){
            throw new Exception("Emotionally Overflow");
        }

//        if (x > 0 && x < Double.MAX_VALUE / this.x ||
//                x < 0 && x > Double.MAX_VALUE / this.x) {
//            throw new Exception("out of x range");
//        }
//        if (y > 0 && y < Double.MAX_VALUE / this.y ||
//                y < 0 && y > Double.MAX_VALUE / this.y) {
//            throw new Exception("out of y range");
//        }
        this.x = ex;
        this.y = ey;
    }


    public void mult(double a) throws Exception {
        mult(a, a);
    }

    public void div(double x, double y) throws Exception {
        if (x == 0 || y == 0) {
            throw new Exception("Division with Zero still Undefined");
        } else {
            mult(1.0 / x, 1.0 / y);
        }
    }

    public void div(double a) throws Exception {
        div(a, a);
    }

    public boolean isEqual(Vektor2D a) {
        if (this.x == a.x && this.y == a.y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNotEqual(Vektor2D a) {
        if (this.x == a.x && this.y == a.y) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isNullFector() {
        if (this.x == 0 && this.y == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double length() {
        double n = ((this.x * this.x) + (this.y * this.y));
        n = Math.sqrt(n);
        return n;
    }

    public void normalize() throws Exception {
        double n = length();
        div(n, n);
    }
}
