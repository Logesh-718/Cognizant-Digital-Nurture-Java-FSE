package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class MathOperationsTest {
    MathOperations math = new MathOperations();

    @Test
    public void testAdd() {

        int result = math.add(10, 5);

        System.out.println("Addition = " + result);

        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {

        int result = math.subtract(10, 5);

        System.out.println("Subtraction = " + result);

        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {

        int result = math.multiply(10, 5);

        System.out.println("Multiplication = " + result);

        assertEquals(50, result);
    }

    @Test
    public void testDivide() {

        int result = math.divide(10, 5);

        System.out.println("Division = " + result);

        assertEquals(2, result);
    }
}
