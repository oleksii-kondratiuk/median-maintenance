package com.ifelsecoders.median.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxHeapTest {

    private MaxHeap maxHeap;

    @Before
    public void init() {
        maxHeap = new MaxHeap();
    }

    @Test
    public void insertMaximal() {
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(6);

        assertEquals(maxHeap.storage[0], 6);
        assertEquals(maxHeap.storage[1], 2);
        assertEquals(maxHeap.storage[2], 4);

        maxHeap.insert(5);

        assertEquals(maxHeap.storage[0], 6);
        assertEquals(maxHeap.storage[1], 5);
        assertEquals(maxHeap.storage[2], 4);
        assertEquals(maxHeap.storage[3], 2);
    }

}