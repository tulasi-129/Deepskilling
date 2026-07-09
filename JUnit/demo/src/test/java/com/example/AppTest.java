package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAddition() {
        int a = 10;
        int b = 20;
        int result = a + b;

        assertEquals(30, result);
    }

    @Test
    public void testMultiplication() {
        int a = 5;
        int b = 4;
        int result = a * b;

        assertEquals(20, result);
    }
}