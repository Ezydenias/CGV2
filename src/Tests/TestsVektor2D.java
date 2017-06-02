/**
 * Created by Ezydenias on 4/13/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;

import Vektor.*;


public class TestsVektor2D {
    //Base Test //Set Position Test
    @Test
    public void testCopyConstruktor() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(a);
        Vektor2D c = new Vektor2D();

        assertEquals(a.x, b.x, 0.0);
        assertEquals(a.y, b.y, 0.0);
        b.setPosition(3, 3);
        assertNotEquals(a.x, b.x, 0.0);
        assertNotEquals(a.y, b.y, 0.0);

        assertEquals(0.0, c.x, 0.0);
        assertEquals(0.0, c.y, 0.0);
    }

    @Test
    public void testInfinityInitialized() {
        Vektor2D a = new Vektor2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Vektor2D b = new Vektor2D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        Vektor2D c = new Vektor2D(3.0, Double.NEGATIVE_INFINITY);
        Vektor2D d = new Vektor2D(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);

        assertEquals(0.0, a.x, 0.0);
        assertEquals(0.0, a.y, 0.0);
        assertEquals(0.0, b.x, 0.0);
        assertEquals(0.0, b.y, 0.0);
        assertEquals(0.0, c.x, 0.0);
        assertEquals(0.0, c.y, 0.0);
        assertEquals(0.0, d.x, 0.0);
        assertEquals(0.0, d.y, 0.0);
    }


    //Add Tests


    @Test(expected = Exception.class)
    public void addOverflowMaxPositive() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.add(a);
    }

    @Test(expected = Exception.class)
    public void addOverflowMaxNegative() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        a.add(a);
    }

    @Test
    public void addOverflowMaxNegativeNegativePositive() {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            a.add(b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflowMaxNegativePositiveNegative() {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            a.add(b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflow() {
        try {
            Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            Vektor2D b = new Vektor2D(-1, -1);

            a.add(b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);

            b.add(a);
            System.out.println(b.x);
            System.out.println(b.y);

            b.setPosition(1.0, 1.0);
            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);

            a.add(b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);

            b.add(a);
            System.out.println(b.x);
            System.out.println(b.y);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void addFunction() {
        try {
            Vektor2D a = new Vektor2D();
            a.setPosition(1, 1);
            Vektor2D b = new Vektor2D();
            b.setPosition(2, 2);

            Vektor2D ddTest = new Vektor2D();
            ddTest.setPosition(3, 3);

            a.add(b);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);

            ddTest.setPosition(6, 6);

            a.add(a);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }

    //Sub Tests
    @Test
    public void subConsistency() {
        try {
            Vektor2D a = new Vektor2D();
            a.setPosition(2.0, 2.0);
            Vektor2D b = new Vektor2D();
            b.setPosition(3.0, 4.0);
            Vektor2D aConsistence = new Vektor2D();
            aConsistence.setPosition(2.0, 2.0);
            Vektor2D bConsistence = new Vektor2D();
            bConsistence.setPosition(3.0, 4.0);
            a.sub(b);
            assertNotEquals(a.x, aConsistence.x, 0.0);
            assertNotEquals(a.y, aConsistence.y, 0.0);
            assertEquals(b.x, bConsistence.x, 0.0);
            assertEquals(b.y, bConsistence.y, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subOverflowMaxPositive() {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            a.sub(a);
        } catch (Exception e) {

        }
    }

    @Test
    public void subOverflowMaxNegative() {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            a.sub(a);
        } catch (Exception e) {

        }

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxNegativePositive() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);

        a.sub(b);

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxPositiveNegative() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);

        a.sub(b);

    }

    @Test
    public void subOverflow() {
        try {
            Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            Vektor2D b = new Vektor2D(-1, -1);

            a.sub(b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);

            b.sub(a);
            System.out.println(b.x);
            System.out.println(b.y);

            b.setPosition(1.0, 1.0);
            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);

            a.sub(b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);

            b.sub(a);
            System.out.println(b.x);
            System.out.println(b.y);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subFunction() {

        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);
        Vektor2D b = new Vektor2D();
        b.setPosition(1, 1);

        Vektor2D addTest = new Vektor2D();
        addTest.setPosition(1, 1);
        try {
            a.sub(b);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, addTest.x, 0.0);
        assertEquals(a.y, addTest.y, 0.0);

    }

    //mult

    @Test(expected = Exception.class)
    public void multOverflowMax() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxNegative() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxLeft() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(1, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxLeftNegative() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(1, -Double.MAX_VALUE);

    }

    @Test(expected = Exception.class)
    public void multOverflowMaxRight() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE, 1);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxRightNegative() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(-Double.MAX_VALUE, 1);
    }


    @Test(expected = Exception.class)
    public void multOverflowMaxBoth() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxBothNegativeLeft() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(-Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxBothNegativeRight() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE, -Double.MAX_VALUE);
    }

    @Test
    public void multZero() {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D b = new Vektor2D();
        b.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor2D c = new Vektor2D();
        c.setPosition(1, 1);
        Vektor2D d = new Vektor2D();
        d.setPosition(-1, -1);

        Vektor2D e = new Vektor2D();
        e.setPosition(0, 0);
        try {
            a.mult(0);
            b.mult(0);
            c.mult(0);
            d.mult(0);
        } catch (Exception ex) {

        }
        assertEquals(a.x, e.x, 0.0);
        assertEquals(a.y, e.y, 0.0);
        assertEquals(b.x, e.x, 0.0);
        assertEquals(b.y, e.y, 0.0);
        assertEquals(c.x, e.x, 0.0);
        assertEquals(c.y, e.y, 0.0);
        assertEquals(d.x, e.x, 0.0);
        assertEquals(d.y, e.y, 0.0);


    }


    @Test
    public void multFunction() {
        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(4, 4);
        try {
            a.mult(2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void multFunctionLeft() {
        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(4, 2);
        try {
            a.mult(2, 1);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.x, ddTest.x, 0.0);
    }

    @Test
    public void multFunctionRight() {
        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(2, 4);
        try {
            a.mult(1, 2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void multFunctionBoth() {
        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(4, 4);
        try {
            a.mult(2, 2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    //div
    //negate all expected exceptions
    @Test
    public void divOverflow() {
        try {
            Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            a.div(Double.MAX_VALUE);

            Vektor2D b = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            b.div(Double.MAX_VALUE);

            Vektor2D c = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            c.div(1, Double.MAX_VALUE);

            Vektor2D d = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            d.div(1, -Double.MAX_VALUE);

            Vektor2D e = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            e.div(Double.MAX_VALUE, 1);

            Vektor2D f = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            f.div(-Double.MAX_VALUE, 1);

            Vektor2D g = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            g.div(Double.MAX_VALUE, Double.MAX_VALUE);

            Vektor2D h = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            h.div(-Double.MAX_VALUE, Double.MAX_VALUE);

            Vektor2D i = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            i.div(Double.MAX_VALUE, -Double.MAX_VALUE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void divOverflowMaxBoth() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(Double.MIN_VALUE, Double.MIN_VALUE);
    }

    @Test(expected = Exception.class)
    public void divOverflowMax() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(Double.MIN_VALUE);
    }

    @Test(expected = Exception.class)
    public void divOverflowMaxRight() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(1, Double.MIN_VALUE);
    }

    @Test(expected = Exception.class)
    public void divOverflowMaxLeft() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(Double.MIN_VALUE, 1);
    }

    @Test(expected = Exception.class)
    public void divZero() throws Exception {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0);
    }

    @Test(expected = Exception.class)
    public void divZeroLeft() throws Exception {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0, 1);
    }

    @Test(expected = Exception.class)
    public void divZeroRight() throws Exception {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(1, 0);
    }

    @Test(expected = Exception.class)
    public void divZeroBoth() throws Exception {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0, 0);
    }


    @Test
    public void divFunction() {
        Vektor2D a = new Vektor2D();
        a.setPosition(4, 4);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(2, 2);
        try {
            a.div(2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void divFunctionLeft() {
        Vektor2D a = new Vektor2D();
        a.setPosition(4, 4);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(2, 4);
        try {
            a.div(2, 1);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void divFunctionRight() {
        Vektor2D a = new Vektor2D();
        a.setPosition(4, 4);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(4, 2);
        try {
            a.div(1, 2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void divFunctionBoth() {
        Vektor2D a = new Vektor2D();
        a.setPosition(4, 4);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(2, 2);
        try {
            a.div(2, 2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    //isEqual
    @Test
    public void isEqualFunction() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(4, 4);

        assertFalse(a.isEqual(c));
        assertFalse(c.isEqual(a));
        assertTrue(a.isEqual(b));
        assertTrue(b.isEqual(a));
    }

    @Test
    public void isEqualSign() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(-2, -2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertFalse(a.isEqual(c));
        assertFalse(c.isEqual(a));
        assertFalse(a.isEqual(b));
        assertFalse(b.isEqual(a));
    }

    @Test
    public void isEqualConsistency() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertFalse(a.isEqual(c));
        assertFalse(c.isEqual(a));
        assertFalse(b.isEqual(c));
        assertFalse(c.isEqual(b));
    }

    //isNotEqual
    @Test
    public void isNotEqualFunction() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(4, 4);

        assertTrue(a.isNotEqual(c));
        assertTrue(c.isNotEqual(a));
        assertFalse(a.isNotEqual(b));
        assertFalse(b.isNotEqual(a));
    }

    @Test
    public void isNotEqualSign() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(-2, -2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertTrue(a.isNotEqual(c));
        assertTrue(c.isNotEqual(a));
        assertTrue(a.isNotEqual(b));
        assertTrue(b.isNotEqual(a));
    }

    @Test
    public void isNotEqualConsistency() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertTrue(a.isNotEqual(c));
        assertTrue(c.isNotEqual(a));
        assertTrue(b.isNotEqual(c));
        assertTrue(c.isNotEqual(b));
    }

    //isNullVector

    @Test
    public void isNullVectorFunction() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(-2, -2);
        Vektor2D c = new Vektor2D(0, 0);

        assertFalse(a.isNullVector());
        assertFalse(b.isNullVector());
        assertTrue(c.isNullVector());
        assertFalse(a.isNullVector());
        assertFalse(b.isNullVector());
        assertTrue(c.isNullVector());
    }

    //Normalize

    @Test
    public void normalizeFunction() {
        Vektor2D a = new Vektor2D(2, 3);
        double j = Math.sqrt(13);
        double k = 2.0 / j;
        double l = 3.0 / j;
        try {
            a.normalize();
        } catch (Exception e) {
        }
        assertEquals(a.x, k, 0.1);
        assertEquals(a.y, l, 0.1);

        assertEquals(a.length(), 1.0, 0.1);
    }

    @Test
    public void normalizeResultLengthisOne() {
        Vektor2D a = new Vektor2D(2, 3);
        double b = 0;
        try {
            a.normalize();
            b = a.length();
        } catch (Exception e) {
        }

        assertEquals(1.0, b, 0.1);
    }

    @Test
    public void normalizevVSequaldistribution() {
        Vektor2D a = new Vektor2D(2, 3);
        double b = 2 + 3;
        double c = 1;
        try {
            a.div(b);
            b = a.x + a.y;
            c = a.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1.0, b, 0.1);
        assertNotEquals(1.0, c, 0.1);
        System.out.println(c);
    }


    //Length

    @Test
    public void lengthFunction() {
        Vektor2D a = new Vektor2D(2, 3);
        double j = Math.sqrt(13);

        assertEquals(a.length(), j, 0.1);


    }

    @Test
    public void lengthConsistency() {
        Vektor2D a = new Vektor2D(2, 3);
        Vektor2D b = new Vektor2D(2, 3);
        a.length();
        assertEquals(a.x, b.x, 0.0);
        assertEquals(a.y, b.y, 0.0);
    }

}