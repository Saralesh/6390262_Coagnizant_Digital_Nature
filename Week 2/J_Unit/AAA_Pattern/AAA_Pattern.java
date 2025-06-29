package com.example;


import org.junit.jupiter.api.*;

public class AAAPatternTest {

    Calculator calc;

    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }

    @Test
    void testAddition_AAA() {
        // Arrange done in @BeforeEach
        // Act
        int result = calc.add(10, 5);
        // Assert
        Assertions.assertEquals(15, result);
    }
}