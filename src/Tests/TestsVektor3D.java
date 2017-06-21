/**
 * Created by Ezydenias on 4/13/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;

import Vektor.*;


public class TestsVektor3D {
    //Base Test //Set Position Test
    @Test
    public void testCopyConstruktor() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(a);
        Vektor3D c = new Vektor3D();

        assertEquals(a.x, b.x, 0.0);
        assertEquals(a.y, b.y, 0.0);
        assertEquals(a.z, b.z, 0.0);
        b.setPosition(3, 3, 3);
        assertNotEquals(a.x, b.x, 0.0);
        assertNotEquals(a.y, b.y, 0.0);
        assertNotEquals(a.z, b.z, 0.0);

        assertEquals(0.0, c.x, 0.0);
        assertEquals(0.0, c.y, 0.0);
        assertEquals(0.0, c.z, 0.0);
    }

    @Test
    public void testInfinityInitialized() {
        Vektor3D a = new Vektor3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Vektor3D b = new Vektor3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        Vektor3D c = new Vektor3D(3.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

        assertEquals(0.0, a.x, 0.0);
        assertEquals(0.0, a.y, 0.0);
        assertEquals(0.0, a.z, 0.0);
        assertEquals(0.0, b.x, 0.0);
        assertEquals(0.0, b.y, 0.0);
        assertEquals(0.0, b.z, 0.0);
        assertEquals(0.0, c.x, 0.0);
        assertEquals(0.0, c.y, 0.0);
        assertEquals(0.0, c.z, 0.0);
    }


    //Add Tests


    @Test(expected = Exception.class)
    public void addOverflowMaxPositive() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.add(a);
    }

    @Test(expected = Exception.class)
    public void addOverflowMaxNegative() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.add(a);
    }

    @Test
    public void addOverflowMaxNegativeNegativePositive() {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            a.add(b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflowMaxNegativePositiveNegative() {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            b.add(a);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflow() {
        try {
            Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            Vektor3D b = new Vektor3D(-1, -1, -1);

            a.add(b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            b.add(a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);

            b.setPosition(1.0, 1.0, 1.0);
            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            a.add(b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            b.add(a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void addFunction() {
        try {
            Vektor3D a = new Vektor3D();
            a.setPosition(1, 1, 1);
            Vektor3D b = new Vektor3D();
            b.setPosition(2, 2, 2);

            Vektor3D ddTest = new Vektor3D();
            ddTest.setPosition(3, 3, 3);

            a.add(b);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertEquals(a.z, ddTest.z, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);
            assertNotEquals(a.z, b.z, 0.0);

            ddTest.setPosition(6, 6, 6);

            a.add(a);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertEquals(a.z, ddTest.z, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);
            assertNotEquals(a.z, b.z, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }

    //Sub Tests
    @Test
    public void subConsistency() {
        try {
            Vektor3D a = new Vektor3D();
            a.setPosition(2.0, 2.0, 2.0);
            Vektor3D b = new Vektor3D();
            b.setPosition(3.0, 4.0, 5.0);
            Vektor3D aConsistence = new Vektor3D();
            aConsistence.setPosition(2.0, 2.0, 2.0);
            Vektor3D bConsistence = new Vektor3D();
            bConsistence.setPosition(3.0, 4.0, 5.0);
            a.sub(b);
            assertNotEquals(a.x, aConsistence.x, 0.0);
            assertNotEquals(a.y, aConsistence.y, 0.0);
            assertNotEquals(a.z, aConsistence.z, 0.0);
            assertEquals(b.x, bConsistence.x, 0.0);
            assertEquals(b.y, bConsistence.y, 0.0);
            assertEquals(b.z, bConsistence.z, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subOverflowMaxPositive() {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            a.sub(a);
        } catch (Exception e) {

        }
    }

    @Test
    public void subOverflowMaxNegative() {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            a.sub(a);
        } catch (Exception e) {

        }

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxNegativePositive() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

        a.sub(b);

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxPositiveNegative() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

        a.sub(b);

    }

    @Test
    public void subOverflow() {
        try {
            Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            Vektor3D b = new Vektor3D(-1, -1, -1);

            a.sub(b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            b.sub(a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);

            b.setPosition(1.0, 1.0, 1.0);
            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            a.sub(b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            b.sub(a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subFunction() {

        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);
        Vektor3D b = new Vektor3D();
        b.setPosition(1, 1, 1);

        Vektor3D addTest = new Vektor3D();
        addTest.setPosition(1, 1, 1);
        try {
            a.sub(b);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, addTest.x, 0.0);
        assertEquals(a.y, addTest.y, 0.0);
        assertEquals(a.z, addTest.z, 0.0);
    }

    //mult

    @Test(expected = Exception.class)
    public void multOverflowMax() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxNegative() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxLeft() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(1, 1, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxLeftNegative() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(1, 1, -Double.MAX_VALUE);

    }

    @Test(expected = Exception.class)
    public void multOverflowMaxRight() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE, 1, 1);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxRightNegative() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(-Double.MAX_VALUE, 1, 1);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxMiddle() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(1, Double.MAX_VALUE, 1);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxNegativeMiddle() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(1, -Double.MAX_VALUE, 1);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxBoth() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxBothNegativeLeft() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(-Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxBothNegativeRight() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        a.mult(Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
    }

    @Test
    public void multZero() {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor3D b = new Vektor3D();
        b.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor3D c = new Vektor3D();
        c.setPosition(1, 1, 1);
        Vektor3D d = new Vektor3D();
        d.setPosition(-1, -1, -1);

        Vektor3D e = new Vektor3D();
        e.setPosition(0, 0, 0);
        try {
            a.mult(0);
            b.mult(0);
            c.mult(0);
            d.mult(0);
        } catch (Exception ex) {

        }
        assertEquals(a.x, e.x, 0.0);
        assertEquals(a.y, e.y, 0.0);
        assertEquals(a.z, e.z, 0.0);
        assertEquals(b.x, e.x, 0.0);
        assertEquals(b.y, e.y, 0.0);
        assertEquals(b.z, e.z, 0.0);
        assertEquals(c.x, e.x, 0.0);
        assertEquals(c.y, e.y, 0.0);
        assertEquals(c.z, e.z, 0.0);
        assertEquals(d.x, e.x, 0.0);
        assertEquals(d.y, e.y, 0.0);
        assertEquals(d.z, e.z, 0.0);
    }


    @Test
    public void multFunction() {
        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(4, 4, 4);
        try {
            a.mult(2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void multFunctionLeft() {
        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(4, 2, 2);
        try {
            a.mult(2, 1, 1);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void multFunctionRight() {
        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(2, 2, 4);
        try {
            a.mult(1, 1, 2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void multFunctionMiddle() {
        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(2, 4, 2);
        try {
            a.mult(1, 2, 1);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void multFunctionBoth() {
        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(4, 4, 4);
        try {
            a.mult(2, 2, 2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    //div
    //negate all exotected exceptions
    @Test
    public void divOverflow() {
        try {
            Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            a.div(Double.MAX_VALUE);

            Vektor3D b = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            b.div(Double.MAX_VALUE);

            Vektor3D c = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            c.div(1, 1, Double.MAX_VALUE);

            Vektor3D d = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            d.div(1, 1, -Double.MAX_VALUE);

            Vektor3D e = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            e.div(Double.MAX_VALUE, 1, 1);

            Vektor3D f = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            f.div(-Double.MAX_VALUE, 1, 1);

            Vektor3D g = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            g.div(1, Double.MAX_VALUE, 1);

            Vektor3D h = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            h.div(1, -Double.MAX_VALUE, 1);

            Vektor3D i = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            i.div(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            Vektor3D j = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            j.div(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            Vektor3D k = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            k.div(-Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            Vektor3D l = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            k.div(Double.MAX_VALUE, -Double.MAX_VALUE, Double.MAX_VALUE);

            Vektor3D m = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            k.div(Double.MAX_VALUE, Double.MAX_VALUE, -Double.MAX_VALUE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test(expected = Exception.class)
    public void divZero() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0);
    }

    @Test(expected = Exception.class)
    public void divZeroLeft() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0, 0, 1);
    }

    @Test(expected = Exception.class)
    public void divZeroRight() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(1, 0, 0);
    }

    @Test(expected = Exception.class)
    public void divZeroMiddle() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0, 1, 0);
    }

    @Test(expected = Exception.class)
    public void divZeroBoth() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        a.div(0, 0, 0);
    }

    @Test
    public void divFunction() {
        Vektor3D a = new Vektor3D();
        a.setPosition(4, 4, 4);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(2, 2, 2);
        try {
            a.div(2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void divFunctionLeft() {
        Vektor3D a = new Vektor3D();
        a.setPosition(4, 4, 4);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(2, 4, 4);
        try {
            a.div(2, 1, 1);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void divFunctionRight() {
        Vektor3D a = new Vektor3D();
        a.setPosition(4, 4, 4);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(4, 4, 2);
        try {
            a.div(1, 1, 2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void divFunctionMiddle() {
        Vektor3D a = new Vektor3D();
        a.setPosition(4, 4, 4);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(4, 2, 4);
        try {
            a.div(1, 2, 1);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test
    public void divFunctionBoth() {
        Vektor3D a = new Vektor3D();
        a.setPosition(4, 4, 4);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(2, 2, 2);
        try {
            a.div(2, 2, 2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    //isEqual
    @Test
    public void isEqualFunction() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(4, 4, 4);

        assertFalse(a.isEqual(c));
        assertFalse(c.isEqual(a));
        assertTrue(a.isEqual(b));
        assertTrue(b.isEqual(a));
    }

    @Test
    public void isEqualSign() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(-2, -2, -2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertFalse(a.isEqual(c));
        assertFalse(c.isEqual(a));
        assertFalse(a.isEqual(b));
        assertFalse(b.isEqual(a));
    }

    @Test
    public void isEqualConsistency() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertFalse(a.isEqual(c));
        assertFalse(c.isEqual(a));
        assertFalse(b.isEqual(c));
        assertFalse(c.isEqual(b));
    }

    //isNotEqual
    @Test
    public void isNotEqualFunction() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(4, 4, 4);

        assertTrue(a.isNotEqual(c));
        assertTrue(c.isNotEqual(a));
        assertFalse(a.isNotEqual(b));
        assertFalse(b.isNotEqual(a));
    }

    @Test
    public void isNotEqualSign() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(-2, -2, -2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertTrue(a.isNotEqual(c));
        assertTrue(c.isNotEqual(a));
        assertTrue(a.isNotEqual(b));
        assertTrue(b.isNotEqual(a));
    }

    @Test
    public void isNotEqualConsistency() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertTrue(a.isNotEqual(c));
        assertTrue(c.isNotEqual(a));
        assertTrue(b.isNotEqual(c));
        assertTrue(c.isNotEqual(b));
    }

    //isNullVector

    @Test
    public void isNullVectorFunction() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(-2, -2, -2);
        Vektor3D c = new Vektor3D(0, 0, 0);

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
        Vektor3D a = new Vektor3D(2, 3, 4);
        double j = Math.sqrt(29);
        double k = 2.0 / j;
        double l = 3.0 / j;
        double m = 4.0 / j;
        try {
            a.normalize();
        } catch (Exception e) {
        }
        assertEquals(a.x, k, 0.1);
        assertEquals(a.y, l, 0.1);
        assertEquals(a.z, m, 0.1);
    }

    //Length

    @Test
    public void lengthFunction() {
        Vektor3D a = new Vektor3D(2, 3, 4);
        double j = Math.sqrt(29);

        assertEquals(a.length(), j, 0.1);


    }

    @Test
    public void lengthConsistency() {
        Vektor3D a = new Vektor3D(2, 3, 4);
        Vektor3D b = new Vektor3D(2, 3, 4);
        a.length();
        assertEquals(a.x, b.x, 0.0);
        assertEquals(a.y, b.y, 0.0);
        assertEquals(a.z, b.z, 0.0);
    }

}