/**
 * Created by Ezydenias on 4/17/2017.
 */

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import Vektor.*;
import org.junit.Test;

import static org.junit.Assert.*;

import Vektor.*;
import org.omg.IOP.ExceptionDetailMessage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class TestsLineareAlgebra {


//Add Test

    @Test(expected = Exception.class)
    public void addOverflowMaxPositive3D() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.add(a, a);
    }

    @Test(expected = Exception.class)
    public void addOverflowMaxNegative3D() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        LineareAlgebra.add(a, a);
    }

    @Test
    public void addOverflowMaxNegativeNegativePositive3D() {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            LineareAlgebra.add(a, b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflowMaxNegativePositiveNegative3D() {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            LineareAlgebra.add(a, b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflow3D() {
        try {
            Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            Vektor3D b = new Vektor3D(-1, -1, -1);

            a = LineareAlgebra.add(a, b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            b = LineareAlgebra.add(b, a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);

            b.setPosition(1.0, 1.0, 1.0);
            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            a = LineareAlgebra.add(a, b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            b = LineareAlgebra.add(b, a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.y);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void addFunktion3D() {
        try {
            Vektor3D a = new Vektor3D();
            a.setPosition(1, 1, 1);
            Vektor3D b = new Vektor3D();
            b.setPosition(2, 2, 2);

            Vektor3D ddTest = new Vektor3D();
            ddTest.setPosition(3, 3, 3);

            a = LineareAlgebra.add(a, b);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertEquals(a.z, ddTest.z, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);
            assertNotEquals(a.z, b.z, 0.0);

            ddTest.setPosition(6, 6, 6);

            a = LineareAlgebra.add(a, a);
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

    @Test(expected = Exception.class)
    public void addOverflowMaxPositive2D() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.add(a, a);
    }

    @Test(expected = Exception.class)
    public void addOverflowMaxNegative2D() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        LineareAlgebra.add(a, a);
    }

    @Test
    public void addOverflowMaxNegativeNegativePositive2D() {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            LineareAlgebra.add(a, b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflowMaxNegativePositiveNegative2D() {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            LineareAlgebra.add(a, b);
        } catch (Exception e) {

        }
    }

    @Test
    public void addOverflow2D() {
        try {
            Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            Vektor2D b = new Vektor2D(-1, -1);

            a = LineareAlgebra.add(a, b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);

            b = LineareAlgebra.add(b, a);
            System.out.println(b.x);
            System.out.println(b.y);

            b.setPosition(1.0, 1.0);
            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);

            a = LineareAlgebra.add(a, b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);

            b = LineareAlgebra.add(b, a);
            System.out.println(b.x);
            System.out.println(b.y);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void addFunktion2D() {
        try {
            Vektor2D a = new Vektor2D();
            a.setPosition(1, 1);
            Vektor2D b = new Vektor2D();
            b.setPosition(2, 2);

            Vektor2D ddTest = new Vektor2D();
            ddTest.setPosition(3, 3);

            a = LineareAlgebra.add(a, b);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);

            ddTest.setPosition(6, 6);

            a = LineareAlgebra.add(a, a);
            assertEquals(a.x, ddTest.x, 0.0);
            assertEquals(a.y, ddTest.y, 0.0);
            assertNotEquals(a.x, b.x, 0.0);
            assertNotEquals(a.y, b.y, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void AddConsistency() {
        try {
            Vektor2D a = new Vektor2D(2, 2);
            Vektor2D atest = new Vektor2D(2, 2);
            Vektor2D b = new Vektor2D(2, 2);
            Vektor2D btest = new Vektor2D(2, 2);

            Vektor3D c = new Vektor3D(2, 2, 2);
            Vektor3D ctest = new Vektor3D(2, 2, 2);
            Vektor3D d = new Vektor3D(2, 2, 2);
            Vektor3D dtest = new Vektor3D(2, 2, 2);


            LineareAlgebra.add(a, b);
            LineareAlgebra.add(c, d);

            assertEquals(a.x, atest.x, 0.0);
            assertEquals(a.y, atest.y, 0.0);
            assertEquals(b.x, btest.x, 0.0);
            assertEquals(b.y, btest.y, 0.0);

            assertEquals(c.x, ctest.x, 0.0);
            assertEquals(c.y, ctest.y, 0.0);
            assertEquals(c.z, ctest.z, 0.0);

            assertEquals(d.x, dtest.x, 0.0);
            assertEquals(d.y, dtest.y, 0.0);
            assertEquals(d.z, dtest.z, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


//Sub Test

    @Test
    public void subConsistency3D() {
        try {
            Vektor3D a = new Vektor3D();
            a.setPosition(2.0, 2.0, 2.0);
            Vektor3D b = new Vektor3D();
            b.setPosition(3.0, 4.0, 5.0);
            Vektor3D aConsistence = new Vektor3D();
            aConsistence.setPosition(2.0, 2.0, 2.0);
            Vektor3D bConsistence = new Vektor3D();
            bConsistence.setPosition(3.0, 4.0, 5.0);
            a = LineareAlgebra.sub(a, b);
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
    public void subOverflowMaxPositive3D() {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            LineareAlgebra.sub(a, a);
        } catch (Exception e) {

        }
    }

    @Test
    public void subOverflowMaxNegative3D() {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            LineareAlgebra.sub(a, a);
        } catch (Exception e) {

        }

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxNegativePositive3D() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

        LineareAlgebra.sub(a, b);

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxPositiveNegative3D() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor3D b = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

        LineareAlgebra.sub(a, b);

    }

    @Test
    public void subOverflow3D() {
        try {
            Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            Vektor3D b = new Vektor3D(-1, -1, -1);

            a = LineareAlgebra.sub(a, b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);

            b = LineareAlgebra.sub(b, a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);

            b.setPosition(1.0, 1.0, 1.0);
            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            a = LineareAlgebra.sub(a, b);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            b = LineareAlgebra.sub(b, a);
            System.out.println(a.x);
            System.out.println(a.y);
            System.out.println(a.z);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subFunction3D() {

        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);
        Vektor3D b = new Vektor3D();
        b.setPosition(1, 1, 1);

        Vektor3D addTest = new Vektor3D();
        addTest.setPosition(1, 1, 1);
        try {
            a = LineareAlgebra.sub(a, b);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, addTest.x, 0.0);
        assertEquals(a.y, addTest.y, 0.0);
        assertEquals(a.z, addTest.z, 0.0);
    }

    @Test
    public void subConsistency2D() {
        try {
            Vektor2D a = new Vektor2D();
            a.setPosition(2.0, 2.0);
            Vektor2D b = new Vektor2D();
            b.setPosition(3.0, 4.0);
            Vektor2D aConsistence = new Vektor2D();
            aConsistence.setPosition(2.0, 2.0);
            Vektor2D bConsistence = new Vektor2D();
            bConsistence.setPosition(3.0, 4.0);
            a = LineareAlgebra.sub(a, b);
            assertNotEquals(a.x, aConsistence.x, 0.0);
            assertNotEquals(a.y, aConsistence.y, 0.0);
            assertEquals(b.x, bConsistence.x, 0.0);
            assertEquals(b.y, bConsistence.y, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subOverflowMaxPositive2D() {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        try {
            LineareAlgebra.sub(a, a);
        } catch (Exception e) {

        }
    }

    @Test
    public void subOverflowMaxNegative2D() {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        try {
            LineareAlgebra.sub(a, a);
        } catch (Exception e) {

        }

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxNegativePositive2D() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);

        LineareAlgebra.sub(a, b);

    }

    @Test(expected = Exception.class)
    public void subOverflowMaxPositiveNegative2D() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D b = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);

        LineareAlgebra.sub(a, b);

    }

    @Test
    public void subOverflow2D() {
        try {
            Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            Vektor2D b = new Vektor2D(-1, -1);

            a = LineareAlgebra.sub(a, b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(-Double.MAX_VALUE, -Double.MAX_VALUE);

            b = LineareAlgebra.sub(b, a);
            System.out.println(b.x);
            System.out.println(b.y);

            b.setPosition(1.0, 1.0);
            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);

            a = LineareAlgebra.sub(a, b);
            System.out.println(a.x);
            System.out.println(a.y);

            a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);

            b = LineareAlgebra.sub(b, a);
            System.out.println(b.x);
            System.out.println(b.y);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


    @Test
    public void subFunction2D() {

        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);
        Vektor2D b = new Vektor2D();
        b.setPosition(1, 1);

        Vektor2D addTest = new Vektor2D();
        addTest.setPosition(1, 1);
        try {
            a = LineareAlgebra.sub(a, b);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, addTest.x, 0.0);
        assertEquals(a.y, addTest.y, 0.0);

    }

    @Test
    public void subConsistencyLineareAlgebraExclusive() {
        try {
            Vektor2D a = new Vektor2D(2, 2);
            Vektor2D atest = new Vektor2D(2, 2);
            Vektor2D b = new Vektor2D(2, 2);
            Vektor2D btest = new Vektor2D(2, 2);

            Vektor3D c = new Vektor3D(2, 2, 2);
            Vektor3D ctest = new Vektor3D(2, 2, 2);
            Vektor3D d = new Vektor3D(2, 2, 2);
            Vektor3D dtest = new Vektor3D(2, 2, 2);

            LineareAlgebra.add(a, b);
            LineareAlgebra.add(c, d);

            assertEquals(a.x, atest.x, 0.0);
            assertEquals(a.y, atest.y, 0.0);
            assertEquals(b.x, btest.x, 0.0);
            assertEquals(b.y, btest.y, 0.0);

            assertEquals(c.x, ctest.x, 0.0);
            assertEquals(c.y, ctest.y, 0.0);
            assertEquals(c.z, ctest.z, 0.0);

            assertEquals(d.x, dtest.x, 0.0);
            assertEquals(d.y, dtest.y, 0.0);
            assertEquals(d.z, dtest.z, 0.0);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


//Mult Test

    @Test(expected = Exception.class)
    public void multOverflowMax3D() throws Exception {
        Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.mult(a, Double.MAX_VALUE);
    }

    @Test(expected = Exception.class)
    public void multOverflowMaxNegative3D() throws Exception {
        Vektor3D a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        LineareAlgebra.mult(a, Double.MAX_VALUE);
    }


    @Test
    public void multZero3D() {
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
            a = LineareAlgebra.mult(a, 0);
            b = LineareAlgebra.mult(b, 0);
            c = LineareAlgebra.mult(c, 0);
            d = LineareAlgebra.mult(d, 0);
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
    public void multFunction3D() {
        Vektor3D a = new Vektor3D();
        a.setPosition(2, 2, 2);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(4, 4, 4);
        try {
            a = LineareAlgebra.mult(a, 2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test(expected = Exception.class)
    public void multOverflowMax2D() throws Exception {
        Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.mult(a, Double.MAX_VALUE);
    }


    @Test(expected = Exception.class)
    public void multOverflowMaxNegative2D() throws Exception {
        Vektor2D a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        LineareAlgebra.mult(a, Double.MAX_VALUE);
    }


    @Test
    public void multZero2D() {
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
            a = LineareAlgebra.mult(a, 0);
            b = LineareAlgebra.mult(b, 0);
            c = LineareAlgebra.mult(c, 0);
            d = LineareAlgebra.mult(d, 0);
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
    public void multFunction2D() {
        Vektor2D a = new Vektor2D();
        a.setPosition(2, 2);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(4, 4);
        try {
            a = LineareAlgebra.mult(a, 2);
        } catch (Exception e) {

        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }


    @Test
    public void multConsistencyLineareAlgebraExclusive() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D aTest = new Vektor2D(2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D bTest = new Vektor3D(2, 2, 2);
        try {
            LineareAlgebra.mult(a, 2);
            LineareAlgebra.mult(b, 2);
        } catch (Exception e) {

        }
        assertEquals(aTest.x, a.x, 0.0);
        assertEquals(aTest.y, a.y, 0.0);
        assertEquals(bTest.x, b.x, 0.0);
        assertEquals(bTest.y, b.y, 0.0);
        assertEquals(bTest.z, b.z, 0.0);
    }


//Div Test

    @Test
    public void divOverflow3D() {
        try {
            Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
            LineareAlgebra.div(a, Double.MAX_VALUE);

            Vektor3D b = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
            LineareAlgebra.div(b, Double.MAX_VALUE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void divFunction3D() {
        Vektor3D a = new Vektor3D();
        a.setPosition(4, 4, 4);

        Vektor3D ddTest = new Vektor3D();
        ddTest.setPosition(2, 2, 2);
        try {
            a = LineareAlgebra.div(a, 2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
        assertEquals(a.z, ddTest.z, 0.0);
    }

    @Test(expected = Exception.class)
    public void divZero3D() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.div(a, 0);
    }

    @Test(expected = Exception.class)
    public void divSmallValue3D() throws Exception {
        Vektor3D a = new Vektor3D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.div(a, Double.MIN_VALUE);
    }

    @Test(expected = Exception.class)
    public void divSmallValue2D() throws Exception {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.div(a, Double.MIN_VALUE);
    }

    @Test
    public void divOverflow2D() {
        try {
            Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
            LineareAlgebra.div(a, Double.MAX_VALUE);

            Vektor2D b = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
            LineareAlgebra.div(b, Double.MAX_VALUE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test(expected = Exception.class)
    public void divZero2D() throws Exception {
        Vektor2D a = new Vektor2D();
        a.setPosition(Double.MAX_VALUE, Double.MAX_VALUE);
        LineareAlgebra.div(a, 0);
    }


    @Test
    public void DivFunction2D() {
        Vektor2D a = new Vektor2D();
        a.setPosition(4, 4);

        Vektor2D ddTest = new Vektor2D();
        ddTest.setPosition(2, 2);
        try {
            a = LineareAlgebra.div(a, 2);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(a.x, ddTest.x, 0.0);
        assertEquals(a.y, ddTest.y, 0.0);
    }

    @Test
    public void divConsistencyLineareAlgebraExclusive3D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D aTest = new Vektor2D(2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D bTest = new Vektor3D(2, 2, 2);
        try {
            LineareAlgebra.div(a, 2);
            LineareAlgebra.div(b, 2);
        } catch (Exception e) {

        }
        assertEquals(aTest.x, a.x, 0.0);
        assertEquals(aTest.y, a.y, 0.0);
        assertEquals(bTest.x, b.x, 0.0);
        assertEquals(bTest.y, b.y, 0.0);
        assertEquals(bTest.z, b.z, 0.0);
    }

//IsEqual Test

    @Test
    public void isEqualFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(4, 4, 4);

        assertFalse(LineareAlgebra.isEqual(c, a));
        assertFalse(LineareAlgebra.isEqual(a, c));
        assertTrue(LineareAlgebra.isEqual(b, a));
        assertTrue(LineareAlgebra.isEqual(a, b));
    }

    @Test
    public void isEqualSign3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(-2, -2, -2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertFalse(LineareAlgebra.isEqual(c, a));
        assertFalse(LineareAlgebra.isEqual(a, c));
        assertFalse(LineareAlgebra.isEqual(b, a));
        assertFalse(LineareAlgebra.isEqual(a, b));
    }

    @Test
    public void isEqualConsistency3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertFalse(LineareAlgebra.isEqual(c, a));
        assertFalse(LineareAlgebra.isEqual(a, c));
        assertFalse(LineareAlgebra.isEqual(c, b));
        assertFalse(LineareAlgebra.isEqual(b, c));
    }

    @Test
    public void isEqualFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(4, 4);

        assertFalse(LineareAlgebra.isEqual(c, a));
        assertFalse(LineareAlgebra.isEqual(a, c));
        assertTrue(LineareAlgebra.isEqual(b, a));
        assertTrue(LineareAlgebra.isEqual(a, b));
    }

    @Test
    public void isEqualSign2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(-2, -2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertFalse(LineareAlgebra.isEqual(c, a));
        assertFalse(LineareAlgebra.isEqual(a, c));
        assertFalse(LineareAlgebra.isEqual(b, a));
        assertFalse(LineareAlgebra.isEqual(a, b));
    }

    @Test
    public void isEqualConsistency2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertFalse(LineareAlgebra.isEqual(c, a));
        assertFalse(LineareAlgebra.isEqual(a, c));
        assertFalse(LineareAlgebra.isEqual(c, b));
        assertFalse(LineareAlgebra.isEqual(b, c));
    }

//IsNotEqual Test

    @Test
    public void isNotEqualFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(4, 4);

        assertTrue(LineareAlgebra.isNotEqual(c, a));
        assertTrue(LineareAlgebra.isNotEqual(a, c));
        assertFalse(LineareAlgebra.isNotEqual(b, a));
        assertFalse(LineareAlgebra.isNotEqual(a, b));
    }

    @Test
    public void isNotEqualSign2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(-2, -2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertTrue(LineareAlgebra.isNotEqual(c, a));
        assertTrue(LineareAlgebra.isNotEqual(a, c));
        assertTrue(LineareAlgebra.isNotEqual(b, a));
        assertTrue(LineareAlgebra.isNotEqual(a, b));
    }

    @Test
    public void isNotEqualConsistency2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(-4, -4);

        assertTrue(LineareAlgebra.isNotEqual(c, a));
        assertTrue(LineareAlgebra.isNotEqual(a, c));
        assertTrue(LineareAlgebra.isNotEqual(c, b));
        assertTrue(LineareAlgebra.isNotEqual(b, c));
    }

    @Test
    public void isNotEqualFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(4, 4, 4);

        assertTrue(LineareAlgebra.isNotEqual(c, a));
        assertTrue(LineareAlgebra.isNotEqual(a, c));
        assertFalse(LineareAlgebra.isNotEqual(b, a));
        assertFalse(LineareAlgebra.isNotEqual(a, b));
    }

    @Test
    public void isNotEqualSign3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(-2, -2, -2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertTrue(LineareAlgebra.isNotEqual(c, a));
        assertTrue(LineareAlgebra.isNotEqual(a, c));
        assertTrue(LineareAlgebra.isNotEqual(b, a));
        assertTrue(LineareAlgebra.isNotEqual(a, b));
    }

    @Test
    public void isNotEqualConsistency3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D c = new Vektor3D(-4, -4, -4);

        assertTrue(LineareAlgebra.isNotEqual(c, a));
        assertTrue(LineareAlgebra.isNotEqual(a, c));
        assertTrue(LineareAlgebra.isNotEqual(c, b));
        assertTrue(LineareAlgebra.isNotEqual(b, c));
    }


//Length Test

    @Test
    public void lengthFunction3D() {
        Vektor3D a = new Vektor3D(2, 3, 4);
        double j = Math.sqrt(29);

        assertEquals(LineareAlgebra.length(a), j, 0.1);


    }

    @Test
    public void lengthConsistency3D() {
        Vektor3D a = new Vektor3D(2, 3, 4);
        Vektor3D b = new Vektor3D(2, 3, 4);
        LineareAlgebra.length(a);
        assertEquals(a.x, b.x, 0.0);
        assertEquals(a.y, b.y, 0.0);
        assertEquals(a.z, b.z, 0.0);
    }

    @Test
    public void lengthFunction2D() {
        Vektor2D a = new Vektor2D(2, 3);
        double j = Math.sqrt(13);

        assertEquals(LineareAlgebra.length(a), j, 0.1);


    }

    @Test
    public void lengthConsistency2D() {
        Vektor2D a = new Vektor2D(2, 3);
        Vektor2D b = new Vektor2D(2, 3);
        LineareAlgebra.length(a);
        assertEquals(a.x, b.x, 0.0);
        assertEquals(a.y, b.y, 0.0);
    }

//Normalize Test

    @Test
    public void normalizeFunction3D() {
        Vektor3D a = new Vektor3D(2, 3, 4);
        double j = Math.sqrt(29);
        double k = 2.0 / j;
        double l = 3.0 / j;
        double m = 4.0 / j;
        try {
            a = LineareAlgebra.normalize(a);
        } catch (Exception e) {
        }
        assertEquals(a.x, k, 0.1);
        assertEquals(a.y, l, 0.1);
        assertEquals(a.z, m, 0.1);

    }

    @Test
    public void normalizeFunction2D() {
        Vektor2D a = new Vektor2D(2, 3);
        double j = Math.sqrt(13);
        double k = 2.0 / j;
        double l = 3.0 / j;
        try {
            a = LineareAlgebra.normalize(a);
        } catch (Exception e) {
        }
        assertEquals(a.x, k, 0.1);
        assertEquals(a.y, l, 0.1);
    }

    @Test
    public void normalizeConsistency() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D aTest = new Vektor2D(2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D bTest = new Vektor3D(2, 2, 2);
        try {
            LineareAlgebra.normalize(a);
            LineareAlgebra.normalize(b);
        } catch (Exception e) {

        }
        assertEquals(aTest.x, a.x, 0.0);
        assertEquals(aTest.y, a.y, 0.0);
        assertEquals(bTest.x, b.x, 0.0);
        assertEquals(bTest.y, b.y, 0.0);
        assertEquals(bTest.z, b.z, 0.0);
    }

//EuklDistance Test

    @Test
    public void euklDistanceFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(4, 6);
        Vektor2D c = new Vektor2D(2, 2);
        Vektor2D d = new Vektor2D(4, 6);
        double test = 4.472;
        double e, f;
        e = LineareAlgebra.euklDistance(a, b);
        f = LineareAlgebra.euklDistance(d, c);

        assertEquals(e, f, 0.0);
        assertEquals(test, e, 0.1);
    }

    @Test
    public void euklDistanceFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(4, 6, 8);
        Vektor3D c = new Vektor3D(2, 2, 2);
        Vektor3D d = new Vektor3D(4, 6, 8);
        double test = 7.483;
        double e, f;
        e = LineareAlgebra.euklDistance(a, b);
        f = LineareAlgebra.euklDistance(d, c);

        assertEquals(e, f, 0.0);
        assertEquals(test, e, 0.1);
    }

    @Test
    public void euklDistanceFunctionZero2D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        double e;

        e = LineareAlgebra.euklDistance(a, a);

        assertEquals(0.0, e, 0.0);
    }

    @Test
    public void euklDistanceFunctionZero3D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(2, 2);
        double e;

        e = LineareAlgebra.euklDistance(a, a);

        assertEquals(0.0, e, 0.0);
    }

    @Test
    public void euklDistanceConsistency() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D atest = new Vektor2D(2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 2);

        LineareAlgebra.euklDistance(a, a);
        LineareAlgebra.euklDistance(b, b);

        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }

//ManhattenDistance Test

    @Test
    public void manhattenDistanceFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(4, 6, 8);
        Vektor3D c = new Vektor3D(2, 2, 2);
        Vektor3D d = new Vektor3D(4, 6, 8);
        double test = 12.0;
        double e, f;
        e = LineareAlgebra.manhattenDistance(a, b);
        f = LineareAlgebra.manhattenDistance(d, c);

        assertEquals(e, f, 0.0);
        assertEquals(test, e, 0.1);
    }

    @Test
    public void manhattenDistanceFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(4, 6);
        Vektor2D c = new Vektor2D(2, 2);
        Vektor2D d = new Vektor2D(4, 6);
        double test = 6.0;
        double e, f;
        e = LineareAlgebra.manhattenDistance(a, b);
        f = LineareAlgebra.manhattenDistance(d, c);

        assertEquals(e, f, 0.0);
        assertEquals(test, e, 0.1);
    }

    @Test
    public void manhattenDistanceFunctionZero3D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D c = new Vektor2D(2, 2);
        double e;

        e = LineareAlgebra.manhattenDistance(a, a);

        assertEquals(0.0, e, 0.0);
    }

    @Test
    public void manhattenDistanceFunctionZero2D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        double e;

        e = LineareAlgebra.manhattenDistance(a, a);

        assertEquals(0.0, e, 0.0);
    }

    @Test
    public void manhattenDistanceConsistency() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D atest = new Vektor2D(2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 2);

        LineareAlgebra.manhattenDistance(a, a);
        LineareAlgebra.manhattenDistance(b, b);

        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }


//CrossProduct Test


    @Test
    public void crossProductFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(4, 6, 8);
        Vektor3D c = new Vektor3D(2, 2, 2);
        Vektor3D d = new Vektor3D(4, 6, 8);
        Vektor3D atest = new Vektor3D(4, -8, 4);
        Vektor3D btest = new Vektor3D(-4, 8, -4);
        a = LineareAlgebra.crossProduct(a, b);
        b = LineareAlgebra.crossProduct(d, c);

        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(atest.z, a.z, 0.0);

        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }

    @Test
    public void crossProductFunctionZero3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);

        a = LineareAlgebra.crossProduct(a, a);

        assertEquals(0.0, a.x, 0.0);
        assertEquals(0.0, a.y, 0.0);
        assertEquals(0.0, a.z, 0.0);
    }

    @Test
    public void crossProductConsistency() {
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 2);

        LineareAlgebra.crossProduct(b, b);

        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }


//DotProduct Test

    @Test
    public void dotProductFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(4, 6, 8);
        Vektor3D c = new Vektor3D(2, 2, 2);//8 12 16
        Vektor3D d = new Vektor3D(4, 6, 8);
        double test = 36.0;
        double e, f;
        e = LineareAlgebra.dotProduct(a, b);
        f = LineareAlgebra.dotProduct(d, c);

        assertEquals(e, f, 0.0);
        assertEquals(test, e, 0.1);
    }

    @Test
    public void dotProductFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(4, 6);
        Vektor2D c = new Vektor2D(2, 2);
        Vektor2D d = new Vektor2D(4, 6);
        double test = 20.0;
        double e, f;
        e = LineareAlgebra.dotProduct(a, b);
        f = LineareAlgebra.dotProduct(d, c);

        assertEquals(e, f, 0.0);
        assertEquals(test, e, 0.1);
    }

    @Test
    public void dotProductConsistency() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D atest = new Vektor2D(2, 2);
        Vektor3D b = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 2);

        LineareAlgebra.dotProduct(a, a);
        LineareAlgebra.dotProduct(b, b);

        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }

//CosEquation Test

    @Test
    public void cosEquationFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        double testa = 0;
        double testb = 0;
        double controllvalue = 0.98019;
        try {
            testa = LineareAlgebra.cosEquation(a, b);
            testb = LineareAlgebra.cosEquation(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void cosEquationZero3D() throws Exception {
        Vektor3D a = new Vektor3D(0, 0, 0);
        Vektor3D b = new Vektor3D(0, 0, 0);
        double testa = 0;
        double testb = 0;

        testa = LineareAlgebra.cosEquation(a, b);
        testb = LineareAlgebra.cosEquation(b, a);


    }

    @Test
    public void cosEquationConsistency3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        Vektor3D atest = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 3);
        try {
            LineareAlgebra.cosEquation(a, b);
            LineareAlgebra.cosEquation(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(atest.z, a.z, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }

    @Test
    public void cosEquationFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 3);
        double testa = 0;
        double testb = 0;
        double controllvalue = 0.98058;
        try {
            testa = LineareAlgebra.cosEquation(a, b);
            testb = LineareAlgebra.cosEquation(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void cosEquationZero2D() throws Exception {
        Vektor2D a = new Vektor2D(0, 0);
        Vektor2D b = new Vektor2D(0, 0);
        double testa = 0;
        double testb = 0;

        testa = LineareAlgebra.cosEquation(a, b);
        testb = LineareAlgebra.cosEquation(b, a);


    }

    @Test
    public void cosEquationConsistency2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 3);
        Vektor2D atest = new Vektor2D(2, 2);
        Vektor2D btest = new Vektor2D(2, 3);
        try {
            LineareAlgebra.cosEquation(a, b);
            LineareAlgebra.cosEquation(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);

    }


//SinEquation Test

    @Test
    public void sinEquationFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        double testa = LineareAlgebra.length(a);
        double testb = LineareAlgebra.length(b);
        double controllvalue = LineareAlgebra.length(LineareAlgebra.crossProduct(a, b));
        controllvalue = (controllvalue / (testa * testb));
        try {
            testa = LineareAlgebra.sinEquation(a, b);
            testb = LineareAlgebra.sinEquation(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void sinEquationZero3D() throws Exception {
        Vektor3D a = new Vektor3D(0, 0, 0);
        Vektor3D b = new Vektor3D(0, 0, 0);
        double testa = 0;
        double testb = 0;

        testa = LineareAlgebra.sinEquation(a, b);
        testb = LineareAlgebra.sinEquation(b, a);

    }

    @Test
    public void sinEquationConsistency3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        Vektor3D atest = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 3);
        try {
            LineareAlgebra.sinEquation(a, b);
            LineareAlgebra.sinEquation(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(atest.z, a.z, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }


//AngleRad Test

    @Test
    public void angleRadFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        double testa = 0;
        double testb = 0;
        double controllvalue = 0.19938;
        try {
            testa = LineareAlgebra.angleRad(a, b);
            testb = LineareAlgebra.angleRad(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void angleRadZero3D() throws Exception {
        Vektor3D a = new Vektor3D(0, 0, 0);
        Vektor3D b = new Vektor3D(0, 0, 0);
        double testa = 0;
        double testb = 0;

        testa = LineareAlgebra.angleRad(a, b);
        testb = LineareAlgebra.angleRad(b, a);

    }

    @Test
    public void angleRad903D() {
        Vektor3D a = new Vektor3D(1, 0, 0);
        Vektor3D b = new Vektor3D(0, 1, 0);
        Vektor3D c = new Vektor3D(0, 0, 1);
        double testa = 0;
        double testb = 0;
        double testc = 0;
        try {
            testa = LineareAlgebra.angleRad(a, b);
            testb = LineareAlgebra.angleRad(b, a);
            testc = LineareAlgebra.angleRad(c, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(Math.PI / 2, testa, 0.01);
        assertEquals(Math.PI / 2, testb, 0.01);
        assertEquals(Math.PI / 2, testc, 0.01);
    }

    @Test
    public void angleRadConsistency3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        Vektor3D atest = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 3);
        try {
            LineareAlgebra.angleRad(a, b);
            LineareAlgebra.angleRad(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(atest.z, a.z, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }

    @Test
    public void angleRadFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 3);
        double testa = 0;
        double testb = 0;
        double controllvalue = 0.1974;
        try {
            testa = LineareAlgebra.angleRad(a, b);
            testb = LineareAlgebra.angleRad(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void angleRadZero2D() throws Exception {
        Vektor2D a = new Vektor2D(0, 0);
        Vektor2D b = new Vektor2D(0, 0);
        double testa = 0;
        double testb = 0;

        try {
            testa = LineareAlgebra.angleRad(a, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        testb = LineareAlgebra.angleRad(b, a);

    }

    @Test
    public void angleRad902D() {
        Vektor2D a = new Vektor2D(1, 0);
        Vektor2D b = new Vektor2D(0, 1);
        double testa = 0;
        double testb = 0;
        try {
            testa = LineareAlgebra.angleRad(a, b);
            testb = LineareAlgebra.angleRad(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(Math.PI / 2, testb, 0.01);
        assertEquals(Math.PI / 2, testb, 0.01);
    }

    @Test
    public void angleRadConsistency2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 3);
        Vektor2D atest = new Vektor2D(2, 2);
        Vektor2D btest = new Vektor2D(2, 3);
        try {
            LineareAlgebra.angleRad(a, b);
            LineareAlgebra.angleRad(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);

    }

//AngleDegree Test


    @Test
    public void angleDegreeFunction3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        double testa = 0;
        double testb = 0;
        double controllvalue = 11.4235;
        try {
            testa = LineareAlgebra.angleDegree(a, b);
            testb = LineareAlgebra.angleDegree(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void angleDegreeZero3D() throws Exception {
        Vektor3D a = new Vektor3D(0, 0, 0);
        Vektor3D b = new Vektor3D(0, 0, 0);
        double testa = 0;
        double testb = 0;

        testa = LineareAlgebra.angleDegree(a, b);
        testb = LineareAlgebra.angleDegree(b, a);


    }

    @Test
    public void angleDegree903D() {
        Vektor3D a = new Vektor3D(1, 0, 0);
        Vektor3D b = new Vektor3D(0, 1, 0);
        Vektor3D c = new Vektor3D(0, 0, 1);
        double testa = 0;
        double testb = 0;
        double testc = 0;
        try {
            testa = LineareAlgebra.angleDegree(a, b);
            testb = LineareAlgebra.angleDegree(b, a);
            testc = LineareAlgebra.angleDegree(c, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(90.0, testb, 0.01);
        assertEquals(90.0, testb, 0.01);
        assertEquals(90.0, testc, 0.01);

    }

    @Test
    public void angleDegreeConsistency3D() {
        Vektor3D a = new Vektor3D(2, 2, 2);
        Vektor3D b = new Vektor3D(2, 2, 3);
        Vektor3D atest = new Vektor3D(2, 2, 2);
        Vektor3D btest = new Vektor3D(2, 2, 3);
        try {
            LineareAlgebra.angleDegree(a, b);
            LineareAlgebra.angleDegree(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(atest.z, a.z, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(btest.z, b.z, 0.0);
    }

    @Test
    public void angleDegreeFunction2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 3);
        double testa = 0;
        double testb = 0;
        double controllvalue = 11.31013;
        try {
            testa = LineareAlgebra.angleDegree(a, b);
            testb = LineareAlgebra.angleDegree(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(controllvalue, testb, 0.01);
        assertEquals(controllvalue, testb, 0.01);
    }

    @Test(expected = Exception.class)
    public void angleDegreeZero2D() throws Exception {
        Vektor2D a = new Vektor2D(0, 0);
        Vektor2D b = new Vektor2D(0, 0);
        double testa = 0;
        double testb = 0;

        testa = LineareAlgebra.angleDegree(a, b);
        testb = LineareAlgebra.angleDegree(b, a);


    }

    @Test
    public void angleDegree902D() {
        Vektor2D a = new Vektor2D(1, 0);
        Vektor2D b = new Vektor2D(0, 1);
        double testa = 0;
        double testb = 0;
        try {
            testa = LineareAlgebra.angleDegree(a, b);
            testb = LineareAlgebra.angleDegree(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(testa, testb, 0.0);
        assertEquals(90.0, testb, 0.01);
        assertEquals(90.0, testb, 0.01);

    }

    @Test
    public void angleDegreeConsistency2D() {
        Vektor2D a = new Vektor2D(2, 2);
        Vektor2D b = new Vektor2D(2, 3);
        Vektor2D atest = new Vektor2D(2, 2);
        Vektor2D btest = new Vektor2D(2, 3);
        try {
            LineareAlgebra.angleDegree(a, b);
            LineareAlgebra.angleDegree(b, a);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
    }


//RadToDegree Test

    @Test
    public void radToDegreeFunction() {
        double rad = Math.PI / 2;
        double degree;

        degree = LineareAlgebra.radToDegree(rad);

        assertEquals(90, degree, 0.0);
    }

    @Test
    public void radToDegreeConsistency() {
        double rad = Math.PI / 2;
        double radtest = Math.PI / 2;
        double degree;

        degree = LineareAlgebra.radToDegree(rad);

        assertEquals(radtest, rad, 0.0);
    }

//DegreeToRad Test

    @Test
    public void degreeToRadFunction() {
        double rad;
        double degree = 90;

        degree = LineareAlgebra.DegreeToRad(degree);

        assertEquals(Math.PI / 2, degree, 0.0);
    }

    @Test
    public void degreeToRadConsistency() {
        double rad;
        double degreetest = 90;
        double degree = 90;

        rad = LineareAlgebra.DegreeToRad(degree);

        assertEquals(degreetest, degree, 0.0);
    }

//Determinante Test

    @Test
    public void determinanteFunction3D() {
        Vektor3D a = new Vektor3D(2, 4, 6);
        Vektor3D b = new Vektor3D(2, 4, 6);
        Vektor3D c = new Vektor3D(2, 4, 6);
        double test;
        test = LineareAlgebra.determinante(a, b, c);
        assertEquals(0.0, test, 0.0);
        test = LineareAlgebra.determinante(b, a, c);
        assertEquals(0.0, test, 0.0);
    }

    @Test
    public void determinanteConsistency3D() {
        Vektor3D a = new Vektor3D(2, 4, 6);
        Vektor3D b = new Vektor3D(2, 4, 6);
        Vektor3D c = new Vektor3D(2, 4, 6);
        Vektor3D test = new Vektor3D(2, 4, 6);

        LineareAlgebra.determinante(a, b, c);

        assertEquals(test.x, a.x, 0.0);
        assertEquals(test.y, a.y, 0.0);
        assertEquals(test.z, a.z, 0.0);
        assertEquals(test.x, b.x, 0.0);
        assertEquals(test.y, b.y, 0.0);
        assertEquals(test.z, b.z, 0.0);
        assertEquals(test.x, c.x, 0.0);
        assertEquals(test.y, c.y, 0.0);
        assertEquals(test.z, c.z, 0.0);
    }

    @Test
    public void determinanteFunction2D() {
        Vektor2D a = new Vektor2D(2, 4);
        Vektor2D b = new Vektor2D(2, 4);
        double test;
        test = LineareAlgebra.determinante(a, b);
        assertEquals(0.0, test, 0.0);
        test = LineareAlgebra.determinante(b, a);
        assertEquals(0.0, test, 0.0);
    }

    @Test
    public void determinanteConsistency2D() {
        Vektor2D a = new Vektor2D(2, 4);
        Vektor2D b = new Vektor2D(2, 4);
        Vektor2D test = new Vektor2D(2, 4);

        LineareAlgebra.determinante(a, b);

        assertEquals(test.x, a.x, 0.0);
        assertEquals(test.y, a.y, 0.0);
        assertEquals(test.x, b.x, 0.0);
        assertEquals(test.y, b.y, 0.0);
    }

//Abs Test

    @Test
    public void absFunctionSingle() {
        double a = -6;
        double b = 7;

        a = LineareAlgebra.abs(a);
        b = LineareAlgebra.abs(b);

        assertEquals(6.0, a, 0.0);
        assertEquals(7.0, b, 0.0);
    }

    @Test
    public void absFunction3D() {
        Vektor3D a = new Vektor3D(3, -6, 9);
        Vektor3D b = new Vektor3D(-3, 6, 9);
        Vektor3D c = new Vektor3D(3, 6, -9);
        Vektor3D d = new Vektor3D(-3, -6, -9);
        Vektor3D e = new Vektor3D(3, 6, 9);

        a = LineareAlgebra.abs(a);
        b = LineareAlgebra.abs(b);
        c = LineareAlgebra.abs(c);
        d = LineareAlgebra.abs(d);
        e = LineareAlgebra.abs(e);

        assertEquals(3.0, a.x, 0.0);
        assertEquals(6.0, a.y, 0.0);
        assertEquals(9.0, a.z, 0.0);
        assertEquals(3.0, b.x, 0.0);
        assertEquals(6.0, b.y, 0.0);
        assertEquals(9.0, b.z, 0.0);
        assertEquals(3.0, c.x, 0.0);
        assertEquals(6.0, c.y, 0.0);
        assertEquals(9.0, c.z, 0.0);
        assertEquals(3.0, d.x, 0.0);
        assertEquals(6.0, d.y, 0.0);
        assertEquals(9.0, d.z, 0.0);
        assertEquals(3.0, e.x, 0.0);
        assertEquals(6.0, e.y, 0.0);
        assertEquals(9.0, e.z, 0.0);

    }

    @Test
    public void absFunction2D() {
        Vektor2D a = new Vektor2D(2, -4);
        Vektor2D b = new Vektor2D(-2, 4);
        Vektor2D c = new Vektor2D(-2, -4);
        Vektor2D d = new Vektor2D(2, 4);

        a = LineareAlgebra.abs(a);
        b = LineareAlgebra.abs(b);
        c = LineareAlgebra.abs(c);
        d = LineareAlgebra.abs(d);


        assertEquals(2.0, a.x, 0.0);
        assertEquals(4.0, a.y, 0.0);
        assertEquals(2.0, b.x, 0.0);
        assertEquals(4.0, b.y, 0.0);
        assertEquals(2.0, c.x, 0.0);
        assertEquals(4.0, c.y, 0.0);
        assertEquals(2.0, d.x, 0.0);
        assertEquals(4.0, d.y, 0.0);
    }

    @Test
    public void absConsisency() {
        double a = -6.0;
        double atest = -6.0;
        Vektor2D b = new Vektor2D(-2, -4);
        Vektor2D btest = new Vektor2D(-2, -4);
        Vektor3D c = new Vektor3D(-3, -6, -9);
        Vektor3D ctest = new Vektor3D(-3, -6, -9);

        LineareAlgebra.abs(a);
        LineareAlgebra.abs(b);
        LineareAlgebra.abs(c);

        assertEquals(atest, a, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(ctest.x, c.x, 0.0);
        assertEquals(ctest.y, c.y, 0.0);
        assertEquals(ctest.z, c.z, 0.0);
    }

    @Test
    public void absExtraTests() {
        Vektor2D a = new Vektor2D(0, 0);
        Vektor2D atest = new Vektor2D(0, 0);
        Vektor2D b = new Vektor2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Vektor2D btest = new Vektor2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Vektor2D c = new Vektor2D(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Vektor2D ctest = new Vektor2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        a = LineareAlgebra.abs(a);
        b = LineareAlgebra.abs(b);
        c = LineareAlgebra.abs(c);

        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
        assertEquals(ctest.x, c.x, 0.0);
        assertEquals(ctest.y, c.y, 0.0);
    }

//Show Test

    @Test
    public void showFunctionAndConsistency() {
        Vektor3D a = new Vektor3D(3, -3, 2);
        Vektor3D atest = new Vektor3D(3, -3, 2);
        Vektor2D b = new Vektor2D(3, 0);
        Vektor2D btest = new Vektor2D(3, 0);
        String c = "";
        String d = "";
        String e = "";
        c = LineareAlgebra.show(a);
        d = LineareAlgebra.show(b);

        assertNotSame(e, c);
        assertNotSame(e, d);

        System.out.println(c);
        System.out.println(d);

        assertEquals(atest.x, a.x, 0.0);
        assertEquals(atest.y, a.y, 0.0);
        assertEquals(atest.z, a.z, 0.0);
        assertEquals(btest.x, b.x, 0.0);
        assertEquals(btest.y, b.y, 0.0);
    }

    @Test
    public void angleover180() {
        Vektor3D temp = new Vektor3D(1, 0, 0);
        Vektor3D temptwo = new Vektor3D(0, -1, 0);

        try {
            System.out.println("" + LineareAlgebra.angleDegree(temp, temptwo));
            System.out.println("" + LineareAlgebra.angleRad(temp, temptwo));
            System.out.println("" + LineareAlgebra.cosEquation(temp, temptwo));
            System.out.println("" + LineareAlgebra.sinEquation(temp, temptwo));
        } catch (Exception e) {
            e.printStackTrace();
        }

        temp.setPosition(1, 0, 0);
        temptwo.setPosition(0, 1, 0);

        try {
            System.out.println("" + LineareAlgebra.angleDegree(temp, temptwo));
            System.out.println("" + LineareAlgebra.angleRad(temp, temptwo));
            System.out.println("" + LineareAlgebra.cosEquation(temp, temptwo));
            System.out.println("" + LineareAlgebra.sinEquation(temp, temptwo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}