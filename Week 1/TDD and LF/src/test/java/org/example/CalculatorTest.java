package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {

        Calculator calculator = new Calculator();

        int result = calculator.add(5, 3);

        System.out.println("Addition Result = " + result);

        assertEquals(8, result);
    }
}
