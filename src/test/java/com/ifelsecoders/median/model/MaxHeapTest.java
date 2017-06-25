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

    @Test
    public void extractMaximal() {
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(6);
        maxHeap.insert(7);

        assertEquals(7, maxHeap.storage[0]);
        assertEquals(6, maxHeap.storage[1]);
        assertEquals(4, maxHeap.storage[2]);
        assertEquals(2, maxHeap.storage[3]);

        assertEquals(7, maxHeap.extractTopValue().intValue());

        assertEquals(maxHeap.storage[0], 6);
        assertEquals(maxHeap.storage[1], 2);
        assertEquals(maxHeap.storage[2], 4);
    }

    @Test
    public void checkMaximal() {
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(6);

        assertEquals(6, maxHeap.storage[0]);
        assertEquals(2, maxHeap.storage[1]);
        assertEquals(4, maxHeap.storage[2]);

        assertEquals(6, maxHeap.checkTopValue().intValue());

        assertEquals(6, maxHeap.storage[0]);
        assertEquals(2, maxHeap.storage[1]);
        assertEquals(4, maxHeap.storage[2]);
    }
}