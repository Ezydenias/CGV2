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

    public static double manhattenDistance(Vektor3D a, Vektor3D b) {
        double result, m, j, k;
        m = a.x - b.x;
        j = a.y - b.y;
        k = a.z - b.z;
        m = Math.abs(m);
        j = Math.abs(j);
        k = Math.abs(k);
//        m*=m;
//        j*=j;
//        k*=k;
//        m=Math.sqrt(m);
//        j=Math.sqrt(j);
//        k=Math.sqrt(k);
        result = m + j + k;
        return result;
    }

    public static double manhattenDistance(Vektor2D a, Vektor2D b) {
        double result, m, j;
        m = a.x - b.x;
        j = a.y - b.y;
        m = Math.abs(m);
        j = Math.abs(j);
//        m*=m;
//        j*=j;
//        m=Math.sqrt(m);
//        j=Math.sqrt(j);
        result = m + j;

        return result;
    }

    public static Vektor3D crossProduct(Vektor3D a, Vektor3D b) {
        Vektor3D temp = new Vektor3D();
        temp.x = a.y * b.z - a.z * b.y;
        temp.y = a.z * b.x - a.x * b.z;
        temp.z = a.x * b.y - a.y * b.x;
        return temp;
    }

    public static double dotProduct(Vektor3D a, Vektor3D b) {
        double temp = a.x * b.x + a.y * b.y + a.z * b.z;
        return temp;
    }

    public static double dotProduct(Vektor2D a, Vektor2D b) {
        double temp = a.x * b.x + a.y * b.y;
        return temp;
    }

    public static double cosEquation(Vektor3D a, Vektor3D b) throws Exception {
        if(a.isNullFector()||b.isNullFector()){
            throw new Exception("no Angle to Null Vektor Defined");
        }
        double atemp, btemp, abtemp;
        abtemp=dotProduct(a,b);
        atemp=length(a);
        btemp=length(b);
        return cosEquation(atemp,btemp,abtemp);
    }

    public static double cosEquation(Vektor2D a, Vektor2D b) throws Exception {
        if(a.isNullFector()||b.isNullFector()){
            throw new Exception("no Angle to Null Vektor Defined");
        }
        double atemp, btemp, abtemp;
        abtemp=dotProduct(a,b);
        atemp=length(a);
        btemp=length(b);
        return cosEquation(atemp,btemp,abtemp);
    }

    private static double cosEquation(double a, double b, double ab)    throws  Exception{
        if (ab==0){
            return 0;
        } else if (a==0||b==0){
            throw new Exception("Division with Zero still Undefined and something divided with 0 is not interpretable in this context");
        } else {
            return (ab/(a*b));
        }
    }

    public static double sinEquation(Vektor3D a, Vektor3D b) throws Exception {
        if(a.isNullFector()||b.isNullFector()){
            throw new Exception("no Angle to Null Vektor Defined");
        }
        double atemp, btemp, abtemp;
        abtemp=length(crossProduct(a,b));
        atemp=length(a);
        btemp=length(b);
        return cosEquation(atemp,btemp,abtemp);
    }

    public static double angleRad(Vektor3D a, Vektor3D b) throws Exception {
        return Math.acos(cosEquation(a,b));
    }

    public static double angleRad(Vektor2D a, Vektor2D b) throws Exception {
        return Math.acos(cosEquation(a,b));
    }

    public static double angleDegree(Vektor3D a, Vektor3D b) throws Exception {
        return Math.toDegrees(angleRad(a,b));
    }

    public static double angleDegree(Vektor2D a, Vektor2D b) throws Exception {
        return radToDegree(angleRad(a,b));
    }

    public static double radToDegree(double rad) {
        return Math.toDegrees(rad);
    }

    public static double DegreeToRad(double degree) {
        return Math.toRadians(degree);
    }

    public static double determinante(Vektor2D a, Vektor2D b) {
        return (a.x*b.y-a.y*b.x);
    }

    public static double determinante(Vektor3D a, Vektor3D b, Vektor3D c) {
        return ((a.x*b.y*c.z+b.x*c.y*a.z+c.x*a.y*b.z)-(c.x*b.y*a.z+a.x*c.y*b.z+b.x*a.y*c.z));
    }

    public static double abs(double a) {
        if (a<0){
            return -a;
        }else{
            return a;
        }
    }

    public static Vektor3D abs(Vektor3D a) {
        Vektor3D temp = new Vektor3D(a);
        temp.x=abs(temp.x);
        temp.y=abs(temp.y);
        temp.z=abs(temp.z);
        return temp;
    }

    public static Vektor2D abs(Vektor2D a) {
        Vektor2D temp = new Vektor2D(a);
        temp.x=abs(temp.x);
        temp.y=abs(temp.y);
        return temp;
    }

    public static String show(Vektor3D a) {
        String temp = "["+a.x+","+a.y+","+a.z+"}";
        System.out.println(temp);
        return temp;
    }

    public static String show(Vektor2D a) {
        String temp = "["+a.x+","+a.y+"}";
        System.out.println(temp);
        return temp;
    }
}
