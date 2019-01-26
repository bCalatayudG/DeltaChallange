package com.consultants.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CodingTest {

    private Coding coding;
    private int[] arr;
    private int expectedSum;
    private int expectedSumNeg;

    @Before
    public void setup() {
        //6+7 = 13
        arr = new int[]{2,3,6,4,2,6,7};
        coding = new Coding();

        expectedSum = 13;
        expectedSumNeg = 14;
    }


    @Test
    public void positiveFindSum() {

        assertEquals(expectedSum, coding.findSum(arr));

    }

    @Test
    public void negativeFindSum() {

        assertNotEquals(expectedSumNeg, coding.findSum(arr));

    }

    @After
    public void tearDown() {

    }
}
