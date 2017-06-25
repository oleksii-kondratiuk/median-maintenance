package com.ifelsecoders.median;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class MedianCounterTest {

    private MedianCounter medianCounter;

    @Before
    public void setUp() throws Exception {
        medianCounter = new MedianCounter();
    }

    @Test
    public void testCountMediansInFile() throws Exception {
        File fileWithInputValues = new File(getClass().getResource("/Median.txt").getFile());
        Integer mediansInFile = medianCounter.countMediansInFile(fileWithInputValues);
        System.out.println(mediansInFile);

        System.out.println(mediansInFile % 10000);
    }

    @Test
    public void testSmailInput() {
        File fileWithInputValues = new File(getClass().getResource("/test_small_input.txt").getFile());
        assertEquals(32, medianCounter.countMediansInFile(fileWithInputValues).intValue());
    }

    //6331 + 2793 + 2793 + 2793 + 2793 + 1640 + 2793 + 2793 + 6331 = 31060
    @Test
    public void testSmallMedianInput() {
        File fileWithInputValues = new File(getClass().getResource("/small_median_input.txt").getFile());
        assertEquals(31060, medianCounter.countMediansInFile(fileWithInputValues).intValue());
    }

    // 1 + 1 + 10 + 10 + 100 + 10 + 10 = 142
    @Test
    public void test1() {
        File fileWithInputValues = new File(getClass().getResource("/test1.txt").getFile());
        assertEquals(142, medianCounter.countMediansInFile(fileWithInputValues).intValue() % 10000);
    }

    @Test
    public void test2() {
        File fileWithInputValues = new File(getClass().getResource("/test2.txt").getFile());
        assertEquals(9335, medianCounter.countMediansInFile(fileWithInputValues).intValue() % 10000);
    }
}