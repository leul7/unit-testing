
/*
 * TCSS 305 – Winter 2018 Assignment 1 – Testing.
 */

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;

/**
 * This program tests the circle class using the JUnit framework.
 * 
 * @author Leul Amare.
 * 
 * @version January 17.
 * 
 */
public class CircleTest {

    /**
     * A tolerance used to compare the double values for equality.
     */
    private static final double TOLERANCE = .000001;

    /** A Circle to use in the test. */
    private Circle myCircle;

    /** A method to initialize the test fixtures before each test. */
    // This method runs before each method.
    @Before
    public void setUp() { // no need to throw any exception.
        myCircle = new Circle(); // Creates a circle object.

    }

    /**
     * Test method for {@link Circle#Circle()}.
     * 
     * Tests the default constructor for each default value.
     */
    @Test
    public void tesDefaultConstructor() {
        assertEquals(1.0, myCircle.getRadius(), TOLERANCE);
        assertEquals(new Point2D.Double(0.0, 0.0), myCircle.getCenter());
        assertEquals(Color.BLACK, myCircle.getColor());

    }

    /**
     * Test method for
     * {@link Circle#Circle(double, java.awt.geom.Point2D, java.awt.Color)}.
     * 
     * Tests the overloaded constructor for each passed value.
     */
    @Test
    public void testOverloadedConstructor() {
        // Non default circle with passed values.
        final Circle cr = new Circle(6.0, new Point2D.Double(33.72, 42.39), Color.GRAY);

        assertEquals(6.0, cr.getRadius(), TOLERANCE);
        assertEquals(new Point2D.Double(33.72, 42.39), cr.getCenter());
        assertEquals(Color.GRAY, cr.getColor());

    }

    /**
     * Test method for
     * {@link Circle#Circle(double, java.awt.geom.Point2D, java.awt.Color)} for a
     * negative radius.
     * 
     * Tests the overloaded constructor for a negative radius.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testOverloadedConstructorNegativeRadius() {
        new Circle(-7.0, new Point2D.Double(0.0, 0.0), Color.GREEN);
    }

    /**
     * Test method for
     * {@link Circle#Circle(double, java.awt.geom.Point2D, java.awt.Color)} for a
     * zero radius.
     * 
     * Tests the overloaded constructor for a zero radius.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOverloadedConstructorZeroRadius() {
        new Circle(0.0, new Point2D.Double(0.0, 0.0), Color.GREEN);
    }

    /**
     * Test method for
     * {@link Circle#Circle(double, java.awt.geom.Point2D, java.awt.Color)} for a
     * null color.
     * 
     * Tests the overloaded constructor for a null center.
     */

    @Test(expected = NullPointerException.class)
    public void testOverloadedConstructorNullPoint2D() {
        new Circle(1.0, null, Color.GREEN);
    }

    /**
     * Test method for
     * {@link Circle#Circle(double, java.awt.geom.Point2D, java.awt.Color)} for a
     * null color.
     * 
     * Tests the overloaded constructor for a null color.
     */

    @Test(expected = NullPointerException.class)
    public void testOverloadedConstructorNullColor() {
        new Circle(1.0, new Point2D.Double(0.0, 0.0), null);
    }

    /**
     * Test method for {@link Circle#setRadius(double)}.
     * 
     * Tests the radius setting.
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(9.0);
        assertEquals(9.0, myCircle.getRadius(), TOLERANCE);
    }

    /**
     * Test method for {@link Circle#setRadius(double)} for a negative radius.
     * 
     * Tests the radius setting for a negative value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusNull() {
        myCircle.setRadius(-3.0);
    }

    /**
     * Test method for {@link Circle#setCenter(java.awt.geom.Point2D)}.
     * 
     * Tests the center setting.
     */

    @Test
    public void testSetCenter() {
        myCircle.setCenter(new Point2D.Double(62.00, 56.00));
        assertEquals(new Point2D.Double(62.00, 56.00), myCircle.getCenter());

    }

    /**
     * Test method for {@link Circle#setCenter(java.awt.geom.Point2D)} for a null
     * center.
     * 
     * Tests the center setting for a null pointer.
     */

    @Test(expected = NullPointerException.class)
    public void testSetCenterNull() {
        myCircle.setCenter(null);

    }

    /**
     * Test method for {@link Circle#setColor(java.awt.Color)}.
     * 
     * Tests the color setting.
     */

    @Test
    public void testSetColor() {
        myCircle.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, myCircle.getColor());

    }

    /**
     * Test method for {@link Circle#setColor(java.awt.Color)} for a null color.
     * 
     * Tests the color setting for a null pointer.
     */

    @Test(expected = NullPointerException.class)
    public void testSetColorNull() {
        myCircle.setColor(null);

    }

    /**
     * Test method for {@link Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {

    }

    /**
     * Test method for {@link Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {

    }

    /**
     * Test method for {@link Circle#getColor()}.
     */
    @Test
    public void testGetColor() {

    }

    /**
     * Test method for {@link Circle#calculateDiameter()}.
     * 
     * Tests for both default and non-default circle diameter calculation.
     */
    @Test
    public void testCalculateDiameter() {
        assertEquals(2 * myCircle.getRadius(), myCircle.calculateDiameter(), TOLERANCE);

        // Non default circle.
        final Circle cr2 = new Circle(9.0, new Point2D.Double(0.0, 0.0), Color.YELLOW);
        assertEquals(2 * cr2.getRadius(), cr2.calculateDiameter(), TOLERANCE);

    }

    /**
     * Test method for {@link Circle#calculateCircumference()}.
     * 
     * Tests for both default and non-default circle circumference calculation.
     */
    @Test
    public void testCalculateCircumference() {
        assertEquals(2 * myCircle.getRadius() * Math.PI, myCircle.calculateCircumference(),
                     TOLERANCE);

        // Non default circle.
        final Circle cr3 = new Circle(9.0, new Point2D.Double(0.0, 0.0), Color.YELLOW);
        assertEquals(2 * cr3.getRadius() * Math.PI, cr3.calculateCircumference(), TOLERANCE);

    }

    /**
     * Test method for {@link Circle#calculateArea()}.
     * 
     * Tests for both default and non-default circle Area calculation.
     */
    @Test
    public void testCalculateArea() {
        assertEquals(Math.pow(myCircle.getRadius(), 2) * Math.PI, myCircle.calculateArea(),
                     TOLERANCE);

        // Non default circle.
        final Circle cr1 = new Circle(8.0, new Point2D.Double(0.0, 0.0), Color.RED);
        assertEquals(Math.pow(cr1.getRadius(), 2) * Math.PI, cr1.calculateArea(), TOLERANCE);

    }

    /**
     * Test method for {@link Circle#toString()}.
     * 
     * Tests for the correct output from the toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Circle [radius=1.00, center=Point2D.Double[0.0, 0.0], "
                     + "color=java.awt.Color[r=0,g=0,b=0]]", myCircle.toString());

    }

}
