package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class CalculatorAAATest {
    private CalculatorAAA calculator;

    @Before
    public void setUp() {

        System.out.println("Setup Method Executed");

        calculator = new CalculatorAAA();
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);

        System.out.println("Test Executed Successfully");
    }

    @After
    public void tearDown() {

        System.out.println("Teardown Method Executed");

        calculator = null;
    }
}
