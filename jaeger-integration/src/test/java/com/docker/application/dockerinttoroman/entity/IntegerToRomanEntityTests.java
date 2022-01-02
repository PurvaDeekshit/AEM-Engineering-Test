package com.docker.application.dockerinttoroman.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerToRomanEntityTests {

    private IntegerToRoman integerToRomanObject;

    @BeforeEach
    public void setup(){
        integerToRomanObject = new IntegerToRoman();
    }

    @Test
    public void testValidInput() {
        Integer actualResult = integerToRomanObject.parseInput("1");
        Integer expectedResult = 1;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testInvalidInput() {
        Integer actualResult = integerToRomanObject.parseInput("abcd");
        assertNull(actualResult);
    }

    @Test
    public void testValidInputRange() {
        Boolean actualResult = integerToRomanObject.validateInputRange(1);
        assertTrue(actualResult);
    }

    @Test
    public void testInvalidInputRange() {
        Boolean actualResult = integerToRomanObject.validateInputRange(0);
        assertFalse(actualResult);
    }

    @Test
    public void testGetRoman() {
        String actualResult = integerToRomanObject.getRoman(10);
        String expectedResult = "X";
        assertEquals(expectedResult, actualResult);
    }

}