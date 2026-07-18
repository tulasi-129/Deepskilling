package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {

    private Calculator calculator;

    // Setup Method
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator object created.");
    }

    // Test Method using AAA Pattern
    @Test
    public void testAddition() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);

        System.out.println("Test Passed.");
    }

    // Teardown Method
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator object destroyed.");
    }
}